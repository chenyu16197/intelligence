package com.baobaotao.beta;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseThrottleNext {
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
	
	
		private static void init() {
			map.put("立春", "20190204-000000");
			map.put("雨水", "20190219-000000");
			map.put("惊蛰", "20190306-000000");
			map.put("春分", "20190321-000000");
			
			map.put("清明", "20190405-000000");
			map.put("谷雨","20190420-000000");
			map.put("立夏","20190506-000000");
			map.put("小满", "20190521-000000");
			
			map.put("芒种", "20190606-000000");
			map.put("夏至", "20190621-000000");
			map.put("小暑", "20190707-000000");
			map.put("大暑", "20190723-000000");
			
			map.put("立秋", "20190808-000000");
			map.put("处暑", "20190823-000000");
			map.put("白露", "20190908-000000");
			map.put("秋分", "20190923-000000");
			
			map.put("寒露", "20191008-000000");
			map.put("霜降","20191024-000000");
			map.put("立冬","20181107-000000");
			map.put("小雪", "20181122-000000");
			
			map.put("大雪", "20181207-000000");
			map.put("冬至", "20181222-000000");
			map.put("小寒", "20190105-000000");
			map.put("大寒", "20190120-000000");
			
		}
}
