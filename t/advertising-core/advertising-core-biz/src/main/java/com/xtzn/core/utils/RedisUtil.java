package com.xtzn.core.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import java.util.Properties;

/**
 * redis工具类<br>
 * 提供redis的增删改查方法
 *
 * @author Vic Ding
 * @version [版本号, 2016年1月7日]
 */
public class RedisUtil {

    /**
     * 默认redis属性配置文件
     */
    public final static String REDIS_PROP = "properties/config-jdies.properties";
    /**
     * 日志记录器
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);
    /**
     * 连接池
     */
    private static JedisPool jedisPool = null;

    /**
     * 功能描述: <br>
     * 初始化连接池
     *
     * @author Vic Ding
     * @version [版本号, 2016年1月7日]
     */
    private static void initialPool() {
        try {
            // 加载资源文件
            Properties props = loadProperties();
            // redis配置
            JedisPoolConfig config = configJedisPoolConfig(props);
            // 创建连接池
            jedisPool = buildJedisPool(props, config);
        } catch (Exception e) {
            LOGGER.error("------ 初始化redis连接池出现异常 ------", e);
        }
    }

    /**
     * 功能描述: <br>
     * 加载配置文件
     *
     * @return
     * @author Vic Ding
     * @version [版本号, 2016年1月7日]
     */
    private static Properties loadProperties() {
        Properties defaultProperties = new Properties();
        try {
            defaultProperties.load(RedisUtil.class.getClassLoader().getResourceAsStream(REDIS_PROP));
        } catch (Exception e) {
            LOGGER.error("------ 加载redis配置文件出现异常 ------", e);
        }
        return defaultProperties;
    }

    /**
     * 功能描述: <br>
     * 配置redisPool
     *
     * @param props 资源配置信息
     * @return 连接池配置
     * @author Vic Ding
     * @version [版本号, 2016年1月7日]
     */
    private static JedisPoolConfig configJedisPoolConfig(Properties props) {
        // 连接池配置信息
        JedisPoolConfig config = new JedisPoolConfig();
        String maxActive = props.getProperty("redis.pool.maxActive");
        if (StringUtils.isNumeric(maxActive)) {
            config.setMaxTotal(Integer.valueOf(maxActive));
        }
        String maxIdle = props.getProperty("redis.pool.maxIdle");
        if (StringUtils.isNumeric(maxIdle)) {
            config.setMaxIdle(Integer.valueOf(maxIdle));
        }
        String maxWait = props.getProperty("redis.pool.maxWait");
        if (StringUtils.isNumeric(maxWait)) {
            config.setMaxWaitMillis(Long.valueOf(maxWait));
        }
        String testOnBorrow = props.getProperty("redis.pool.testOnBorrow");
        if (StringUtils.isNotBlank(testOnBorrow)) {
            config.setTestOnBorrow(Boolean.valueOf(testOnBorrow));
        }
        String testOnReturn = props.getProperty("redis.pool.testOnReturn");
        if (StringUtils.isNotBlank(testOnReturn)) {
            config.setTestOnReturn(Boolean.valueOf(testOnBorrow));
        }
        config.setBlockWhenExhausted(true);
        return config;
    }

    /**
     * 功能描述: <br>
     * 创建连接池
     *
     * @param props  资源配置信息
     * @param config redis配置
     * @return 连接池
     * @author Vic Ding
     * @version [版本号, 2016年1月7日]
     */
    private static JedisPool buildJedisPool(Properties props, JedisPoolConfig config) {
        // 创建连接池
        String host = props.getProperty("redis.host");
        String portStr = props.getProperty("redis.port");
        String password = props.getProperty("redis.password");
        int port = Protocol.DEFAULT_PORT;
        if (StringUtils.isNumeric(portStr)) {
            port = Integer.parseInt(portStr);
        }
        int timeout = Protocol.DEFAULT_TIMEOUT;
        String timeoutStr = props.getProperty("redis.timeout");
        if (StringUtils.isNumeric(timeoutStr)) {
            timeout = Integer.parseInt(timeoutStr);
        }
        return new JedisPool(config, host, port, timeout, password);
    }

    /**
     * 功能描述: <br>
     * 线程同步初始化连接池
     *
     * @author Vic Ding
     * @version [版本号, 2016年1月7日]
     */
    private static synchronized void poolInit() {
        if (jedisPool == null) {
            initialPool();
        }
    }

    /**
     * 功能描述: <br>
     * 同步获取redis链接
     *
     * @return redis连接
     * @author Vic Ding
     * @version [版本号, 2016年1月7日]
     */
    private synchronized static Jedis getJedis() {
        if (jedisPool == null) {
            poolInit();
        }
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            LOGGER.error("------ 获取redis连接出现异常 ------", e);
        }
        return jedis;
    }

    /**
     * 功能描述: <br>
     * 释放链接
     *
     * @param jedis    redis连接
     * @param isBroken 是否是中断连接
     * @author Vic Ding
     * @version [版本号, 2016年1月6日]
     */
    private static void release(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }


    /**
     * redis set if not exist 功能
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean setNX(String key, String value) {
        Jedis jedis = null;
        Long resultCode = null;
        try {
            jedis = getJedis();
            resultCode = jedis.setnx(key, value);
        } catch (Exception e) {
            LOGGER.error("------ 往redis中保存数据出现异常，key:" + key + ",value:" + value, e);
        } finally {
            release(jedis);
        }
        if (resultCode != null && resultCode.compareTo(1L) == 0) {
            return true;
        }
        return false;
    }

    public static void delKey(String cacheKey) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.del(cacheKey);
        } catch (Exception e) {
            LOGGER.error("------ 从redis中删除出现异常，cacheKey:" + cacheKey + " ------", e);
        } finally {
            release(jedis);
        }
    }

    /**
     * 功能描述: <br>
     * 从redis中获取key中的field数据
     *
     * @param key   键
     * @param field 域
     * @return map数据
     */
    public static String hget(String key, String field) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = getJedis();
            value = jedis.hget(key, field);
        } catch (Exception e) {
            LOGGER.error("------ 往redis中保存数据出现异常，key:" + key + ",value:" + value, e);
        } finally {
            release(jedis);
        }
        return value;
    }

    public static void hsetString(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hset(key, field, value);
        } catch (Exception e) {
            LOGGER.error("------ 往redis中保存数据出现异常，key:" + key + ",value:" + value, e);
        } finally {
            release(jedis);
        }
    }

    public static Long hexist(String key, String field, String value) {
        Jedis jedis = null;
        Long b = 0l;
        try {
            jedis = getJedis();
            b = jedis.hsetnx(key, field, value);
        } catch (Exception e) {
            LOGGER.error("------ 往redis中保存数据出现异常，key:" + key + ",value:" + value, e);
        } finally {
            release(jedis);
        }
        return b;
    }

    public static void delField(String key, String field) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hdel(key, field);
        } catch (Exception e) {
            LOGGER.error("------ 往redis中保存数据出现异常，key:" + key, e);
        } finally {
            release(jedis);
        }
    }

    public static void main(String[] args) {
        System.out.println(getJedis());
    }
}
