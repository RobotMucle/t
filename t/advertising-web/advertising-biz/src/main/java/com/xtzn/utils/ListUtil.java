package com.xtzn.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月12日]
 */
public class ListUtil {

    public static List<Integer> dataList(String ids) {
        List<Integer> list = new ArrayList<Integer>();
        String[] str = ids.split(",");
        for (int i = 0; i < str.length; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        return list;
    }


}
