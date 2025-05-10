package com.longYin.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class DateUtils {

    /**
     * 获取当前时间戳（毫秒级）
     *
     * @return 当前时间戳（毫秒）
     */
    public static long getCurrentTimestampInMilliseconds() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间戳（秒级）
     *
     * @return 当前时间戳（秒）
     */
    public static long getCurrentTimestampInSeconds() {
        return Instant.now().getEpochSecond();
    }

    /**
     * 获取当前日期，支持自定义日期格式
     *
     * @param format 自定义日期格式（例如 "yyyy-MM-dd" 或 "yyyy/MM/dd HH:mm:ss"）
     * @return 格式化后的当前日期字符串
     */
    public static String getCurrentDate(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.now().format(formatter);
    }

    /**
     * 获取当日起始时间（即当天00:00:00）
     *
     * @return 当日开始的LocalDateTime对象
     */
    public static LocalDateTime getTodayStart() {
        return LocalDate.now().atStartOfDay();
    }

    /**
     * 获取当日结束时间（即当天23:59:59.999）
     *
     * @return 当日结束的LocalDateTime对象
     */
    public static LocalDateTime getTodayEnd() {
        return LocalDate.now().atTime(LocalTime.MAX);
    }

    /**
     * 获取当日起始时间的字符串表示，支持自定义日期时间格式
     *
     * @param format 自定义日期时间格式（例如 "yyyy-MM-dd HH:mm:ss"）
     * @return 格式化后的当日起始时间字符串
     */
    public static String getTodayStartAsString(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return getTodayStart().format(formatter);
    }

    /**
     * 获取当日结束时间的字符串表示，支持自定义日期时间格式
     *
     * @param format 自定义日期时间格式（例如 "yyyy-MM-dd HH:mm:ss"）
     * @return 格式化后的当日结束时间字符串
     */
    public static String getTodayEndAsString(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return getTodayEnd().format(formatter);
    }

    /**
     * 将字符串解析为LocalDateTime对象，使用给定的日期时间格式
     *
     * @param dateTimeStr 字符串形式的日期时间
     * @param format      日期时间格式（例如 "yyyy-MM-dd HH:mm:ss"）
     * @return 解析后的LocalDateTime对象
     */
    public static LocalDateTime parseDateTime(String dateTimeStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateTimeStr, formatter);
    }

    /**
     * 获取指定天数的当日的起始时间和结束时间
     * @param days      相对于当前日期的天数，负数表示之前，正数表示之后
     * @param format    自定义日期时间格式（例如 "yyyy-MM-dd HH:mm:ss"）
     * @return          一个包含起始时间和结束时间的Map对象，键分别为 "start" 和 "end"
     */
    public static Map<String, String> getStartDateAndEndTimeForDays(int days, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        LocalDate targetDate = LocalDate.now().plusDays(days);
        LocalDateTime startOfDay = targetDate.atStartOfDay();
        LocalDateTime endOfDay = targetDate.atTime(LocalTime.MAX);

        String startDate = startOfDay.format(formatter);
        String endDate = endOfDay.format(formatter);

        return Map.of("start", startDate, "end", endDate);
    }


    /**
     * 获取指定天数与今日的日期区间
     * @param days
     * @param format
     * @return
     */
    public static Map<String, String> getStartDateToEndTimeForDays(int days, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        //开始时间 如果days为负 则开始时间为正常，如果为正数则为今日，只设置结束时间进行计算天数推算
        LocalDate startTargetDate;
        LocalDate endTargetDate;

        if (days >= 0) {
            // days 为正数时，开始时间设为今日
            startTargetDate = LocalDate.now();
            endTargetDate = LocalDate.now().plusDays(days); // 结束时间始终为今日
        } else {
            // days 为负数时，开始时间保持原样（根据 days 计算）
            startTargetDate = LocalDate.now().plusDays(days);
            endTargetDate = LocalDate.now(); // 结束时间始终为今日

        }

        LocalDateTime startOfDay = startTargetDate.atStartOfDay();
        LocalDateTime endOfDay = endTargetDate.atTime(LocalTime.MAX);

        String startDate = startOfDay.format(formatter);
        String endDate = endOfDay.format(formatter);

        return Map.of("start", startDate, "end", endDate);
    }

    /**
     * 获取指定天数之前（负数）或之后（正数）的起始时间和结束时间的字符串表示，支持自定义日期时间格式。
     *
     * @param days      相对于当前日期的天数，负数表示之前，正数表示之后
     * @param format    自定义日期时间格式（例如 "yyyy-MM-dd HH:mm:ss"）
     * @return          一个包含起始时间和结束时间的Map对象，键分别为 "start" 和 "end"
     */
    public static Map<String, String> getStartDateAndEndTimeForDaysBefore(int days, String format) {
        return getStartDateAndEndTimeForDays(-days, format);
    }

    /**
     * 获取指定天数之后的起始时间和结束时间的字符串表示，支持自定义日期时间格式。
     *
     * @param days      相对于当前日期的天数，正数表示之后
     * @param format    自定义日期时间格式（例如 "yyyy-MM-dd HH:mm:ss"）
     * @return          一个包含起始时间和结束时间的Map对象，键分别为 "start" 和 "end"
     */
    public static Map<String, String> getStartDateAndEndTimeForDaysAfter(int days, String format) {
        return getStartDateAndEndTimeForDays(days, format);
    }
}

