package com.baobaotao.util;
 
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/**
 * 正则表达式匹配两个字符串之间的内容
 * @author Administrator
 *
 */
public class RegexUtil {
	
	public static void main(String[] args) {
		
	    //System.out.println(new RegexUtil().getSubUtil("2018年11月22号13点23分"));
		System.out.println(new RegexUtil().getSubUtil("元旦节今年"));
	}
	
	/** 
     * 正则表达式匹配两个指定字符串中间的内容 ，给外部调用
     * @param soap 
     * @return 
     */  
    public static String getSubUtil(String soap){  
    	StrFiler(soap);
        String dateStr = "";
        String timeStr = "";
        String dateReg = "[0-9]{4}[-|年|//][0-9]{1,2}[-|月|//][0-9]{1,2}[日|号]?";
        String rgex = "([上|本|下]*周[1-7|日|天]?|[上|下]*个?星期[1-7|日|天]?|[今|前|去|明|后]?年?元旦[节]?|[今|前|去|明|后]?年?春节|[今|前|去|明|后]?年?清明[节]?|[今|前|去|明|后]?年?劳动[节]?|[今|前|去|明|后]?年?端午[节]?|[今|前|去|明|后]?年?中秋[节]?|[今|前|去|明|后]?年?鬼节|[今|前|去|明|后]?年?国庆[节]?|[今|前|去|明|后]?年?光棍节|[今|前|去|明|后]?年?双十一|[今|前|去|明|后]?年?七夕|[今|前|去|明|后]?年?情人节|[今|前|去|明|后]?年?三八妇女节|[今|前|去|明|后]?年?妇女节|[今|前|去|明|后]?年?建军节|[今|前|去|明|后]?年?建党节|[今|前|去|明|后]?年?过年|[今|前|去|明|后]天?[上|下]午|[今|前|去|明|后]天?晚上|[今|前|去|明|后]天[早|凌][上|晨]|[今|前|去|明|后]年?(0?[1-9]|1[0-2])月([0-3]?[1-9])[日|号]?|大*[前|后]天|[上|下]个交易日|[上|下]个工作日|[上|下]个节假日|[今|前|去|明|后]天?盘[前|后]|上午|下午|晚上|[早|凌][晨|上]|盘[前|后]|[今|明|去]年)";
        String timeReg = "[0-9]{1,2}[:|点|时]?[0-9]{1,2}[:|分]?[0-9]{0,2}";
        Pattern pattern1 = Pattern.compile(dateReg);// 匹配的模式  
        Matcher m1 = pattern1.matcher(soap);
        Pattern pattern2 = Pattern.compile(rgex);// 匹配的模式  
        Matcher m2 = pattern2.matcher(soap);  
        Pattern pattern3 = Pattern.compile(timeReg);// 匹配的模式  
        Matcher m3 = pattern3.matcher(soap);  
        while (m1.find()) {  
        	dateStr = m1.group();
        }
        if(dateStr==null||dateStr==""){
			while(m2.find()){
				dateStr = m2.group();
			}
		}
		while(m3.find()){
			timeStr = m3.group();
		}
        return dateStr+"@@@"+timeStr;  
    }  
      
    public static void StrFiler(String str){
		if(str!=null&&!"".equals(str)){
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
		}
	}
}
