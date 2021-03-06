package com.baobaotao.beta;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class BaseTradeDay {
	
	
	private static Map<String, String> map = new ConcurrentHashMap<String, String>();
	
	
	static {
		init();
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
	
	//外部参数传过来，不存在--判断是不是周末,   是周末就不是交易日
	
	//外部参数传过来，存在-- 1交易日，0，不是交易日


	private static void init() {

		map.put("20080101","0");
		map.put("20080206","0");
		map.put("20080207","0");
		map.put("20080208","0");
		map.put("20080209","0");
		map.put("20080210","0");
		map.put("20080211","0");
		map.put("20080212","0");
		map.put("20080202","1");
		map.put("20080203","1");
		map.put("20080404","0");
		map.put("20080405","0");
		map.put("20080406","0");
		map.put("20080501","0");
		map.put("20080502","0");
		map.put("20080503","0");
		map.put("20080504","1");
		map.put("20080607","0");
		map.put("20080608","0");
		map.put("20080609","0");
		map.put("20080913","0");
		map.put("20080914","0");
		map.put("20080915","0");
		map.put("20080929","0");
		map.put("20080930","0");
		map.put("20081001","0");
		map.put("20081002","0");
		map.put("20081003","0");
		map.put("20081004","0");
		map.put("20081005","0");
		map.put("20090101","0");
		map.put("20090102","0");
		map.put("20090103","0");
		map.put("20090104","1");
		map.put("20090125","0");
		map.put("20090126","0");
		map.put("20090127","0");
		map.put("20090128","0");
		map.put("20090129","0");
		map.put("20090130","0");
		map.put("20090131","0");
		map.put("20090124","1");
		map.put("20090201","1");
		map.put("20090404","0");
		map.put("20090405","0");
		map.put("20090406","0");
		map.put("20090501","0");
		map.put("20090502","0");
		map.put("20090503","0");
		map.put("20090528","0");
		map.put("20090529","0");
		map.put("20090530","0");
		map.put("20090531","1");
		map.put("20091001","0");
		map.put("20091002","0");
		map.put("20091003","0");
		map.put("20091004","0");
		map.put("20091005","0");
		map.put("20091006","0");
		map.put("20091007","0");
		map.put("20091008","0");
		map.put("20090927","1");
		map.put("20091010","1");
		map.put("20100101","0");
		map.put("20100102","0");
		map.put("20100103","0");
		map.put("20100213","0");
		map.put("20100214","0");
		map.put("20100215","0");
		map.put("20100216","0");
		map.put("20100217","0");
		map.put("20100218","0");
		map.put("20100219","0");
		map.put("20100220","1");
		map.put("20100221","1");
		map.put("20100403","0");
		map.put("20100404","0");
		map.put("20100405","0");
		map.put("20100501","0");
		map.put("20100502","0");
		map.put("20100503","0");
		map.put("20100614","0");
		map.put("20100615","0");
		map.put("20100616","0");
		map.put("20100612","1");
		map.put("20100613","1");
		map.put("20100922","0");
		map.put("20100923","0");
		map.put("20100924","0");
		map.put("20100919","1");
		map.put("20100925","1");
		map.put("20101001","0");
		map.put("20101002","0");
		map.put("20101003","0");
		map.put("20101004","0");
		map.put("20101005","0");
		map.put("20101006","0");
		map.put("20101007","0");
		map.put("20100926","1");
		map.put("20101009","1");
		map.put("20110101","0");
		map.put("20110102","0");
		map.put("20110103","0");
		map.put("20110130","1");
		map.put("20110202","0");
		map.put("20110203","0");
		map.put("20110204","0");
		map.put("20110205","0");
		map.put("20110206","0");
		map.put("20110207","0");
		map.put("20110208","0");
		map.put("20110212","1");
		map.put("20110402","1");
		map.put("20110403","0");
		map.put("20110404","0");
		map.put("20110405","0");
		map.put("20110430","0");
		map.put("20110501","0");
		map.put("20110502","0");
		map.put("20110604","0");
		map.put("20110605","0");
		map.put("20110606","0");
		map.put("20110910","0");
		map.put("20110911","0");
		map.put("20110912","0");
		map.put("20111001","0");
		map.put("20111002","0");
		map.put("20111003","0");
		map.put("20111004","0");
		map.put("20111005","0");
		map.put("20111006","0");
		map.put("20111007","0");
		map.put("20111008","1");
		map.put("20111009","1");
		map.put("20111231","1");
		map.put("20120101","0");
		map.put("20120102","0");
		map.put("20120103","0");
		map.put("20120121","1");
		map.put("20120122","0");
		map.put("20120123","0");
		map.put("20120124","0");
		map.put("20120125","0");
		map.put("20120126","0");
		map.put("20120127","0");
		map.put("20120128","0");
		map.put("20120129","1");
		map.put("20120331","1");
		map.put("20120401","1");
		map.put("20120402","0");
		map.put("20120403","0");
		map.put("20120404","0");
		map.put("20120428","1");
		map.put("20120429","0");
		map.put("20120430","0");
		map.put("20120501","0");
		map.put("20120502","1");
		map.put("20120622","0");
		map.put("20120623","0");
		map.put("20120624","0");
		map.put("20120929","1");
		map.put("20120930","0");
		map.put("20121001","0");
		map.put("20121002","0");
		map.put("20121003","0");
		map.put("20121004","0");
		map.put("20121005","0");
		map.put("20121006","0");
		map.put("20121007","0");
		map.put("20121008","1");
		map.put("20130101","0");
		map.put("20130102","0");
		map.put("20130103","0");
		map.put("20130105","1");
		map.put("20130106","1");
		map.put("20130209","0");
		map.put("20130210","0");
		map.put("20130211","0");
		map.put("20130212","0");
		map.put("20130213","0");
		map.put("20130214","0");
		map.put("20130215","0");
		map.put("20130216","1");
		map.put("20130217","1");
		map.put("20130404","0");
		map.put("20130405","0");
		map.put("20130406","0");
		map.put("20130407","1");
		map.put("20130427","1");
		map.put("20130428","1");
		map.put("20130429","0");
		map.put("20130430","0");
		map.put("20130501","0");
		map.put("20130608","1");
		map.put("20130609","1");
		map.put("20130610","0");
		map.put("20130611","0");
		map.put("20130612","0");
		map.put("20130919","0");
		map.put("20130920","0");
		map.put("20130921","0");
		map.put("20130922","1");
		map.put("20130929","1");
		map.put("20131001","0");
		map.put("20131002","0");
		map.put("20131003","0");
		map.put("20131004","0");
		map.put("20131005","0");
		map.put("20131006","0");
		map.put("20131007","0");
		map.put("20131012","1");
		map.put("20140101","0");
		map.put("20140126","1");
		map.put("20140131","0");
		map.put("20140201","0");
		map.put("20140202","0");
		map.put("20140203","0");
		map.put("20140204","0");
		map.put("20140205","0");
		map.put("20140206","0");
		map.put("20140208","1");
		map.put("20140405","0");
		map.put("20140406","0");
		map.put("20140407","0");
		map.put("20140501","0");
		map.put("20140502","0");
		map.put("20140503","0");
		map.put("20140504","1");
		map.put("20140531","0");
		map.put("20140601","0");
		map.put("20140602","0");
		map.put("20140906","0");
		map.put("20140907","0");
		map.put("20140908","0");
		map.put("20140928","1");
		map.put("20141001","0");
		map.put("20141002","0");
		map.put("20141003","0");
		map.put("20141004","0");
		map.put("20141005","0");
		map.put("20141006","0");
		map.put("20141007","0");
		map.put("20141011","1");
		map.put("20150101","0");
		map.put("20150102","0");
		map.put("20150103","0");
		map.put("20150104","1");
		map.put("20150218","0");
		map.put("20150219","0");
		map.put("20150220","0");
		map.put("20150221","0");
		map.put("20150222","0");
		map.put("20150223","0");
		map.put("20150224","0");
		map.put("20150215","1");
		map.put("20150228","1");
		map.put("20150405","0");
		map.put("20150406","0");
		map.put("20150501","0");
		map.put("20150620","0");
		map.put("20150622","0");
		map.put("20150927","0");
		map.put("20151001","0");
		map.put("20151002","0");
		map.put("20151003","0");
		map.put("20151004","0");
		map.put("20151005","0");
		map.put("20151006","0");
		map.put("20151007","0");
		map.put("20151010","1");
		map.put("20160101","0");
		map.put("20160102","0");
		map.put("20160103","0");
		map.put("20160206","1");
		map.put("20160207","0");
		map.put("20160208","0");
		map.put("20160209","0");
		map.put("20160210","0");
		map.put("20160211","0");
		map.put("20160212","0");
		map.put("20160213","0");
		map.put("20160214","1");
		map.put("20160402","0");
		map.put("20160403","0");
		map.put("20160404","0");
		map.put("20160430","0");
		map.put("20160501","0");
		map.put("20160502","0");
		map.put("20160609","0");
		map.put("20160610","0");
		map.put("20160611","0");
		map.put("20160612","1");
		map.put("20160915","0");
		map.put("20160916","0");
		map.put("20160917","0");
		map.put("20160918","1");
		map.put("20161001","0");
		map.put("20161002","0");
		map.put("20161003","0");
		map.put("20161004","0");
		map.put("20161005","0");
		map.put("20161006","0");
		map.put("20161007","0");
		map.put("20161008","1");
		map.put("20161009","1");
		map.put("20161231","0");
		map.put("20170101","0");
		map.put("20170102","0");
		map.put("20170127","0");
		map.put("20170128","0");
		map.put("20170129","0");
		map.put("20170130","0");
		map.put("20170131","0");
		map.put("20170201","0");
		map.put("20170202","0");
		map.put("20170204","1");
		map.put("20170401","1");
		map.put("20170402","0");
		map.put("20170403","0");
		map.put("20170404","0");
		map.put("20170429","0");
		map.put("20170430","0");
		map.put("20170501","0");
		map.put("20170527","1");
		map.put("20170528","0");
		map.put("20170529","0");
		map.put("20170530","0");
		map.put("20170930","1");
		map.put("20171001","0");
		map.put("20171002","0");
		map.put("20171003","0");
		map.put("20171004","0");
		map.put("20171005","0");
		map.put("20171006","0");
		map.put("20171007","0");
		map.put("20171008","0");
		map.put("20171230","0");
		map.put("20171231","0");
		map.put("20180101","0");
		map.put("20180211","1");
		map.put("20180215","0");
		map.put("20180216","0");
		map.put("20180217","0");
		map.put("20180218","0");
		map.put("20180219","0");
		map.put("20180220","0");
		map.put("20180221","0");
		map.put("20180224","1");
		map.put("20180405","0");
		map.put("20180406","0");
		map.put("20180407","0");
		map.put("20180408","1");
		map.put("20180428","1");
		map.put("20180429","0");
		map.put("20180430","0");
		map.put("20180501","0");
		map.put("20180616","0");
		map.put("20180617","0");
		map.put("20180618","0");
		map.put("20180922","0");
		map.put("20180923","0");
		map.put("20180924","0");
		map.put("20180929","1");
		map.put("20180930","1");
		map.put("20181001","0");
		map.put("20181002","0");
		map.put("20181003","0");
		map.put("20181004","0");
		map.put("20181005","0");
		map.put("20181006","0");
		map.put("20181007","0");
	
	}
	
	
	

}
