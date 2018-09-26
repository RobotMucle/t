package com.xtzn.core.utils;

import java.util.Calendar;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月25日]
 */
public class CurrentTimeUtil {

    public static String currentTime() {
        Calendar c = Calendar.getInstance();
        String currentTime = "";
        if (c.get(Calendar.MONTH) + 1 < 10) {
            if (c.get(Calendar.DAY_OF_MONTH) < 10) {
                currentTime = currentTime + c.get(Calendar.YEAR) + "0" + (c.get(Calendar.MONTH) + 1) + "0" + c.get(Calendar.DAY_OF_MONTH);
            } else {
                currentTime = currentTime + c.get(Calendar.YEAR) + "0" + (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DAY_OF_MONTH);
            }
        } else {
            if (c.get(Calendar.DAY_OF_MONTH) < 10) {
                currentTime = currentTime + c.get(Calendar.YEAR) + (c.get(Calendar.MONTH) + 1) + "0" + c.get(Calendar.DAY_OF_MONTH);
            } else {
                currentTime = currentTime + c.get(Calendar.YEAR) + (c.get(Calendar.MONTH) + 1) + c.get(Calendar.DAY_OF_MONTH);
            }
        }
        return currentTime;
    }

}
