package com.baobaotao.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
public class ExcelUtil {
	 /**
     * 读入excel文件第一个表格，解析后返回,返回数据不包括表头第一行
     * @param file
     * @throws IOException
     * @author wangjy25557
     */
    public static List<?> readExcelFirstSheet(MultipartFile file) throws IOException{
    	//检查文件
    	checkFile(file);
    	//获得Workbook工作薄对象
    	Workbook workbook = getWorkBook(file);
    	//创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
    	List<String[]> list = new ArrayList<String[]>();
    	if(workbook != null){
    			//获得当前第一个sheet工作表
    			Sheet sheet = workbook.getSheetAt(0);
    			if(sheet == null){
    				return list;
    			}
    			//获取计算公式的值的计算器
    			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
    			//获得当前sheet的开始行
    			int firstRowNum  = sheet.getFirstRowNum();
    			//获得当前sheet的结束行
    			int lastRowNum = sheet.getLastRowNum();
    			//获取第一行列数,也就是表头行
    			Row row0 = sheet.getRow(firstRowNum);
    			int totalNum = row0.getPhysicalNumberOfCells();
    			//获取第一行列数，循环除了第一行的所有行
    			for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){
    				//获得当前行
    				String[] cells = new String[3];
    				Row row = sheet.getRow(rowNum);
    				if(row == null){
    					cells[0] = "";
    					list.add(cells);
    					continue;
    				}
    				
    				//循环当前行
    				for(int cellNum = 0; cellNum < totalNum ;cellNum++){
    					Cell cell = row.getCell(cellNum);
    					cells[cellNum] = getValueByCellEvaluate(cell);
    				}
    				list.add(cells);
    			}
    		workbook.close();
    	}
    	return list;
    }
    public static void checkFile(MultipartFile file) throws IOException{
        //判断文件是否存在
        if(null == file){
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if(!fileName.endsWith("xls") && !fileName.endsWith("xlsx")){
            throw new IOException(fileName + "不是excel文件");
        }
    }
    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007 及2007以上
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
        }
        
        return workbook;
    }
    /**
     * @author wangjy25557
     * @param evaluator 可以直接计算出公式的值
     * @param cell 
     * @return 
     */
    public static String getValueByCellEvaluate(Cell cell){
    	String cellValue = "";
    	if(cell == null){
    		return cellValue;
    	}
    	//把数字当成String来读，避免出现1读成1.0的情况
    	//判断数据的类型
    	switch (cell.getCellType()){
    	case Cell.CELL_TYPE_NUMERIC: //数字
    		if (HSSFDateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				cellValue = DateUtil.convertDateToString("yyyy-MM-dd",date);
			} else {
				cellValue = new DecimalFormat("0.###").format(cell.getNumericCellValue());
			}
    		break;
    	case Cell.CELL_TYPE_STRING: //字符串
    		cellValue = String.valueOf(cell.getStringCellValue());
    		break;
    	case Cell.CELL_TYPE_BOOLEAN: //Boolean
    		cellValue = String.valueOf(cell.getBooleanCellValue());
    		break;
    	case Cell.CELL_TYPE_BLANK: //空值
    		cellValue = "";
    		break;
    	case Cell.CELL_TYPE_ERROR: //故障
    		cellValue = "非法字符";
    		break;
    	default:
    		cellValue = "";
    		break;
    	}
		return cellValue;
    	
    	
    }
 // 实现excel数据填充后excel文件下载
 	public static void uploadWorkBook(Workbook wb1, HttpServletResponse response,
 			List<String[]> readExcel,String fileName) throws IOException {
 		ByteArrayOutputStream os = new ByteArrayOutputStream();
 		try {
 			poiCreateWorkBook(wb1,readExcel).write(os);
 		} catch (IOException e) {
 		}
 		byte[] content = os.toByteArray();

 		// 设置response参数，可以打开下载页面
 		response.reset();
 		response.setContentType("application/vnd.ms-excel;charset=utf-8");
 		response.setHeader("Content-Disposition",
 				"attachment;filename=" + new String((fileName).getBytes("GB2312"), "ISO8859-1"));
 		ServletOutputStream out = response.getOutputStream();
 		try (InputStream is = new ByteArrayInputStream(content);
 				BufferedInputStream bis = new BufferedInputStream(is);
 				BufferedOutputStream bos = new BufferedOutputStream(out);) {
 			byte[] buff = new byte[2048];
 			int bytesRead;
 			// Simple read/write loop.
 			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
 				bos.write(buff, 0, bytesRead);
 			}
 		} catch (final IOException e) {
 			throw e;
 		}
 	}
    
    
    public static Workbook poiCreateWorkBook(Workbook wbook,List<String[]> readExcel) {
		int rowTotals = 0;
		// 创建excel工作簿
		Workbook wb = wbook;
		// 创建第一个sheet（页），并命名
		Sheet sheet = wb.getSheetAt(0);
				
		// list集合 大小
		int listLen = readExcel.size();
		// 设置每行每列的值
		for (short i = 1; i <= listLen; i++) {
			// 遍历的行计数
			rowTotals = rowTotals + 1;
			// Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
			// 创建一行，在页sheet上
			Row row = sheet.getRow((short) rowTotals);	
			if (row == null) {
				row = sheet.createRow((short) rowTotals);
			}
			// 渲染单元格信息
			String [] strs = readExcel.get(i - 1);
			
			for (int j = 1; j < strs.length  ; j++) {
				if (strs[0] == null || "".equals(strs[0])) {
					Cell rowDataCell  = row.createCell(0);
					rowDataCell.setCellValue("");
				}
				Cell rowDataCell  = row.createCell(j);
				rowDataCell.setCellValue(strs[j]);
			}
			
		}
		return wb;
	}
    
}
