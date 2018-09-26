package com.xtzn.click.utils;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 功能描述: <br>
 * 获取n个每个小时中的随机分钟辅助类
 *
 * @author zyw
 * @version [版本号, 2018年3月19日]
 */
public class MinuteUtil {

    /**
     * 功能描述: <br>
     * 获取这个小时中number个随机分钟
     *
     * @param number 需要随机出来的数量
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public static String getMinuteRandomValue(int number) {
        String str = "";
        int minute = 0;
        if (number == 0) {
            return str;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < number; i++) {
            minute = (int) (Math.random() * 59);
            list.add(minute);
        }
        Collections.sort(list);
        str = StringUtils.join(list, ",");
        return str;
    }
}
