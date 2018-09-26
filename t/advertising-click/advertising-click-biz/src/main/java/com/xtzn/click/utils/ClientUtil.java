package com.xtzn.click.utils;

import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年5月25日]
 */
public class ClientUtil {

    public static final Logger log = LoggerFactory.getLogger(ClientUtil.class);
    public static final int max_failures = 3;
    public static final int req_timeout = 60 * 1000;
    public String username;
    public String password;
    public Integer port;
    public String session_id;
    public HttpHost super_proxy;
    public CloseableHttpClient client;
    public int fail_count;
    public int n_req_for_exit_node;
    public Random rng;
    public String host;
    public String userAgent;
    public String landingPageLink;
    private String country;

    //private static HttpContext localContext = new BasicHttpContext();
    //private static HttpClientContext context = HttpClientContext
    //.adapt(localContext);


    public ClientUtil(String country, String host, String username, String password, String userAgent, String landingPageLink, Integer port) {
        this.username = username;
        this.password = password;
        this.userAgent = userAgent;
        this.landingPageLink = landingPageLink;
        this.country = country;
        this.port = port;
        this.host = host;
        rng = new Random();
        switch_session_id();
    }


    public void switch_session_id() {
        //session_id = Integer.toString(rng.nextInt(100000000));
        n_req_for_exit_node = 0;
        super_proxy = new HttpHost(host, port);
        update_client();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @param
     * @author zyw
     * @version [版本号, 2018年6月6日]
     */
    public void update_client() {
        /*try {
			close();
		} catch (IOException e) {

			e.printStackTrace();
		}*/
        String login = username;
        CredentialsProvider cred_provider = new BasicCredentialsProvider();
        cred_provider.setCredentials(new AuthScope(super_proxy),
                new UsernamePasswordCredentials(login, password));
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(20000)
                .setSocketTimeout(100000)
                .setConnectionRequestTimeout(10000)
                //.setCookieSpec(CookieSpecs.STANDARD)
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                //.setCookieSpec(CookieSpecs.DEFAULT)
                .setCircularRedirectsAllowed(true)
                .setRedirectsEnabled(true)
                .build();
        PoolingHttpClientConnectionManager conn_mgr =
                new PoolingHttpClientConnectionManager();
        conn_mgr.setDefaultMaxPerRoute(Integer.MAX_VALUE);
        conn_mgr.setMaxTotal(Integer.MAX_VALUE);
        conn_mgr.closeIdleConnections(20000, TimeUnit.MILLISECONDS);
        HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(
                    IOException exception,
                    int executionCount,
                    HttpContext context) {
                if (executionCount >= 3) {
                    // Do not retry if over max retry count
                    return false;
                }
                if (exception instanceof InterruptedIOException) {
                    // Timeout
                    return false;
                }
                if (exception instanceof UnknownHostException) {
                    // Unknown host
                    return false;
                }
                if (exception instanceof SocketTimeoutException) {
                    // Connection refused
                    return false;
                }
                if (exception instanceof SSLException) {
                    // SSL handshake exception
                    return false;
                }
                if (exception instanceof NoHttpResponseException || exception instanceof ConnectTimeoutException) {
                    executionCount++;
                    HttpClientContext clientContext = HttpClientContext.adapt(context);
                    HttpRequest request = clientContext.getRequest();
                    boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
                    if (idempotent) {
                        return true;
                    }
                }

                return false;
            }
        };
        /*SSLContext sslContext=null;
		try {
			sslContext = SSLContext.getInstance("TLSv1.2");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} */
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {


                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {


                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {

                    return null;
                }

            };
            ctx.init(null, new TrustManager[]{tm}, null);
        } catch (Exception e) {

            log.info("SSL", e);
        }
        client = HttpClients.custom()
                .setConnectionManager(conn_mgr)
                .setSSLHostnameVerifier(new HostnameVerifier() {

                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        //强行返回true 即验证成功
                        return true;
                    }
                })
                .setSslcontext(ctx)
                .setProxy(super_proxy)
                .setDefaultCredentialsProvider(cred_provider)
                .setDefaultRequestConfig(config)
                .setUserAgent(userAgent)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(3, true))
                .setRetryHandler(retryHandler)
                .build();
        //System.out.println(client);
    }

    public CloseableHttpResponse request(String url) throws IOException {
        try {
            //System.out.println(url);
            HttpGet request = new HttpGet(url);
            //HttpPost request = new HttpPost(url);
            //request.addHeader("User-Agent", userAgent);
            request.addHeader("Connection", "keep-alive");
            request.addHeader("Accept-Encoding", "gzip,deflate");
            // request.addHeader("referer", landingPageLink);
            request.addHeader("Content_Type", "text/html");
            request.addHeader("accept", "text/html");
            //System.out.println(request);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = client.execute(request, context);
            handle_response(response);
            return response;
        } catch (IOException e) {
            handle_response(null);
            throw e;
        }
    }

    public void handle_response(HttpResponse response) {
        if (response != null && !status_code_requires_exit_node_switch(
                response.getStatusLine().getStatusCode())) {
            // success or other client/website error like 404...
            n_req_for_exit_node++;
            fail_count = 0;
            return;
        }
        // switch_session_id();
        fail_count++;
    }

    public boolean status_code_requires_exit_node_switch(int code) {
        return code == 403 || code == 429 || code == 502 || code == 503;
    }

    public boolean have_good_super_proxy() {
        return super_proxy != null && fail_count < max_failures;
    }

    public void close() throws IOException {
        if (client != null)
            try {
                client.close();
            } catch (IOException e) {
            }
        client = null;
        //client.close();
    }
}



