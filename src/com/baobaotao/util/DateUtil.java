package com.baobaotao.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

/**
 * 日期操作工具类
 *
 * @author make
 *
 */
public class DateUtil {

	public static final String TIME_PATTERN_SS = "yyyy-MM-dd HH:mm:ss";
	// 日期格式 时分秒
	public static final String TIME_HHMMSS = "HHmmss";
	// 日期格式时分秒毫秒，注意毫秒的时候多了一位需要特殊处理
	public static final String TIME_HHMMSSSS = "HHmmssSS";
	// 日期格式时分秒毫秒，注意毫秒的时候多了一位需要特殊处理
    public static final String TIME_HHMMSSSSS = "HHmmssSSS";

	public static float countDays(Date begin, Date end) {
		if (begin == null || end == null)
			return -9999;
		long times = end.getTime() - begin.getTime();
		float days = ((float) times / 60 / 60 / 1000 / 24);
		return days;
	}

	public static Calendar getCurrentDay() {
		Calendar cal = Calendar.getInstance();
		return cal;
	}

	/**
	 * 获取时间格式
	 *
	 * @param aDate
	 * @param dateformat
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateFormat(Date aDate, String dateformat) {
		if (isEmpty(dateformat)) {
			dateformat = TIME_PATTERN_SS;
		}

		return getDateTime(dateformat, aDate);
	}

	public static boolean isEmpty(String str) {
		return ((str == null) || (str.length() == 0));
	}

	/**
	 * 日期格式化yyyy-MM-dd HH:mm:ss
	 *
	 * @param date
	 * @return
	 */
	public static Date getFormatDate(String date) {
		try {
			return new SimpleDateFormat(TIME_PATTERN_SS).parse(date);
		} catch (Exception e) {
		}
		return getCurrentDate();
	}

	public static String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static String convertDateToString(String pattern, Date aDate) {
		return getDateTime(pattern, aDate);
	}

