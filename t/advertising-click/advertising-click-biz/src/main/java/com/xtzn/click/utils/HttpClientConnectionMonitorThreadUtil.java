package com.xtzn.click.utils;

import org.apache.http.conn.HttpClientConnectionManager;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月6日]
 */
public class HttpClientConnectionMonitorThreadUtil extends Thread {

    private final HttpClientConnectionManager connManager;
    private volatile boolean shutdown;

    public HttpClientConnectionMonitorThreadUtil(HttpClientConnectionManager connManager) {
        super();
        //this.setName("http-connection-monitor");
        //this.setDaemon(true);
        this.connManager = connManager;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(2000); // 等待2秒
                    // 关闭过期的链接
                    connManager.closeExpiredConnections();
                    // 选择关闭 空闲30秒的链接
                    connManager.closeIdleConnections(30, TimeUnit.SECONDS);
                }
            }
        } catch (InterruptedException ex) {
        }
    }
}
