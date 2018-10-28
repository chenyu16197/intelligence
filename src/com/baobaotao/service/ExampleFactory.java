package com.baobaotao.service;

import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.baobaotao.beta.BaseDay;
import com.baobaotao.beta.BaseHoliday;
import com.baobaotao.beta.BaseHolidayNext;
import com.baobaotao.beta.BaseHolidayPrevious;
import com.baobaotao.beta.BaseKeywordPreviousOrNext;
import com.baobaotao.beta.BaseThrottle;
import com.baobaotao.beta.BaseThrottleNext;
import com.baobaotao.beta.BaseThrottlePreviois;
import com.baobaotao.beta.BaseWeek;
import com.baobaotao.beta.BaseWeekNext;
import com.baobaotao.beta.BaseWeekPrevious;
import com.baobaotao.domain.BaseContext;
import com.baobaotao.domain.BaseResult;


@Service
public class ExampleFactory {
	
	private final String NOT_SEARCH_DATE_WORD = "未提取出时间词语";
	
	@Autowired
	private BaseCommonProccessor baseCommonProccessor;
	
	@Autowired
	private BaseHolidayProccessor baseHolidayProccessor;
	
	@Autowired
	private BaseThrottleProccessor baseThrottleProccessor;
	
	@Autowired
	private BaseDayProccessor baseDayProccessor;
	
	@Autowired
	private BaseWeekProccessor baseWeekProccessor;
	
	@Autowired
	private BaseRealDateProccessor baseRealDateProccessor;
	
	
	public BaseResult getDate(String data) {
		
		BaseResult result = new BaseResult();
		//1.是否为空，预处理
		if(data == null) {
			return result;
		}
		
		data = data.replaceAll(" ", "");
		
		//2.是否为空串
		if("".equals(data.trim())) {
			return result;
		}
		
		
		
		//3.完全匹配的节日
		result = baseHolidayProccessor.getDate(data);
		
		if(result.getIsSearched()) {
			return result;
		}
		
		//4.完全匹配的节日
		result = baseThrottleProccessor.getDate(data);
		
		if(result.getIsSearched()) {
			return result;
		}
		//4.1 完全匹配的天   今天，明天，今日之类的
		result = baseDayProccessor.getDate(data);
		
		if(result.getIsSearched()) {
			return result;
		}
		
		//4.2 完全匹配的星期   
		result = baseWeekProccessor.getDate(data);
		
		if(result.getIsSearched()) {
			return result;
		}
		
		
		
		
		
		//5.前一个，后一个的简单处理
		Integer codeOfKeyword = BaseKeywordPreviousOrNext.getEntryOfKeyword(data);
		
		//5.1 如果有关键字
		if(codeOfKeyword != null) {
			//Class<?> clazz = getMyClass(data, codeOfKeyword);
			BaseContext context = getMyClass(data, codeOfKeyword);
			
			Class<?> clazz = context.getClazz();
			
			if(clazz != null && context.getEntry()!= null && context.getEntry().getKey() !=null && !context.getEntry().getKey().equals("")) {
				ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
				
				if(applicationContext != null ) {
					Proccossor proccossor = (Proccossor)applicationContext.getBean(clazz);
					
					String mydata = (String)context.getEntry().getKey();
					result = proccossor.getDate(mydata);
					
					if(result.getIsSearched()) {
						return result;
					}
				}
			}
		}
		
		//5.2如果没有关键字
		if(codeOfKeyword == null) {
            Entry entryBaseHoliday = BaseHoliday.getEntry(data);
			
			//假期
			if(entryBaseHoliday != null) {
				result.setStartTime((String)entryBaseHoliday.getValue());
				result.setIsSearched(true);
				return result;
			}
			
			//节气
			Entry entryBaseThrottle = BaseThrottle.getEntry(data);
			
			if(entryBaseThrottle != null) {
				result.setStartTime((String)entryBaseThrottle.getValue());
				result.setIsSearched(true);
				return result;
			}
			
			//星期
            Entry entryBaseWeek = BaseWeek.getEntry(data);
            
            if(entryBaseWeek != null) {
            	result.setStartTime((String)entryBaseWeek.getValue());
				result.setIsSearched(true);
				return result;
            }
            
            //天
            Entry entryBaseDay = BaseDay.getEntry(data);
            
            if(entryBaseDay != null) {
            	result.setStartTime((String)entryBaseDay.getValue());
				result.setIsSearched(true);
				return result;
            }
          
		}
		
		result = baseRealDateProccessor.getDate(data);
		if(result.getIsSearched()) {
			return result;
		}
		
		//2.1特殊处理，有些直接命中
		result = baseCommonProccessor.getDate(data);
		
		if(result.getIsSearched()) {
			return result;
		}
				
		
		
		
		
		return result;
	}
	
	
	/**
	 * 和关键字有关系
	 * @param data
	 * @param codeOfKeyword
	 * @return
	 */
	public BaseContext getMyClass(String data, Integer codeOfKeyword) {
		
		BaseContext context = new BaseContext();
		
		//往前找
		if(codeOfKeyword.compareTo(-1) == 0) {
			Entry entryBaseHoliday = BaseHoliday.getEntry(data);
			
			//假期
			if(entryBaseHoliday != null) {
				context.setClazz(BaseHolidayPreviousProccessor.class);
				context.setEntry(entryBaseHoliday);
				return context;
			}
			
			//节气
			Entry entryBaseThrottle = BaseThrottle.getEntry(data);
			
			if(entryBaseThrottle != null) {
				//return BaseThrottlePreviousProccessor.class;
				context.setClazz(BaseThrottlePreviousProccessor.class);
				context.setEntry(entryBaseThrottle);
				return context;
			}
			
			//星期
            Entry entryBaseWeek = BaseWeek.getEntry(data);
			
			if(entryBaseWeek != null) {
				//return BaseWeekPreviousProccessor.class;
				context.setClazz(BaseWeekPreviousProccessor.class);
				context.setEntry(entryBaseWeek);
				return context;
			}
			
		}
		
		
		
		//往后找
		if(codeOfKeyword.compareTo(1) == 0) {
			Entry entryBaseHoliday = BaseHoliday.getEntry(data);
			
			//假期
			if(entryBaseHoliday != null) {
				//return BaseHolidayNextProccessor.class;
				context.setClazz(BaseHolidayNextProccessor.class);
				context.setEntry(entryBaseHoliday);
				return context;
			}
			
			//节气
			Entry entryBaseThrottle = BaseThrottle.getEntry(data);
			
			if(entryBaseThrottle != null) {
				//return BaseThrottleNextProccessor.class;
				context.setClazz(BaseThrottleNextProccessor.class);
				context.setEntry(entryBaseThrottle);
				return context;
			}
			
			//星期
            Entry entryBaseWeek = BaseWeek.getEntry(data);
			
			if(entryBaseWeek != null) {
				//return BaseWeekNextProccessor.class;
				context.setClazz(BaseWeekNextProccessor.class);
				context.setEntry(entryBaseWeek);
				return context;
			}
			
		}
		
		
		return context;
	}
	
	
	
	public static void main(String[] args) {
		String data = " adsf adf 哈哈哈  ";
		data = data.replaceAll(" ", "");
		
		
		System.out.println("aab".indexOf("aab"));
		
		System.out.println(data);
	}

}
