package com.xtzn.click.utils;

import com.xtzn.click.mapper.entity.Header;
import com.xtzn.click.service.ITaskListService;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述: <br>
 * 跑点击的线程执行类
 *
 * @author zyw
 * @version [版本号, 2018年3月14日]
 */
public class RunClickExcutorUtil implements Runnable {

    //private Integer clickCount;
    public static final int n_parallel_exit_nodes = 100;
    public static final int n_total_req = 1000;
    public static final int switch_ip_every_n_req = 40;
    private static final Logger log = LoggerFactory.getLogger(RunClickExcutorUtil.class);
    public static AtomicInteger at_req = new AtomicInteger(0);
    private String customer;
    private String zone;
    private String password;
    private Integer port;
    private String country;
    private String landingPageLink;
    private Integer taskId;
    private String sessionUUid;
    private ITaskListService taskListService;

    private List<Header> header;

    public RunClickExcutorUtil(String customer, String zone, String password, Integer port, String country, List<Header> header, String landingPageLink, Integer taskId, String sessionUUid, ITaskListService taskListService) {
        super();
        this.customer = customer;
        this.zone = zone;
        this.password = password;
        this.port = port;
        this.country = country;
        this.header = header;
        this.landingPageLink = landingPageLink;
        this.taskId = taskId;
        this.sessionUUid = sessionUUid;
        this.taskListService = taskListService;
        //this.clickCount = clickCount;
    }

    @Override
    public void run() {
        // 递归跳转
		/*String url = clickRecursion(customer, zone, password, port, country, header, landingPageLink, taskId, session, taskListService);
		while(true){
			if(null!=url){
				url = clickRecursion(customer, zone, password, port, country, header, url, taskId, session, taskListService);
			}
			return;
		}*/
		/*try {
			Thread.sleep(500);
			click(customer, zone, password, port, country, header, landingPageLink, taskId, sessionUUid, taskListService);

		} catch (InterruptedException e) {

			log.error("Thread is exception", e);
		}*/
        click(customer, zone, password, port, country, header, landingPageLink, taskId, sessionUUid, taskListService);
        //urlRecursion(customer, zone, password, port, country, header, landingPageLink, taskId,session, taskListService);
        //更新task_list中click_count
        //taskListService.updateClickNum(taskId);
    }

