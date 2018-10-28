package com.baobaotao.beta;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseWeekNext {
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
			map.put("周一", "20181029-000000");
			map.put("周二", "20181030-000000");
			map.put("周三", "20181031-000000");
			map.put("周四", "20181101-000000");
			map.put("周五", "20181102-000000");
			map.put("周六", "20181103-000000");
			map.put("周日", "20181104-000000");
			map.put("周天", "20181105-000000");
			
			map.put("星期一", "20181029-000000");
			map.put("星期二", "20181030-000000");
			map.put("星期三", "20181031-000000");
			map.put("星期四", "20181101-000000");
			map.put("星期五", "20181102-000000");
			map.put("星期六", "20181103-000000");
			map.put("星期日", "20181104-000000");
			map.put("星期天", "20181105-000000");
			
			map.put("礼拜一", "20181029-000000");
			map.put("礼拜二", "20181030-000000");
			map.put("礼拜三", "20181031-000000");
			map.put("礼拜四", "20181101-000000");
			map.put("礼拜五", "20181102-000000");
			map.put("礼拜六", "20181103-000000");
			map.put("礼拜日", "20181104-000000");
			map.put("礼拜天", "20181105-000000");
			
		}
}
