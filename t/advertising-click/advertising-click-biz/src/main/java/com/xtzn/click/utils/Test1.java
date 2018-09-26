package com.xtzn.click.utils;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月7日]
 */
public class Test1 implements Runnable {

    public static void ping02(String ipAddress) throws Exception {
        String line = null;
        try {
            Process pro = Runtime.getRuntime().exec("ping " + ipAddress);
            BufferedReader buf = new BufferedReader(new InputStreamReader(
                    pro.getInputStream(), "gbk"));
            while ((line = buf.readLine()) != null)
                System.out.println(line);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean ping(String ipAddress, int pingTimes, int timeOut) {
        BufferedReader in = null;
        Runtime r = Runtime.getRuntime();  // 将要执行的ping命令,此命令是windows格式的命令
        String pingCommand = "ping " + ipAddress + " -n " + pingTimes + " -w " + timeOut;
        try {   // 执行命令并获取输出
            System.out.println(pingCommand);
            Process p = r.exec(pingCommand);

            if (p == null) {
                return false;
            }
            in = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));   // 逐行检查输出,计算类似出现=23ms TTL=62字样的次数
            int connectedCount = 0;
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }   // 如果出现类似=23ms TTL=62这样的字样,出现的次数=测试次数则返回真
            return connectedCount == pingTimes;
        } catch (Exception ex) {
            ex.printStackTrace();   // 出现异常则返回假
            return false;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        //ping02("198.199.113.98");
        //System.out.println(ping("198.199.113.98", 5, 5000));
		/*ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(100, 200, 5, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>());
		for(int i = 0;i<1000;i++){
			Test1 t = new Test1();
			threadPoolExecutor.execute(t);
		}*/
        for (byte i = 9; i >= 0; i--) {
            System.out.println(i);
        }
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月15日]
     */
    @Override
    public void run() {

        String sessionid = UUID.randomUUID().toString();
        String user = "lum-customer-nanjingtechnology-zone-click-country-US";
        HttpHost proxy = new HttpHost("servercountry-cn.zproxy.lum-superproxy.io", 22225);
        String res;
        try {
            res = Executor.newInstance()
                    .auth(user, "hnbohnfhyyuk")
                    .execute(Request.Get("http://lumtest.com/myip.json").viaProxy(proxy)).returnContent().toString();
            System.out.println(res);
        } catch (ClientProtocolException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
