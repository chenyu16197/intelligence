package com.baobaotao.beta;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class BaseDay {
	private static Map<String, String> map = new ConcurrentHashMap<String, String>(200);
		
		
		static {
			try {
				init();
			} catch (Exception e) {
				
			}
		}
		
		
		public static Map<String, String> getInstance() {
			
			return map;
		}
		/**
		 * 输入【你好是元旦吗】---> 找到元旦的
		 * @param data
		 * @return
		 */
		public static Entry getEntry(String data) {
			
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			
			while(iterator.hasNext()) {
				Entry<String, String> entry = iterator.next();
				
				String key = entry.getKey();
				
				if(data.contains(key)) {
					return entry;
				}
			}
			return null;
			
		}
	
		private static void init() {
			map.put("大前天", "20181025-000000");
			map.put("前天", "20181026-000000");
			
			map.put("昨天的昨天", "20181026-000000");
			map.put("昨天", "20181027-000000");
			
			map.put("昨日的昨日", "20181026-000000");
			map.put("昨日", "20181027-000000");
			
			
			map.put("今天", "20181028-000000");
			map.put("明天", "20181029-000000");
			
			map.put("明天的明天", "20181030-000000");
			
			map.put("今日", "20181028-000000");
			map.put("明日", "20181029-000000");
			
			map.put("明日的明日", "20181030-000000");
			
			map.put("后天", "20181030-000000");
			map.put("大后天", "20181031-000000");
			
		}
}
