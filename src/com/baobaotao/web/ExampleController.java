package com.baobaotao.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.baobaotao.domain.BaseResult;
import com.baobaotao.service.ExampleFactory;
import com.baobaotao.util.ExcelUtil;

@Controller // 标注成为一个SpringMVC的Controller
public class ExampleController {
	
	@Autowired
	private ExampleFactory exampleFactory;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value = "/index.html")
	public String loginPage() {
		return "index";
	}
	/**
	 *  提交判断
	 * @param ques
	 * @return
	 */
	@RequestMapping(value = "answer.html", method = RequestMethod.POST)
	@ResponseBody
	public String answer(@RequestParam("ques") String  ques,HttpServletResponse response) {
			JSONObject res = new JSONObject();
			BaseResult baseResult = exampleFactory.getDate(ques);
			if (baseResult.getIsSearched()) {
				res.put("success", true);
				if (baseResult.getEndTime() != null && !"".equals(baseResult.getEndTime())) {
					res.put("msg",baseResult.getStartTime() + "  " + baseResult.getEndTime());
				} else {
					res.put("msg",baseResult.getStartTime());
				}
				
			} else {
				res.put("success", false);
				res.put("msg", baseResult.getErrorMessage());
			}
			 response.setContentType("text/html;charset=utf-8");
		     response.setHeader("Cache-Control", "no-cache");  
		     PrintWriter out;
			try {
				out = response.getWriter();
				out.print(res.toJSONString());
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //输出中文，这一句一定要放到response.setContentType("text/html;charset=utf-8"),  response.setHeader("Cache-Control", "no-cache")后面，否则中文返回到页面是乱码  
				
		return res.toJSONString();
	}
	
	/**
	 * 导出 
	 * @param uploadFile
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "importFile.html", method = RequestMethod.POST)
	@ResponseBody
	public String importFile(@RequestParam("uploadFile") MultipartFile  uploadFile, HttpServletResponse response) {
		List<String[]> readExcel = new ArrayList<String[]>();
		JSONObject res = new JSONObject();
		try {
			//获取excel的list
			readExcel = (List<String[]>) ExcelUtil.readExcelFirstSheet(uploadFile);
			
			
			for (String[] strs : readExcel) {
				BaseResult baseResult = exampleFactory.getDate(strs[0]);
				if (baseResult.getIsSearched()) {
					strs[1] = baseResult.getStartTime();
					if (baseResult.getEndTime() != null && !"".equals(baseResult.getEndTime())) {
						strs[2] = baseResult.getEndTime();
					}
				} else {
					strs[1] = baseResult.getErrorMessage();
					strs[2] = "";
				}
			}
			
			
			// 读取excel模板
			Workbook workbook = ExcelUtil.getWorkBook(uploadFile);
			// 导出excel
			ExcelUtil.uploadWorkBook(workbook, response, readExcel, uploadFile.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
			res.put("success", false);
			res.put("msg", e.getMessage());
			return res.toJSONString();
		}
		res.put("success", true);
		res.put("msg", "获取成功！");
		return res.toJSONString();
	}

}