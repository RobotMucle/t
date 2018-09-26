package com.xtzn.click.utils;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月6日]
 */
public class Test {

    public static void main(String[] args) {
        //String browserPath = "D:/phantomjs-2.1.1-windows/bin/phantomjs.exe";
        //System.setProperty("phantomjs.binary.path", browserPath);
        //WebDriver driver = new PhantomJSDriver();
        String sessionUUid = UUID.randomUUID().toString();
        sessionUUid = sessionUUid.replaceAll("-", "");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        String host = "servercountry-cn.zproxy.lum-superproxy.io";
        int port = 22225;
        String username = "lum-customer-nanjingtechnology-zone-click-country-US-session-glob_" + sessionUUid;
        String password = "hnbohnfhyyuk";
        ArrayList<String> cliArgsCap = new ArrayList<>();
        cliArgsCap.add("--proxy=http://" + host + ":" + port);
        cliArgsCap.add("--proxy-auth=" + username + ":" + password);
        cliArgsCap.add("--proxy-type=http");
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
         /*desiredCapabilities.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1");
         desiredCapabilities.setCapability("phantomjs.page.customHeaders.User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1");
         desiredCapabilities.setCapability("phantomjs.page.settings.loadImages", true);
         desiredCapabilities.setCapability("phantomjs.page.settings.disk-cache", true);*/
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:/phantomjs-2.1.1-windows/bin/phantomjs.exe");
         /*Proxy proxy = new Proxy();
         proxy.setProxyType(org.openqa.selenium.Proxy.ProxyType.MANUAL);
         proxy.setAutodetect(false);
         String proxyIp = "servercountry-cn.zproxy.lum-superproxy.io";
         int proxyPort = 22225;
         proxy.setHttpProxy(proxyIp + ":" + proxyPort);
         desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);*/
        desiredCapabilities.setCapability("acceptSslCerts", true);
        desiredCapabilities.setJavascriptEnabled(true);

        PhantomJSDriver driver = new PhantomJSDriver(desiredCapabilities);
        String url = "http://zp.zpmobtra.com/click.php?camp_id=570&key=b72ef172025d3665832e97ef&subid=1104bdba066a4e6192af6874ab4c868b&idfa=ad2facb8-62a0-4da4-88ea-29bd8f0c433c";
        String url1 = "http://www.abtracking.com/click.php?camp_id=570&key=5c480abdf9cc8df3d42ef4d8&subid=917eba3e429b440bad733e7f7e6d4331&idfa=c7f5de6d-a469-4ad1-9314-14520cdc2d81";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url1);
        //driver.execute_script("window.scrollTo(0, document.body.scrollHeight)");
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        //driver.close();
    }
}
