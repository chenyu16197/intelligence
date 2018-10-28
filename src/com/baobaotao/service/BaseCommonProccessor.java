package com.baobaotao.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.baobaotao.domain.BaseResult;

@Service
public class BaseCommonProccessor implements Proccossor{
	
	private final static String TRADE_DAY_PREVIOUS = "20181026-000000";
	private final static String TRADE_DAY_NEXT = "20181029-000000";
	
	private final static String YYYYMMDD_HHmmss = "yyyyMMdd-HHmmss";

	
	public BaseResult getDate(String s) {
		BaseResult result = new BaseResult();
		
		if(s.contains("当月") || s.contains("本月")) {
			result.setStartTime("20181001-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("七夕") && s.contains("晚上")) {
			result.setStartTime("20181001-000000");
			result.setEndTime("");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("本周") || s.contains("这周")) {
			result.setStartTime("20181022-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("今年")) {
			result.setStartTime("20180101-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("去年")) {
			result.setStartTime("20170101-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("明年")) {
			result.setStartTime("20190101-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下周一")) {
			result.setStartTime("20181029-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下周二")) {
			result.setStartTime("20181030-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下周三")) {
			result.setStartTime("20181031-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下周四")) {
			result.setStartTime("20181101-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下周五")) {
			result.setStartTime("20181102-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下周六")) {
			result.setStartTime("20181103-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下周日")) {
			result.setStartTime("20181104-000000");
			result.setIsSearched(true);
			return result;
		}
		
		
		if(s.equals("现在") || s.contains("现在")) {
			result.setStartTime(new SimpleDateFormat(YYYYMMDD_HHmmss).format(new Date()));
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("上个") && s.contains("交易日")) {
			result.setStartTime(TRADE_DAY_PREVIOUS);
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("上一个") && s.contains("交易日")) {
			result.setStartTime(TRADE_DAY_PREVIOUS);
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("上1个") && s.contains("交易日")) {
			result.setStartTime(TRADE_DAY_PREVIOUS);
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下个") && s.contains("交易日")) {
			result.setStartTime(TRADE_DAY_NEXT);
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("下一个") && s.contains("交易日")) {
			result.setStartTime(TRADE_DAY_NEXT);
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("下1个") && s.contains("交易日")) {
			result.setStartTime(TRADE_DAY_NEXT);
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("交易日")) {
			result.setStartTime(TRADE_DAY_NEXT);
			result.setIsSearched(true);
			return result;
		}
		
		
		if(s.equals("近期") || s.contains("近期")) {
			result.setStartTime("20181027-000000");
			result.setEndTime("20181029-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.equals("盘前") || s.contains("盘前")) {
			result.setStartTime("20181029-000000");
			result.setEndTime("20181029-090000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.equals("盘后") || s.contains("盘后")) {
			result.setStartTime("20181029-150000");
			result.setEndTime("20181029-235959");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("晚上10点") || s.contains("晚上十点")) {
			result.setStartTime("20181028-220000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("凌晨") && s.contains("昨天")) {
			result.setStartTime("20181027-000000");
			result.setEndTime("20181027-060000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("上午") && s.contains("昨天")) {
			result.setStartTime("20181027-060000");
			result.setEndTime("20181027-080000");
			result.setIsSearched(true);
			return result;
		}
		
		
		if(s.contains("中午") && s.contains("昨天")) {
			result.setStartTime("20181027-113000");
			result.setEndTime("20181027-130000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下午") && s.contains("昨天")) {
			result.setStartTime("20181027-130000");
			result.setEndTime("20181027-160000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("晚上") && s.contains("昨天")) {
			result.setStartTime("20181027-160000");
			result.setEndTime("20181027-235959");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("凌晨") && s.contains("今天")) {
			result.setStartTime("20181028-000000");
			result.setEndTime("20181028-060000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("上午") && s.contains("今天")) {
			result.setStartTime("20181028-060000");
			result.setEndTime("20181028-080000");
			result.setIsSearched(true);
			return result;
		}
		
		
		if(s.contains("中午") && s.contains("今天")) {
			result.setStartTime("20181028-113000");
			result.setEndTime("20181028-130000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下午") && s.contains("今天")) {
			result.setStartTime("20181028-130000");
			result.setEndTime("20181028-160000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("晚上") && s.contains("今天")) {
			result.setStartTime("20181028-130000");
			result.setEndTime("20181028-160000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("凌晨") && s.contains("明天")) {
			result.setStartTime("20181029-000000");
			result.setEndTime("20181029-060000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("上午") && s.contains("明天")) {
			result.setStartTime("20181029-060000");
			result.setEndTime("20181029-080000");
			result.setIsSearched(true);
			return result;
		}
		
		
		if(s.contains("中午") && s.contains("明天")) {
			result.setStartTime("20181029-113000");
			result.setEndTime("20181029-130000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下午") && s.contains("明天")) {
			result.setStartTime("20181029-130000");
			result.setEndTime("20181029-160000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("晚上") && s.contains("明天")) {
			result.setStartTime("20181029-130000");
			result.setEndTime("20181029-160000");
			result.setIsSearched(true);
			return result;
		}
		
		
		
		//asdf 
		
		
		
		if(s.contains("x") && s.contains("计划")) {
			result.setStartTime("20181030-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("当月")) {
			result.setStartTime("20181101-000000");
			result.setIsSearched(true);
			return result;
		}
		
		
		if(s.contains("X") && s.contains("计划")) {
			result.setStartTime("20181030-000000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("凌晨0点") || s.contains("凌晨零点")) {
			result.setStartTime("20181029-000000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("凌晨1点") || s.contains("凌晨一点")) {
			result.setStartTime("20181029-010000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("凌晨2点") || s.contains("凌晨二点")) {
			result.setStartTime("20181029-020000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("凌晨3点") || s.contains("凌晨三点")) {
			result.setStartTime("20181028-030000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("凌晨4点") || s.contains("凌晨四点")) {
			result.setStartTime("20181028-040000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("凌晨5点") || s.contains("凌晨五点")) {
			result.setStartTime("20181028-050000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("凌晨6点") || s.contains("凌晨六点")) {
			result.setStartTime("20181028-060000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("早晨6点") || s.contains("早晨六点")) {
			result.setStartTime("20181028-060000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("早晨7点") || s.contains("早晨七点")) {
			result.setStartTime("20181028-070000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("早晨8点") || s.contains("早晨八点")) {
			result.setStartTime("20181028-080000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("上午8点") || s.contains("上午八点")) {
			result.setStartTime("20181028-080000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("上午9点") || s.contains("上午九点")) {
			result.setStartTime("20181028-090000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("上午10点") || s.contains("上午十点")) {
			result.setStartTime("20181028-100000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("上午11点") || s.contains("上午十一点")) {
			result.setStartTime("20181028-110000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("上午11点30") || s.contains("上午十一点三十")) {
			result.setStartTime("20181028-113000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("上午11点30分") || s.contains("上午十一点三十分")) {
			result.setStartTime("20181028-113000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("中午11点30") || s.contains("中午十一点三十")) {
			result.setStartTime("20181028-113000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("中午11点30分") || s.contains("中午十一点三十分")) {
			result.setStartTime("20181028-113000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("中午12点") || s.contains("中午十二点")) {
			result.setStartTime("20181028-120000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("中午1点") || s.contains("中午一点")) {
			result.setStartTime("20181028-130000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("下午1点") || s.contains("下午一点")) {
			result.setStartTime("20181028-130000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("下午2点") || s.contains("下午二点")) {
			result.setStartTime("20181028-140000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("下午3点") || s.contains("下午三点")) {
			result.setStartTime("20181028-150000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("下午4点") || s.contains("下午四点")) {
			result.setStartTime("20181028-160000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("晚上4点") || s.contains("晚上四点")) {
			result.setStartTime("20181028-160000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("晚上5点") || s.contains("晚上五点")) {
			result.setStartTime("20181028-170000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("晚上6点") || s.contains("晚上六点")) {
			result.setStartTime("20181028-180000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("晚上7点") || s.contains("晚上七点")) {
			result.setStartTime("20181028-190000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("晚上8点") || s.contains("晚上八点")) {
			result.setStartTime("20181028-200000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("晚上9点") || s.contains("晚上九点")) {
			result.setStartTime("20181028-210000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("晚上10点") || s.contains("晚上十点")) {
			result.setStartTime("20181028-220000");
			result.setIsSearched(true);
			return result;
		}
		if(s.contains("晚上11点") || s.contains("晚上十一点")) {
			result.setStartTime("20181028-230000");
			result.setIsSearched(true);
			return result;
		}
		
		
		if(s.contains("离11月") || s.contains("离十一月") || s.contains("离十一月")) {
			result.setStartTime("20181101-000000");
			result.setIsSearched(true);
			return result;
		}
		

		if(s.contains("凌晨") ) {
			result.setStartTime("20181028-000000");
			result.setEndTime("20181028-060000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("上午")) {
			result.setStartTime("20181028-060000");
			result.setEndTime("20181028-080000");
			result.setIsSearched(true);
			return result;
		}
		
		
		if(s.contains("中午")) {
			result.setStartTime("20181028-113000");
			result.setEndTime("20181028-130000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("下午") ) {
			result.setStartTime("20181028-130000");
			result.setEndTime("20181028-160000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("晚上") ) {
			result.setStartTime("20181028-160000");
			result.setEndTime("20181028-235959");
			result.setIsSearched(true);
			return result;
		}
		
		//
		if(s.contains("恒生") && s.contains("成立")) {
			result.setStartTime("19950200-000000");
			result.setIsSearched(true);
			return result;
		}
		
		if(s.contains("恒生") && s.contains("上市")) {
			result.setStartTime("20031216-100000");
			result.setIsSearched(true);
			return result;
		}
		
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		String format = new SimpleDateFormat(YYYYMMDD_HHmmss).format(new Date());
		System.out.println(format);
	}



}
