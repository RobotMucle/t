package com.xtzn.web.common;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import com.xtzn.utils.MinuteUtil;

public class Test extends Thread {

    private static final AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        while (true)
            (new Test()).start();
    }

    @Override
    public void run() {
        System.out.println(count.incrementAndGet());
        while (true)
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                break;
            }
    }

}
