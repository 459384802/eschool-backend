package com.eschool.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 日期处理
 *
 * @date 2018-11-14 09:11:56
 * @description Auto-generated by Moria-Platform
 */
public class DateUtils {
	
	private static final DateTimeFormatter SIMPLE_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	
	private static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private static Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    public static final String DAY_MAX_TIME = "yyyy-MM-dd 23:59:59";

    public static final String DAY_MIN_TIME = "yyyy-MM-dd 00:00:00";
	
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
    	
    	
    	
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
    
    public static String simpleFormat() {
    	LocalDateTime date = LocalDateTime.now();
    	return SIMPLE_DATE_TIME_FORMATTER.format(date);
    }

    /**
     * 时间戳转换日期格式字符串
     *
     * @param timeStamp
     * @param format
     * @return
     */
    public static String timeStampToString(String timeStamp, String format) {

        if (timeStamp == null || timeStamp == "") {
            return null;
        }

        if (!NUMBER_PATTERN.matcher(timeStamp).matches()) {
            return null;
        }

        String dayMaxTime = null;
        Calendar calendar = Calendar.getInstance(Locale.CHINA);

        try {

            long longTimeStamp = Long.parseLong(timeStamp);
            calendar.setTimeInMillis(longTimeStamp);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            dayMaxTime = sdf.format(calendar.getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dayMaxTime;
    }

    /**
     * 日期格式字符串转换时间戳
     * @param dateString 日期格式字符串
     * @param format 转化格式
     * @param seconds 是否精确到秒
     * @return
     */
    public static Long stringToTimeStamp(String dateString, String format, boolean seconds) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            Long timeStamp = formatter.parse(dateString).getTime();
            return true == seconds ? timeStamp/1000 : timeStamp ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间戳转换:一天中最小时间字符
     *
     * @param timeStamp
     * @return
     */
    public static String toDayMinTime(String timeStamp) {

        return timeStampToString(timeStamp, DAY_MIN_TIME);
    }

    /**
     * 时间戳转换:一天中最大时间
     *
     * @param timeStamp
     * @return
     */
    public static String toDayMaxTime(String timeStamp) {

        return timeStampToString(timeStamp, DAY_MAX_TIME);
    }
    
    
}
