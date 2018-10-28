package com.baobaotao.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.baobaotao.domain.BaseResult;
import com.baobaotao.util.RegexUtil;
@Service
public class BaseRealDateProccessor implements Proccossor{
	
	public BaseResult getDate(String date) {
		
		BaseResult result = new BaseResult();
		
		
		SimpleDateFormat sdf11 = new SimpleDateFormat("yyyyMMdd-HHmmss");
		
		String[] aa = new String[48];
		aa[0] = "M月d日";
		aa[1] = "MM月d日";
		aa[2] = "M月dd日";
		aa[3] = "MM月dd日";
		aa[4] = "yyyy年M月d日";
		aa[5] = "yyyy年MM月d日";
		aa[6] = "yyyy年M月dd日";
		aa[7] = "yyyy年MM月dd日";
		aa[8] = "yy年M月d日";
		aa[9] = "yy年MM月d日";
		aa[10] = "yy年M月dd日";
		aa[11] = "yy年MM月dd日";
		
		aa[12] = "M月d日HH时mm分ss秒";
		aa[13] = "MM月d日HH时mm分ss秒";
		aa[14] = "M月dd日HH时mm分ss秒";
		aa[15] = "MM月dd日HH时mm分ss秒";
		aa[16] = "yyyy年M月d日HH时mm分ss秒";
		aa[17] = "yyyy年MM月d日HH时mm分ss秒";
		aa[18] = "yyyy年M月dd日HH时mm分ss秒";
		aa[19] = "yyyy年MM月dd日HH时mm分ss秒";
		aa[20] = "yy年M月d日HH时mm分ss秒";
		aa[21] = "yy年MM月d日HH时mm分ss秒";
		aa[22] = "yy年M月dd日HH时mm分ss秒";
		aa[23] = "yy年MM月dd日HH时mm分ss秒";
		
		aa[24] = "M月d日HH时mm分";
		aa[25] = "MM月d日HH时mm分";
		aa[26] = "M月dd日HH时mm分";
		aa[27] = "MM月dd日HH时mm分";
		aa[28] = "yyyy年M月d日HH时mm分";
		aa[29] = "yyyy年MM月d日HH时mm分";
		aa[30] = "yyyy年M月dd日HH时mm分";
		aa[31] = "yyyy年MM月dd日HH时mm分";
		aa[32] = "yy年M月d日HH时mm分";
		aa[33] = "yy年MM月d日HH时mm分";
		aa[34] = "yy年M月dd日HH时mm分";
		aa[35] = "yy年MM月dd日HH时mm分";
		
		aa[36] = "M月d日HH时";
		aa[37] = "MM月d日HH时";
		aa[38] = "M月dd日HH时";
		aa[39] = "MM月dd日HH时";
		aa[40] = "yyyy年M月d日HH时";
		aa[41] = "yyyy年MM月d日HH时";
		aa[42] = "yyyy年M月dd日HH时";
		aa[43] = "yyyy年MM月dd日HH时";
		aa[44] = "yy年M月d日HH时";
		aa[45] = "yy年MM月d日HH时";
		aa[46] = "yy年M月dd日HH时";
		aa[47] = "yy年MM月dd日HH时";
		
//		aa[2] = "yy年MM月dd日";
//		aa[2] = "yy年MM月dd日";
//		aa[1] = "yy年M月d日";
//		aa[2] = "yyyy年MM月dd日HH时mm分ss秒";
		HashSet set=new HashSet();
		try {
			for(String xx : aa) {
				if (xx.length() != date.length()) {
					continue;
				}
				SimpleDateFormat sdf = new SimpleDateFormat(xx);
//				String aString = sdf.format(new Date());
//				System.out.println(aString);
				Date time = new Date();
				try {
					time = sdf.parse(date);
				}catch (ParseException e) {
					set.add("日期格式错误");
					continue;
				}
				
				String aString = sdf11.format(time);
				if (aString != null && !"".equals(aString)) {
					
					if (!xx.contains("年")) {
						if (Integer.valueOf(aString.substring(4,8)) < 426) {
							aString = "2019" + aString.substring(4);
						} else {
							aString= "2018" + aString.substring(4);
						}
					}
					set.add(aString);
					break;
				}
					
				}
				System.out.println(set.size());
				if (set.size() == 2) {
					Iterator<String> it = set.iterator();
					while (it.hasNext()){
						String startTime = it.next();
						if ("日期格式错误".equals(startTime)) {
							continue;
						} else {
							result.setIsSearched(true);
							result.setStartTime(startTime);
						}
					}
					
			} else {
				Iterator<String> it = set.iterator();
				while (it.hasNext()){
					String startTime = it.next();
					if ("日期格式错误".equals(startTime)) {
						result.setIsSearched(false);
					} else {
						result.setIsSearched(true);
						result.setStartTime(startTime);
					}
				}
		
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}



}
