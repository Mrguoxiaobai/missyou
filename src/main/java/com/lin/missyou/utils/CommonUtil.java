package com.lin.missyou.utils;

import com.lin.missyou.bo.PageCounter;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Common util.
 *
 * @ClassName: com.lin.missyou.utils
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021 /6/16
 * @Version: 1.0
 */
public class CommonUtil {
    /**
     * Convert to page parameter page counter.
     *
     * @param start the start
     * @param count the count
     * @return the page counter
     */
    public static PageCounter convertToPageParameter(Integer start,Integer count){
        Integer pageNum=start/count;
        PageCounter pageCounter = PageCounter.builder()
                .pageNum(pageNum)
                .size(count)
                .build();
        return pageCounter;
    }

    /**
     * Is in time line boolean.
     *
     * @param date  the date
     * @param start the start
     * @param end   the end
     * @return the boolean
     */
    public static Boolean isInTimeLine(Date date, Date start, Date end) {
        Long time = date.getTime();
        Long startTime = start.getTime();
        Long endTime = end.getTime();
        if (time > startTime && time < endTime) {
            return true;
        }
        return false;
    }


    /**
     * Add some seconds calendar.
     *
     * @param calendar the calendar
     * @param seconds  the seconds
     * @return the calendar
     */
    public static Calendar addSomeSeconds(Calendar calendar, Integer seconds) {
        calendar.add(Calendar.SECOND, seconds);
        return calendar;
    }


    /**
     * Timestamp 10 string.
     *
     * @return the string
     */
    public static String timestamp10(){
        Long timestamp13 = Calendar.getInstance().getTimeInMillis();
        String timestamp13Str = timestamp13.toString();
        return timestamp13Str.substring(0, timestamp13Str.length() - 3);
    }

    /**
     * Is out of date boolean.
     *
     * @param startTime the start time
     * @param period    the period
     * @return the boolean
     */
    public static Boolean isOutOfDate(Date startTime, Long period) {
        Long now = Calendar.getInstance().getTimeInMillis();
        Long startTimeStamp = startTime.getTime();
        Long periodMillSecond = period * 1000;
        if (now > (startTimeStamp + periodMillSecond)) {
            return true;
        }
        return false;
    }

    /**
     * Is out of date boolean.
     *
     * @param expiredTime the expired time
     * @return the boolean
     */
    public static Boolean isOutOfDate(Date expiredTime) {
        Long now = Calendar.getInstance().getTimeInMillis();
        Long expiredTimeStamp = expiredTime.getTime();
        if(now > expiredTimeStamp){
            return true;
        }
        return false;
    }

    /**
     * Yuan to fen plain string string.
     *
     * @param p the p
     * @return the string
     */
    public static String yuanToFenPlainString(BigDecimal p){
        p = p.multiply(new BigDecimal("100"));
        return CommonUtil.toPlain(p);
    }

    /**
     * To plain string.
     *
     * @param p the p
     * @return the string
     */
    public static String toPlain(BigDecimal p){
        return p.stripTrailingZeros().toPlainString();
    }

}
