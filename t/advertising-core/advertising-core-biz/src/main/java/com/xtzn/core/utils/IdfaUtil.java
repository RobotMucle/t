package com.xtzn.core.utils;

public class IdfaUtil {

    /**
     * 功能描述: <br>
     * 根据idfa规则生成一个idfa
     *
     * @author zyw
     * @version [版本号, 2018年3月16日]
     */
    public static String getIdfa() {
        String str = getEightNum() + "-" + getFourNum() + "-" + getSecondFourNum() + "-" + getFourNum() + "-" + getTwelveNum();
        return str;
    }

    /**
     * 功能描述: <br>
     * 获得4位16进制数字
     *
     * @author zyw
     * @version [版本号, 2018年3月16日]
     */
    private static String getFourNum() {
        String str = "";
        for (int i = 0; i < 4; i++) {
            char temp = 0;
            int key = (int) (Math.random() * 2);
            switch (key) {
                case 0:
                    temp = (char) (Math.random() * 10 + 48);//产生随机数字
                    break;
                case 1:
                    temp = (char) (Math.random() * 6 + 'A');//产生a-f
                    break;
                default:
                    break;
            }
            str = str + temp;
        }
        return str;
    }

    /**
     * 功能描述: <br>
     * 获得一个特殊的4位16进制数字
     *
     * @author zyw
     * @version [版本号, 2018年3月16日]
     */
    private static String getSecondFourNum() {
        String str = "4";
        for (int i = 0; i < 3; i++) {
            char temp = 0;
            int key = (int) (Math.random() * 2);
            switch (key) {
                case 0:
                    temp = (char) (Math.random() * 10 + 48);//产生随机数字
                    break;
                case 1:
                    temp = (char) (Math.random() * 6 + 'A');//产生a-f
                    break;
                default:
                    break;
            }
            str = str + temp;
        }
        return str;
    }

    /**
     * 功能描述: <br>
     * 获得8位16进制数字
     *
     * @author zyw
     * @version [版本号, 2018年3月16日]
     */
    private static String getEightNum() {
        String str = "";
        for (int i = 0; i < 8; i++) {
            char temp = 0;
            int key = (int) (Math.random() * 2);
            switch (key) {
                case 0:
                    temp = (char) (Math.random() * 10 + 48);//产生随机数字
                    break;
                case 1:
                    temp = (char) (Math.random() * 6 + 'A');//产生a-f
                    break;
                default:
                    break;
            }
            str = str + temp;
        }
        return str;
    }

    /**
     * 功能描述: <br>
     * 获得12位16进制数字
     *
     * @author zyw
     * @version [版本号, 2018年3月16日]
     */
    private static String getTwelveNum() {
        String str = "";
        for (int i = 0; i < 12; i++) {
            char temp = 0;
            int key = (int) (Math.random() * 2);
            switch (key) {
                case 0:
                    temp = (char) (Math.random() * 10 + 48);//产生随机数字
                    break;
                case 1:
                    temp = (char) (Math.random() * 6 + 'A');//产生a-f
                    break;
                default:
                    break;
            }
            str = str + temp;
        }
        return str;
    }
}