	public static String convertDateToString(Date aDate) {
		return getDateTime(getDatePattern(), aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 *
	 * @param strDate
	 *            the date to convert (in format yyyy-MM-dd)
	 * @return a date object
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Date convertStringToDate(String strDate)
			throws ParseException {
		Date aDate = null;

		try {
			aDate = convertStringToDate(getDatePattern(), strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return aDate;
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 *
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df;
		Date date;
		df = new SimpleDateFormat(aMask);

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	public static String getDatePattern() {
		return "yyyy-MM-dd";
	}

	/**
	 * This method returns the current date in the format: yyyy-MM-dd
	 *
	 * @return the current date
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	/**
	 * 当前日期,不带时间（yyyy-MM-dd）
	 *
	 * @return
	 */
	public static Date getCurrentDate() {
		Date today = new Date();
		try {
			today = getToday().getTime();
		} catch (ParseException e) {
		}
		return today;
	}

	/**
	 * 获取当前日期,日期格式为yyyyMMdd
	 *
	 * @return yyyyMMdd
	 */
	public static String getCurrentDateByFormat() {
		return convertDateToString("yyyyMMdd", getCurrentDate());
	}

	/**
	 * 获取当前时间,时间格式为HHmmss
	 *
	 * @return HHmmss
	 */
	public static String getCurrentTime() {
		return convertDateToString(TIME_HHMMSS, new Date());
	}

	/**
	 * 获取当前时间,时间格式为HHmmssSS
	 *
	 * @return HHmmssSS
	 */
	public static String getCurrentTimeByMillisecond() {
		return convertDateToString(TIME_HHMMSSSS, getCurrentDate());
	}

	/**
	 * 格式化为HHmmssSSS
	 * @param date
	 * @return
	 */
	public static String getFormatTime(Date date){
	    return convertDateToString(TIME_HHMMSSSSS, date);
	}

	/**
	 * 日期格式化
	 *
	 * @param date
	 * @return yyyyMMdd
	 */
	public static String formatDate(Date date) {
		return convertDateToString("yyyyMMdd", date);
	}

	/**
	 * 时间格式化
	 *
	 * @param date
	 * @return HHmmss
	 */
	public static String formatTime(Date date) {
		return convertDateToString(TIME_HHMMSS, date);
	}

	/**
	 * 取得从startDate开始的前(正)/后(负)day天
	 *
	 * @param startDate
	 * @param day
	 * @return
	 */
	public static Date getRelativeDate(Date startDate, int day) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(startDate);
			calendar.add(Calendar.DAY_OF_MONTH, day);
			return calendar.getTime();
		} catch (Exception e) {
			return startDate;
		}
	}

	public static Date getNextYear() {
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.YEAR, 1);
		return cal.getTime();
	}

	/**
	 * 取得昨天的日期
	 *
	 * @return
	 * @create 2016年4月20日 上午10:28:07 make
	 * @history
	 */
	public static String yesterdayStr() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		DateFormat dfday = new SimpleDateFormat("yyyy-MM-dd");
		String time = dfday.format(cal.getTime());
		return time;
	}

	/**
	 * 取得每个月的第一天
	 *
	 * @param dayValue
	 * @return
	 * @create 2016年4月20日 上午10:29:52 make
	 * @history
	 */

	/**
	 * @author dingjl19188
	 * @created_time 2016年8月13日上午10:42:24
	 * @intro 报表——商品成交汇总。对原有报表错误：String index out of range: -1 进行修正
	 * @param dayValue
	 * @return
	 */
	public static String monthStartDayStr(String dayValue) {
		if (dayValue == null) {
			throw new NullPointerException("param dayValue is null");
		}
		if (dayValue.contains("-")) {
			return dayValue.substring(0, dayValue.lastIndexOf("-")) + "-01";
		}
		return dayValue.substring(0, dayValue.lastIndexOf("-")) + "-01";
	}

	public static String dataFormat(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	public static void main(String[] args) throws ParseException {
		String year = getCurrentYear();
		String str = dataFormat(new Date());
		System.out.println(str);

		System.out.println(currentDayStr());
		System.out.println(yesterdayStr());

		System.out.println(getFormatTime(new Date()));

		System.out.println(dateFormat("20161017"));
		System.out.println(getCurrentDate().getTime());
	}

	/**
	 * 日期格式化</br>
	 * 输入格式：yyyyMMdd</br>
	 * 输出格式：yyyy-MM-dd</br>
	 * 如果格式化失败,则返回StringUtils.EMPTY
	 * @param date yyyyMMdd
	 * @return yyyy-MM-dd
	 */
	public static String dateFormat(String date){
		if (StringUtils.isEmpty(date)) {
			return StringUtils.EMPTY;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date target = sdf.parse(date);
			if(null == target)
				return StringUtils.EMPTY;
			return format.format(target);
		} catch (ParseException e) {
		}
		return StringUtils.EMPTY;
	}

	/**
	 * 日期格式化
	 *
	 * @param date
	 *            yyyyMMdd
	 * @return yyyy-MM-dd
	 */
	public static String dateFormat(Integer date) {
		if (null == date)
			return StringUtils.EMPTY;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		DateFormat dfday = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = dateFormat.parse(date.toString());
			return dfday.format(d);
		} catch (ParseException e) {
		}
		return StringUtils.EMPTY;
	}

	/**
	 * 时间格式化
	 *
	 * @param time
	 *            HHmmss
	 * @return HH:mm:ss
	 */
	public static String timeFormat(Integer time) {
		if (null == time)
			return StringUtils.EMPTY;
		DateFormat timeFormat = new SimpleDateFormat("HHmmss");
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		try {
			Date t = timeFormat.parse(time.toString());
			return format.format(t);
		} catch (ParseException e) {
		}
		return StringUtils.EMPTY;
	}
	/**
	 * 时间格式化
	 *
	 * @param time
	 *            HHmmss
	 * @return HH:mm:ss
	 */
	public static String timeFormat(String time) {
		if (null == time)
			return StringUtils.EMPTY;
		DateFormat timeFormat = new SimpleDateFormat("HHmmss");
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		try {
			Date t = timeFormat.parse(time.toString());
			return format.format(t);
		} catch (ParseException e) {
		}
		return StringUtils.EMPTY;
	}
	/**
	 * 字符串日期格式化</br> 格式化失败后返回Null
	 *
	 * @param date
	 *            yyyyMMdd
	 * @return
	 */
	public static Date formatDate(String date) {
		if (StringUtils.isBlank(date))
			return null;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 取得当天的日期
	 *
	 * @return yyyy-MM-dd
	 */
	public static String currentDayStr() {
		DateFormat dfday = new SimpleDateFormat("yyyy-MM-dd");
		String time = dfday.format(new Date());
		return time;
	}

	/**
	 * 获取当前小时
	 * @return
	 */
	public static Integer getHours(){
	    return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}

	/**
     * 获取当前分钟
     * @return
     */
	public static Integer getMinutes(){
	    return Calendar.getInstance().get(Calendar.MINUTE);
	}

	/**
     * 将数据库中的日期格式（yyyyMMdd）转换成显示日期（yyyy-MM-dd）
     * @return
     */
	public static String formatDateString(String date){
		if(StringUtils.isBlank(date)){
			return StringUtils.EMPTY;
		}
		if(date.contains("-")){
			return date;
		}
		StringBuilder sb = new StringBuilder(date);
		sb.insert(4, "-");
		sb.insert(7, "-");
		return sb.toString();
	}

	/**
     * 报表——预销情况查询 设置T+N规则
     * @return
     */

	public static String setTn(int tn){
		return "T+"+tn;
	}
	
	public static String getCurrentYear(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
}

}
