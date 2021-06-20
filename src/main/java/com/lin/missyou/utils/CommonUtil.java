package com.lin.missyou.utils;

import com.lin.missyou.bo.PageCounter;

import java.util.Date;

/**
 * @ClassName: com.lin.missyou.utils
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/16
 * @Version: 1.0
 */
public class CommonUtil {
   public static PageCounter convertToPageParameter(Integer start,Integer count){
        Integer pageNum=start/count;
        PageCounter pageCounter = PageCounter.builder()
                .pageNum(pageNum)
                .size(count)
                .build();
        return pageCounter;
    }
    public static Boolean isInTimeLine(Date date, Date start, Date end) {
        Long time = date.getTime();
        Long startTime = start.getTime();
        Long endTime = end.getTime();
        if (time > startTime && time < endTime) {
            return true;
        }
        return false;
    }
}
