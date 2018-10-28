package com.baobaotao.beta;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class BaseWeek {
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
			map.put("周一", "20181029-000000");
			map.put("周二", "20181030-000000");
			map.put("周三", "20181031-000000");
			map.put("周四", "20181025-000000");
			map.put("周五", "20181026-000000");
			map.put("周六", "20181027-000000");
			map.put("周日", "20181028-000000");
			map.put("周天", "20181028-000000");
			
			map.put("星期一", "20181029-000000");
			map.put("星期二", "20181030-000000");
			map.put("星期三", "20181031-000000");
			map.put("星期四", "20181025-000000");
			map.put("星期五", "20181026-000000");
			map.put("星期六", "20181027-000000");
			map.put("星期日", "20181028-000000");
			map.put("星期天", "20181028-000000");
			
			map.put("礼拜一", "20181029-000000");
			map.put("礼拜二", "20181030-000000");
			map.put("礼拜三", "20181031-000000");
			map.put("礼拜四", "20181025-000000");
			map.put("礼拜五", "20181026-000000");
			map.put("礼拜六", "20181027-000000");
			map.put("礼拜日", "20181028-000000");
			map.put("礼拜天", "20181028-000000");
			
		}
}
