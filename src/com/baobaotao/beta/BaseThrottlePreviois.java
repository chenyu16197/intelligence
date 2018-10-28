package com.baobaotao.beta;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseThrottlePreviois {
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
			map.put("立春", "20180204-000000");
			map.put("雨水", "20180219-000000");
			map.put("惊蛰", "20180305-000000");
			map.put("春分", "20180321-000000");
			
			map.put("清明", "20180405-000000");
			map.put("谷雨","20180420-000000");
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
			map.put("立冬","20171107-000000");
			map.put("小雪", "20171122-000000");
			
			map.put("大雪", "20171207-000000");
			map.put("冬至", "20171222-000000");
			map.put("小寒", "20180105-000000");
			map.put("大寒", "20170120-000000");
			
		}
}
