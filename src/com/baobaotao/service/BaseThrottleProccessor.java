package com.baobaotao.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baobaotao.beta.BaseHoliday;
import com.baobaotao.beta.BaseThrottle;
import com.baobaotao.domain.BaseResult;

@Service
public class BaseThrottleProccessor implements Proccossor{
	

	
	public BaseResult getDate(String date) {
		BaseResult result = new BaseResult();
		
		Map<String, String> map = BaseThrottle.getInstance();
		
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
