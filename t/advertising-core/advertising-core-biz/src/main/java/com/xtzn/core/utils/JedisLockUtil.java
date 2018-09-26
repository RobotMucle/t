package com.xtzn.core.utils;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年5月17日]
 */

import java.util.Date;

public class JedisLockUtil {

    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;
    private String value;
    private String lockKey;
    private String field;
    /**
     * 锁超时时间，防止线程在入锁以后，无限的执行等待
     */
    private int expireMsecs = 60 * 1000;

    /**
     * 锁等待时间，防止线程饥饿
     */
    private int timeoutMsecs = 30 * 1000;

    private volatile boolean locked = false;


    public JedisLockUtil(String lockKey, String field, String value) {
        super();
        this.value = value;
        this.field = field;
        this.lockKey = lockKey;
    }

    public synchronized boolean lock() throws InterruptedException {
		/* int timeout = timeoutMsecs;
	        while(timeout >= 0){
	        	if(RedisUtil.setNX(lockKey, value)){
		        	return true;
		        }
		        else{
		        	String dt = RedisUtil.getString(lockKey);
		        	Long date = Long.valueOf(dt);
		        	Long now = new Date().getTime();
		        	if(now-date<timeoutMsecs){
		        		timeout = timeout - ((int)(Math.random()*50)+50);
		        		//Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
		        	}
		        	else{
		        		RedisUtil.delKey(lockKey);
		        	}
		        }

	        }
	        return false;*/
        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            if (RedisUtil.hexist(lockKey, field, value) == 1) {
                return true;
            } else {
                String dt = RedisUtil.hget(lockKey, field);
                Long date = 0l;
                if (null != dt) {
                    date = Long.valueOf(dt);
                }
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