    /*public void click(String customer, String zone, String password, Integer port, String country, List<Header> header, String landingPageLink,Integer taskId,String sessionUUid,ITaskListService taskListService){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        String host = "servercountry-cn.zproxy.lum-superproxy.io";
        //int port = 22225;
        String username = "lum-customer-"+customer+"-zone-"+zone+"-country-"+country+"-session-glob_"+sessionUUid;
        //String username = "lum-customer-"+"nanjingtechnology"+"-zone-"+""+"-country-"+country+"-session-glob_"+sessionUUid;
        //String password = "hnbohnfhyyuk";
        ArrayList<String> cliArgsCap = new ArrayList<>();
        cliArgsCap.add("--proxy=http://"+host+":"+port);
        cliArgsCap.add("--proxy-auth=" + username + ":" + password);
        cliArgsCap.add("--proxy-type=http");
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
        int size = (int)(Math.random()*header.size());
        String userAgent = header.get(size).getUserAgent();
        desiredCapabilities.setCapability("phantomjs.page.settings.userAgent", userAgent);
        desiredCapabilities.setCapability("phantomjs.page.customHeaders.User-Agent", userAgent);
        desiredCapabilities.setCapability("phantomjs.page.settings.loadImages", false);
        //desiredCapabilities.setCapability("phantomjs.page.settings.disk-cache", true);
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:/phantomjs-2.1.1-windows/bin/phantomjs.exe");
        desiredCapabilities.setCapability("acceptSslCerts", true);
        desiredCapabilities.setJavascriptEnabled(true);

        PhantomJSDriver driver = new PhantomJSDriver(desiredCapabilities);
        try{

            //String url = "http://zp.zpmobtra.com/click.php?camp_id=570&key=b72ef172025d3665832e97ef&subid=1104bdba066a4e6192af6874ab4c868b&idfa=ad2facb8-62a0-4da4-88ea-29bd8f0c433c";
            //String url1 = "http://www.abtracking.com/click.php?camp_id=570&key=5c480abdf9cc8df3d42ef4d8&subid=917eba3e429b440bad733e7f7e6d4331&idfa=c7f5de6d-a469-4ad1-9314-14520cdc2d81";
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(landingPageLink);
            String pageSource = driver.getPageSource();
            System.out.println(pageSource);
        }
        finally{
            driver.quit();

        }
    }*/
    public void click(String customer, String zone, String password, Integer port, String country, List<Header> header, String landingPageLink, Integer taskId, String sessionUUid, ITaskListService taskListService) {
        int size = (int) (Math.random() * header.size());
        String userAgent = header.get(size).getUserAgent();
        //String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1";
        String username = "lum-customer-" + customer + "-zone-" + zone + "-country-" + country + "-session-glob_" + sessionUUid;
        ClientUtil client = new ClientUtil(country, "198.199.113.98", username, password, userAgent, landingPageLink, port);
        try {
    		/*CloseableHttpResponse response = client.request("http://lumtest.com/myip.json");
            int code = response.getStatusLine().getStatusCode();
            if(code!=200){
            	client.close();
            	client = new ClientUtil(country, "servercountry-cn.zproxy.lum-superproxy.io", username, password, userAgent, landingPageLink,port);
            	response = client.request("http://lumtest.com/myip.json");
            	code = response.getStatusLine().getStatusCode();
            	if(code!=200){
            		client.close();
                	client = new ClientUtil(country, "servercountry-cn.zproxy.lum-superproxy.io", username, password, userAgent, landingPageLink,port);
                	response = client.request("http://lumtest.com/myip.json");
                	code = response.getStatusLine().getStatusCode();
                	if(code!=200){
                		log.info("taskId。。。"+taskId+"代理已测试3次,代理走不通");
                		return;
                	}
            	}
            }*/
            CloseableHttpResponse response = client.request(landingPageLink.trim());
            String responseHtml = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
            log.info("任务taskId为。。。。。。" + taskId + "。。。。。页面内容。。。。。。" + responseHtml);
            //Pattern pattern = Pattern.compile("([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)+\\&{0,1})*)",Pattern.CASE_INSENSITIVE);
            //Pattern pattern = Pattern.compile("([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1}[A-Za-z0-9-~]*)+\\&{0,1})*)",Pattern.CASE_INSENSITIVE);
            Pattern pattern = Pattern.compile("((http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+}{?:_/=<>]*)?)|(www.[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+}{?:_/=<>]*)?)");
            Matcher matcher = pattern.matcher(responseHtml);
            Set<String> set = new HashSet<>();
            while (matcher.find()) {
                set.add(matcher.group());
            }
            if (!set.isEmpty()) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    String url = it.next();
                    Pattern pat = Pattern.compile(".jpg|.png|.gif|.mp3|.mp4|.js");
                    Matcher mat = pat.matcher(url);
                    if (mat.find()) {
                        continue;
                    }
                    System.out.println(url);
                    int size1 = (int) (Math.random() * header.size());
                    String userAgent1 = header.get(size1).getUserAgent();
                    //String userAgent1 = "Mozilla/5.0 (iPad; CPU OS 9_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/9.0 Mobile/13A452 Sarafi/600.1.4";
                    //String userAgent1 = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/11.0 Mobile/15E148 Safari/604.1";
                    //System.out.println("2...."+userAgent1);
                    ClientUtil client2 = new ClientUtil(country, "198.199.113.98", username, password, userAgent1, url, port);
					/*response = client.request("http://lumtest.com/myip.json");
		            code = response.getStatusLine().getStatusCode();
		            if(code!=200){
		            	client.close();
		            	client = new ClientUtil(country, "servercountry-cn.zproxy.lum-superproxy.io", username, password, userAgent1, url,port);
		            	response = client.request("http://lumtest.com/myip.json");
		            	code = response.getStatusLine().getStatusCode();
		            	if(code!=200){
		            		client.close();
		                	client = new ClientUtil(country, "servercountry-cn.zproxy.lum-superproxy.io", username, password, userAgent1, url,port);
		                	response = client.request("http://lumtest.com/myip.json");
		                	code = response.getStatusLine().getStatusCode();
		                	if(code!=200){
		                		log.info("taskId。。。"+taskId+"代理已测试3次,代理走不通");
		                		return;
		                	}
		            	}
		            }*/
					/*if (!client.have_good_super_proxy())
		                client.switch_session_id();
		            if (client.n_req_for_exit_node == switch_ip_every_n_req)
		                client.switch_session_id();*/

                    response = client2.request(url);
                    log.info(IOUtils.toString(response.getEntity().getContent(), "UTF-8"));
                }
            }
    		/*while(true){
    			if(null!=responseHtml){
        			responseHtml = urlRecursion(responseHtml, client);
        		}
    			return;
    		}*/


        } catch (IOException e) {
            log.error("client.request is exception", e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }

    /*public  void click(String customer, String zone, String password, Integer port, String country, List<Header> header, String landingPageLink,Integer taskId,String sessionUUid,ITaskListService taskListService,Integer clickCount){
    	for(int i = 0;i<clickCount;i++){
    		String subid = UUID.randomUUID().toString();
        	String idfa = UUID.randomUUID().toString();
        	idfa = idfa.replaceAll(String.valueOf(idfa.charAt(14)), "4");
        	subid = subid.replaceAll("-", "");
        	landingPageLink = landingPageLink.replace("[[subid]]", subid);
        	landingPageLink = landingPageLink.replace("[[idfa]]", idfa);
        	int size = (int)(Math.random()*header.size());
        	String userAgent = header.get(size).getUserAgent();
        	String username = "lum-customer-"+customer+"-zone-"+zone+"-country-"+country+"-session-glob_"+sessionUUid;
        	ClientUtil client = new ClientUtil(country, "servercountry-cn.zproxy.lum-superproxy.io", username, password, userAgent, landingPageLink,port);
        	try {
        		System.out.println(landingPageLink);
        		System.out.println(idfa);
        		System.out.println("1...."+userAgent);
        		CloseableHttpResponse  response = client.request(landingPageLink);
        		String responseHtml = IOUtils.toString(response.getEntity().getContent(),"UTF-8");
        		log.info(responseHtml);
        		//Pattern pattern = Pattern.compile("([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)+\\&{0,1})*)",Pattern.CASE_INSENSITIVE);
        		//Pattern pattern = Pattern.compile("([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1}[A-Za-z0-9-~]*)+\\&{0,1})*)",Pattern.CASE_INSENSITIVE);
        		Pattern pattern = Pattern.compile("((http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+}{?:_/=<>]*)?)|(www.[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+}{?:_/=<>]*)?)");
        		Matcher matcher = pattern.matcher(responseHtml);
    			Set<String> set = new HashSet<>();
    			while(matcher.find()){
    				set.add(matcher.group());
    			}
    			if(!set.isEmpty()){
    				Iterator<String> it = set.iterator();
    				while(it.hasNext()){
    					String url = it.next();
    					Pattern pat = Pattern.compile(".jpg|.png|.gif|.mp3|.mp4|.js");
    					Matcher mat = pat.matcher(url);
    					if(mat.find()){
    						continue;
    					}
    					//System.out.println(url);
    					int size1 = (int)(Math.random()*header.size());
    		        	//String userAgent1 = header.get(size1).getUserAgent();
    		        	//String userAgent1 = "Mozilla/5.0 (iPad; CPU OS 9_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/9.0 Mobile/13A452 Sarafi/600.1.4";
    		        	String userAgent1 = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/11.0 Mobile/15E148 Safari/604.1";
    		        	System.out.println("2...."+userAgent1);
    					ClientUtil client2 = new ClientUtil(country, "servercountry-cn.zproxy.lum-superproxy.io", username, password,userAgent1 , landingPageLink,port);
    					response = client2.request(url);
    					log.info(IOUtils.toString(response.getEntity().getContent(),"UTF-8"));
    				}
    			}
        		while(true){
        			if(null!=responseHtml){
            			responseHtml = urlRecursion(responseHtml, client);
            		}
        			return;
        		}


    		} catch (IOException e) {
    			log.error("client.request is exception", e);
    		}
    	}

    }*/
    public String urlRecursion(String responseHtml, ClientUtil client) {
        try {
            Pattern pattern = Pattern.compile("((http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+}{?:_/=<>]*)?)|(www.[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+}{?:_/=<>]*)?)");
            Matcher matcher = pattern.matcher(responseHtml);
            Set<String> set = new HashSet<>();
            while (matcher.find()) {
                set.add(matcher.group());
            }
            if (!set.isEmpty()) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    String url = it.next();
                    Pattern pat = Pattern.compile(".jpg|.png|.gif|.mp3|.mp4|.js");
                    Matcher mat = pat.matcher(url);
                    if (mat.find()) {
                        continue;
                    }
                    //System.out.println(url);
                    CloseableHttpResponse response = client.request(url);
                    responseHtml = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
                    log.info(responseHtml);
                    return responseHtml;
                }
            }
            return null;
        } catch (Exception e) {
            log.error("client.request is exception", e);
        }
        return null;
    }
   /* public String clickRecursion(String customer, String zone, String password, Integer port, String country, List<Header> header, String landingPageLink,Integer taskId,Integer session,ITaskListService taskListService){
    	int size = (int)(Math.random()*header.size());
    	String userAgent = header.get(size).getUserAgent();
    	String username = "lum-customer-"+customer+"-zone-"+zone;
    	ClientUtil client = new ClientUtil(country, "servercountry-cn.zproxy.lum-superproxy.io", username, password, userAgent, landingPageLink,port);
    	if (!client.have_good_super_proxy()){
    		client.switch_session_id();
    	}
        if (client.n_req_for_exit_node == switch_ip_every_n_req){
        	client.switch_session_id();
        }
        CloseableHttpResponse response = null;
        try {
        	System.out.println(landingPageLink);
            response = client.request(landingPageLink);
            //int code = response.getStatusLine().getStatusCode();
            //System.out.println("2...."+EntityUtils.toString(response.getEntity()));
            String res = EntityUtils.toString(response.getEntity());
            //response.close();
           // client.close();
            System.out.println(res);
            Pattern pattern = Pattern.compile("([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)");
			Matcher matcher = pattern.matcher(res);
			Set<String> set = new HashSet<>();
			while(matcher.find()){
				set.add(matcher.group());
			}
			if(!set.isEmpty()){
				Iterator<String> it = set.iterator();
				while(it.hasNext()){
					String url = it.next();
					Pattern pat = Pattern.compile(".jpg|.png|.gif|.mp3|.mp4|.js");
					Matcher mat = pat.matcher(url);
					if(mat.find()){
						continue;
					}
				}
			}
			if(!set.isEmpty()){
				Iterator<String> it = set.iterator();
				return it.next();
			}
			return null;
        } catch (IOException e) {
        	log.error(ResponseEnum.PROXY_ERROR.getCode(), ResponseEnum.PROXY_ERROR.getDesc(),e);
        } finally {
            try {
                if (response != null){
                	 response.close();
                	 //client.close();
                }
                //client.close();
            } catch (Exception e) {}
        }
        return null;
    }
    private void urlRecursion(String customer, String zone, String password, Integer port, String country, List<Header> header, String landingPageLink,Integer taskId,Integer session,ITaskListService taskListService){
    	HttpHost proxy = new HttpHost("zproxy.lum-superproxy.io", 22225);
        String res;
		try {
			res = Executor.newInstance()
			    .auth(proxy, "lum-customer-"+customer+"-zone-"+zone+"-country-"+country+"-session-"+session+"_1", password)
			    .execute(Request.Get(landingPageLink)
			    .viaProxy(proxy))
			    .returnContent().asString();
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

    }
	private void urlRecursion(String customer, String zone, String password, Integer port, String country, List<Header> header, String landingPageLink,Integer taskId,Integer session,ITaskListService taskListService){
		String userAgent = null;
		int size = (int)(Math.random()*header.size());
		if(landingPageLink!=null){
			userAgent = header.get(size).getUserAgent();
			HttpHost proxy = new HttpHost("servercountry-cn.zproxy.lum-superproxy.io", port);
			//+"-session-"+session+"_1"
			String str = "lum-customer-"+customer+"-zone-"+zone+"-country-"+country;

			try {

			    	String res = Executor.newInstance()
						    .auth(proxy, str, password)
						    .execute(Request.Get(landingPageLink)
						    .addHeader("user-agent", userAgent)
						    .addHeader("Connection","keep-alive")
						    .addHeader("Accept-Encoding","gzip,deflate")
						    .addHeader("Content_Type", "text/html")
						    .addHeader("accept","text/html")
						    .connectTimeout(40*1000)
						    .viaProxy(proxy))
						    .returnContent()
						    .asString();
					Pattern pattern = Pattern.compile("([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)");
					Matcher matcher = pattern.matcher(res);
					Set<String> set = new HashSet<>();
					while(matcher.find()){
						set.add(matcher.group());
					}
					if(!set.isEmpty()){
						Iterator<String> it = set.iterator();
						while(it.hasNext()){
							String url = it.next();
							Pattern pat = Pattern.compile(".jpg|.png|.gif|.mp3|.mp4");
							Matcher mat = pat.matcher(url);
							if(mat.find()){
								continue;
							}
							//servercountry-CN.zproxy.luminati.io
							HttpHost proxy1 = new HttpHost("servercountry-cn.zproxy.lum-superproxy.io", port);
							String str1 = "lum-customer-"+customer+"-zone-"+zone+"-country-"+country;
							userAgent = header.get(size).getUserAgent();
							//String value = "jsessionId=abd12b1f2d34df12d412f21d31f1a12321b;path=/;expires=";
							String res1 = Executor.newInstance()
								    .auth(proxy1, str1, password)
								    .execute(Request.Get(url)
								    .addHeader("user-agent", userAgent)
								    .addHeader("Connection","keep-alive")
								    .addHeader("Accept-Encoding","gzip,deflate")
								    .addHeader("referer", landingPageLink)
								    .addHeader("Content_Type", "text/html")
								    .addHeader("accept","text/html")
								    .viaProxy(proxy1))
								    .returnContent().asString();


					}
			    }

			} catch (ClientProtocolException e) {
				log.error(ResponseEnum.PROXY_ERROR.getCode(), ResponseEnum.PROXY_ERROR.getDesc(),e);
				return;
			} catch (IOException e) {
				log.error(ResponseEnum.PROXY_ERROR.getCode(), ResponseEnum.PROXY_ERROR.getDesc(),e);
				return;
			}
		}
		//更新task_list中click_count
		//taskListService.updateClickNum(taskId);
	}*/

	/*private void urlRecursion(String customer, String zone, String password, Integer port, String country, List<Header> header, String landingPageLink,Integer taskId,Integer session,ITaskListService taskListService){
		String userAgent = null;
		int size = (int)(Math.random()*header.size());
		if(landingPageLink!=null){
			userAgent = header.get(size).getUserAgent();
			HttpHost proxy = new HttpHost("servercountry-cn.zproxy.lum-superproxy.io", port);
			String str = "lum-customer-"+customer+"-zone-"+zone+"-country-"+country+"-session-"+session+"_1";
			try{
				String res = Executor.newInstance()
					    .auth(proxy, str, password)
					    .execute(Request.Get(landingPageLink)
					    .addHeader("user-agent", userAgent)
					    .addHeader("Connection","keep-alive")
					    .addHeader("Accept-Encoding","gzip,deflate")
					    .addHeader("Content_Type", "text/html")
					    .addHeader("accept","text/html")
					    .connectTimeout(10*1000)
					    .viaProxy(proxy))
					    .returnContent()
					    .asString();
				Pattern pattern = Pattern.compile("([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)");
				Matcher matcher = pattern.matcher(res);
				while(matcher.find()){
					set.add(matcher.group());
				}
				if(!set.isEmpty()){
					Iterator<String> it = set.iterator();
					while(it.hasNext()){
						String url = it.next();
						Pattern pat = Pattern.compile(".jpg|.png|.gif|.mp3|.mp4");
						Matcher mat = pat.matcher(url);
						if(mat.find()){
							continue;
						}
						userAgent = header.get(size).getUserAgent();
						String username = "lum-customer-"+customer+"-zone-"+zone;
						ClientUtil client = new ClientUtil(country, "servercountry-cn.zproxy.lum-superproxy.io", username, password, userAgent, landingPageLink,port);
						if (!client.have_good_super_proxy())
			                client.switch_session_id();
			            if (client.n_req_for_exit_node == switch_ip_every_n_req)
			                client.switch_session_id();
			            CloseableHttpResponse response = null;
			            try {
			                response = client.request(url);
			            } catch (IOException e) {
			            	log.info(ResponseEnum.PROXY_ERROR.getCode(), ResponseEnum.PROXY_ERROR.getDesc(),"第一次");
			            } finally {
			                try {
			                    if (response != null)
			                        response.close();
			                } catch (Exception e) {}
			            }

					}
			    }

		    }
		    catch (Exception e) {
			// TODO: handle exception
		  }
	    }
	}*/

}
