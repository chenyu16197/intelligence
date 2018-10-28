package com.baobaotao.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baobaotao.beta.BaseDay;
import com.baobaotao.beta.BaseWeek;
import com.baobaotao.domain.BaseResult;
@Service
public class BaseDayProccessor implements Proccossor{
	
	public BaseResult getDate(String date) {
		BaseResult result = new BaseResult();
		
		Map<String, String> map = BaseDay.getInstance();
		
		if(map == null) {
			return result;
		}
		
		String s = map.get(date);
		
		if(s == null || "".equals(s)) {
			return result;
		}
		
		
		result.setStartTime(s);
		result.setIsSearched(true);
		
		return result;
		
	}



}
