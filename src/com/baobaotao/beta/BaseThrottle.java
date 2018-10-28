package com.baobaotao.beta;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class BaseThrottle {
	private static Map<String, String> map = new ConcurrentHashMap<String, String>(200);
		
		
		static {
			try {
				init();
			} catch (Exception e) {
				
			}
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
		public static Map<String, String> getInstance() {
			
			return map;
		}
	
	
		private static void init() {
			map.put("立春", "20190204-000000");
			map.put("雨水", "20190219-000000");
			map.put("惊蛰", "20190306-000000");
			map.put("春分", "20190321-000000");
			
			map.put("清明", "20190405-000000");
			map.put("谷雨","20190420-000000");
			map.put("立夏","20180505-000000");
			map.put("小满", "20180521-000000");
			
			map.put("芒种", "20180606-000000");
			map.put("夏至", "20180621-000000");
			map.put("小暑", "20180707-000000");
			map.put("大暑", "20180723-000000");
			
			map.put("立秋", "20180807-000000");
			map.put("处暑", "20180823-000000");
			map.put("白露", "20180908-000000");
			map.put("秋分", "20180923-000000");
			
			map.put("寒露", "20181008-000000");
			map.put("霜降","20181023-000000");
			map.put("立冬","20181107-000000");
			map.put("小雪", "20181122-000000");
			
			map.put("大雪", "20181207-000000");
			map.put("冬至", "20181222-000000");
			map.put("小寒", "20190105-000000");
			map.put("大寒", "20190120-000000");
			
		}
}
