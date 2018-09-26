package com.xtzn.click.utils;

import java.util.UUID;

public class SubIdUtil {

    /**
     * 功能描述: <br>
     * 获得8位16进制数字
     *
     * @author zyw
     * @version [版本号, 2018年3月16日]
     */
    public static String getRandomValue() {
        String str = "";
        for (int i = 0; i < 8; i++) {
            char temp = 0;
            int key = (int) (Math.random() * 2);
            switch (key) {
                case 0:
                    temp = (char) (Math.random() * 10 + 48);//产生随机数字
                    break;
                case 1:
                    temp = (char) (Math.random() * 6 + 'a');//产生a-f
                    break;
                default:
                    break;
            }
            str = str + temp;
        }
        return str;
    }

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
