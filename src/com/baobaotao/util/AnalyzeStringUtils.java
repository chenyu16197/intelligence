package com.baobaotao.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AnalyzeStringUtils {
	
	
	public static String analyzeString(String str){
		StrFiler(str);
		//正常时间   1988-09
		String dateReg = "^(?:(?!0000)[0-9]{4}[-|年|//]"
				+ "(?:(?:0?[1-9]|1[0-2])[-|月|//]"
				+ "(?:0?[1-9]|1[0-9]|2[0-8])"
				+ "|(?:0[13-9]|1[0-2])-(?:29|30)"
				+ "|(?:0[13578]|1[02])-31)"
				+ "|(?:[0-9]{2}(?:0[48]"
				+ "|[2468][048]"
				+ "|[13579][26])"
				+ "|(?:0[48]|[2468][048]|[13579][26])00)-02-29)[日|号]?$";
		//非正常时间（假日，昨天。。）
		String regEx = "([上|本|下]*周[1-7|日|天]?|[上|下]*个?星期[1-7|日|天]?|[今|前|去|明|后]?年?元旦[节]?|[今|前|去|明|后]?年?春节|[今|前|去|明|后]?年?清明[节]?|[今|前|去|明|后]?年?劳动[节]?|[今|前|去|明|后]?年?端午[节]?|[今|前|去|明|后]?年?中秋[节]?|[今|前|去|明|后]?年?鬼节|[今|前|去|明|后]?年?国庆[节]?|[今|前|去|明|后]?年?光棍节|[今|前|去|明|后]?年?双十一|[今|前|去|明|后]?年?七夕|[今|前|去|明|后]?年?情人节|[今|前|去|明|后]?年?三八妇女节|[今|前|去|明|后]?年?妇女节|[今|前|去|明|后]?年?建军节|[今|前|去|明|后]?年?建党节|[今|前|去|明|后]?年?过年|[今|前|去|明|后]天?[上|下]午|[今|前|去|明|后]天?晚上|[今|前|去|明|后]天[早|凌][上|晨]|[今|前|去|明|后]年?(0?[1-9]|1[0-2])月([0-3]?[1-9])[日|号]?|大*[前|后]天|[上|下]个交易日|[上|下]个工作日|[上|下]个节假日|[今|前|去|明|后]天?盘[前|后]|上午|下午|晚上|[早|凌][晨|上]|盘[前|后])";
		
		//时分秒
		String timeReg = "((((0?[0-9])|([1][0-9])|([2][0-4]))[:|时]([0-5]?[0-9])((\\s)|([:|分]?([0-5]?[0-9]))秒?)))?$";
		Pattern pattern = Pattern.compile(dateReg);
		Matcher matcher = pattern.matcher(str);
		String dateStr  = "";
		String timeStr = "";
		while(matcher.find()){
			dateStr = matcher.group();
		}
		if(dateStr == null || "".equals(dateStr.trim())){
			pattern = Pattern.compile(regEx);
			while(matcher.find()){
				dateStr = matcher.group();
			}
		}
		if(dateStr == null || "".equals(dateStr.trim())){
			pattern = Pattern.compile(timeReg);
			while(matcher.find()){
				timeStr = matcher.group();
			}
		}
		return dateStr+"mm_$$_ii"+timeStr; 
	}
	
	
	public static void StrFiler(String str){
		if(str != null && !"".equals(str.trim())){
			str = str.replaceAll("一十二", "12").
			replaceAll("十二", "12").
			replaceAll("壹拾贰", "12").
			replaceAll("拾贰", "12").
			replaceAll("拾贰", "12").
			replaceAll("一十一", "11").
			replaceAll("十一", "11").
			replaceAll("壹拾壹", "11").
			replaceAll("拾壹", "11").
			replaceAll("十", "10").
			replaceAll("壹拾", "10").
			replaceAll("九", "9").
			replaceAll("玖", "9").
			replaceAll("八", "8").
			replaceAll("捌", "8").
			replaceAll("七", "7").
			replaceAll("柒", "7").
			replaceAll("六", "6").
			replaceAll("陆", "6").
			replaceAll("五", "5").
			replaceAll("伍", "5").
			replaceAll("四", "4").
			replaceAll("捌", "4").
			replaceAll("三", "3").
			replaceAll("叁", "3").
			replaceAll("二", "2").
			replaceAll("贰", "2").
			replaceAll("一", "1").
			replaceAll("壹", "1").
			replaceAll("零", "0").
			replaceAll("Ｏ", "0").
			replaceAll("ｏ", "0");
			System.out.println("----------------->"+str);
		}
	}
	
	public static void main(String[] args) {
		
		String x = analyzeString("今年十一月31号13点41分21秒");
		System.out.print(x);
	}
}
