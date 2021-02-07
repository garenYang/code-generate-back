package com.chinapost.devp.common.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期工具
 *
 * @author: cpit
 * @date: 2020/9/19
 */
public class DateUtil {

    public static final String DATE_FORMAT_1 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_2 = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取日期字符串yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String getDateStr(Date date) {
        return getDateStr(date, DATE_FORMAT_1);
    }

    /**
     * 获取指定格式的日期字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String getDateStr(Date date, String dateFormat) {
        if (date == null || StringUtils.isBlank(dateFormat)) {
            return "";
        }
        return DateFormatUtils.format(date, dateFormat);
    }

    /**
     * 解析日期字符串
     *
     * @param datatime
     * @param dateFormat
     * @return
     */
    public static Date parseDate(String datatime, String dateFormat) {
        if (StringUtils.isBlank(datatime)) {
            return null;
        }
        try {
            return DateUtils.parseDate(datatime, dateFormat);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 获取日期字符串yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String getLocalDateStr(LocalDate date) {
        return getLocalDateStr(date, DATE_FORMAT_1);
    }

    /**
     * 获取指定格式的日期字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String getLocalDateStr(LocalDate date, String dateFormat) {
        if (date == null || StringUtils.isBlank(dateFormat)) {
            return "";
        }
        return date.format(DateTimeFormatter.ofPattern(dateFormat));
    }

    /**
     * 获取日期字符串yyyy-MM-dd HH:mm:ss
     *
     * @param dateTime
     * @return
     */
    public static String getLocalDateTimeStr(LocalDateTime dateTime) {
        return getLocalDateTimeStr(dateTime, DATE_FORMAT_2);
    }

    /**
     * 获取指定格式的日期字符串
     *
     * @param dateTime
     * @param dateFormat
     * @return
     */
    public static String getLocalDateTimeStr(LocalDateTime dateTime, String dateFormat) {
        if (dateTime == null || StringUtils.isBlank(dateFormat)) {
            return "";
        }
        return dateTime.format(DateTimeFormatter.ofPattern(dateFormat));
    }


    /**
     * 解析日期字符串yyyy-MM-dd
     *
     * @param datetime
     * @return
     */
    public static Date parseDate(String datetime) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        String dateFormat;
        if (datetime.length() == DATE_FORMAT_1.length()) {
            dateFormat = DATE_FORMAT_1;
        } else if (datetime.length() == DATE_FORMAT_2.length()) {
            dateFormat = DATE_FORMAT_2;
        } else {
            throw new IllegalArgumentException(MessageSourceUtil.getMessage("error.data_format_error") + ",datetime=" + datetime);
        }
        return parseDate(datetime, dateFormat);
    }


    /**
     * 解析日期字符串
     *
     * @param datetime
     * @return
     */
    public static LocalDate parseLocalDate(String datetime) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        String dateFormat;
        if (datetime.length() == DATE_FORMAT_1.length()) {
            dateFormat = DATE_FORMAT_1;
        } else if (datetime.length() == DATE_FORMAT_2.length()) {
            dateFormat = DATE_FORMAT_2;
        } else {
            throw new IllegalArgumentException(MessageSourceUtil.getMessage("error.data_format_error") + ",datetime=" + datetime);
        }
        return parseLocalDate(datetime, dateFormat);
    }

    /**
     * 解析日期字符串
     *
     * @param datetime
     * @param dateFormat
     * @return
     */
    public static LocalDate parseLocalDate(String datetime, String dateFormat) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        return LocalDate.parse(datetime, DateTimeFormatter.ofPattern(dateFormat));
    }

    /**
     * 解析日期字符串
     *
     * @param datetime
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String datetime) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        String dateFormat;
        if (datetime.length() == DATE_FORMAT_1.length()) {
            dateFormat = DATE_FORMAT_1;
        } else if (datetime.length() == DATE_FORMAT_2.length()) {
            dateFormat = DATE_FORMAT_2;
        } else {
            throw new IllegalArgumentException(MessageSourceUtil.getMessage("error.data_format_error") + ",datetime=" + datetime);
        }
        return parseLocalDateTime(datetime, dateFormat);
    }

    /**
     * 解析日期字符串
     *
     * @param datetime
     * @param dateFormat
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String datetime, String dateFormat) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(dateFormat));
    }

}
