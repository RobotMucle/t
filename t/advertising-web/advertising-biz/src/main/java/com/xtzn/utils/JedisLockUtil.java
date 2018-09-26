package com.xtzn.utils;

import java.util.Date;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年5月3日]
 */
public class JedisLockUtil {

    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;
    private String lockKey;
    private String field;
    private String value;
    private int timeoutMsecs = 30 * 1000;

    public JedisLockUtil(String lockKey, String field, String value) {
        super();
        this.field = field;
        this.lockKey = lockKey;
        this.value = value;
    }

    public synchronized boolean lock() throws InterruptedException {
	        /*int timeout = timeoutMsecs;
	        while (timeout >= 0) {
	        	Long bl = RedisUtil.hexist(lockKey, field,value);
	            if (bl==1) {
	                return true;
	            }
	            timeout -= (int)(Math.random()*50)+50;

			                延迟100 毫秒,  这里使用随机时间可能会好一点,可以防止饥饿进程的出现,即,当同时到达多个进程,
			                只会有一个进程获得锁,其他的都用同样的频率进行尝试,后面有来了一些进行,也以同样的频率申请锁,这将可能导致前面来的锁得不到满足.
			                使用随机的等待时间可以一定程度上保证公平性

	            Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
	            return false;
	        }*/
        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            if (RedisUtil.hexist(lockKey, field, value) == 1) {
                return true;
            } else {
                String dt = RedisUtil.hget(lockKey, field);
                Long date = Long.valueOf(dt);
                Long now = new Date().getTime();
                if (now - date < timeoutMsecs) {
                    timeout = timeout - ((int) (Math.random() * 50) + 50);
                    Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
                } else {
                    RedisUtil.delField(lockKey, field);

                }
            }

        }
        return false;
    }
}
