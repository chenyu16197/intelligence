package com.baobaotao.beta;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BaseKeywordPreviousOrNext {
	
	private static Map<String, Integer> map = new ConcurrentHashMap<String, Integer>(200);
	
	
	static {
		try {
			init();
		} catch (Exception e) {
			
		}
	}
	
	public static Integer getEntryOfKeyword(String data) {
		
		 Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		 
		 while(iterator.hasNext()) {
			 Entry<String, Integer> entry = iterator.next();
			 
			 String key = entry.getKey();
			 
			 if(data.indexOf(key) >= 0) {
				 return map.get(key);
			 }
		 }
		
		return null;
	}


	private static void init() {
		map.put("上", -1);
		map.put("上个", -1);
		map.put("上一个", -1);
		map.put("上1个", -1);
		map.put("前个", -1);
		map.put("前一个", -1);
		map.put("前1个", -1);
		
		map.put("下", 1);
		map.put("下个", 1);
		map.put("下一个", 1);
		map.put("下1个", 1);
		map.put("后个", 1);
		map.put("后一个", 1);
		map.put("后1个", 1);
		
	}

}
