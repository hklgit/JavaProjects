package com.hklbigdata.redis;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * Created by Kerven-HAN on 2019/10/25 14:43.
 * Talk is cheap , show me the code
 *
 *
 * ref :  http://doc.redisfans.com/string/set.html
 */
public class RedisPool {

    private static final String LOCK_SUCCESS = "OK";


//    NX ：只在键不存在时，才对键进行设置操作。 SET key value NX 效果等同于 SETNX key value
    private static final String SET_IF_NOT_EXIST = "NX";

//    PX millisecond ：设置键的过期时间为 millisecond 毫秒。 SET key value PX millisecond 效果等同于 PSETEX key millisecond value
    private static final String SET_WITH_EXPIRE_TIME = "PX";


    private static final Long RELEASE_SUCCESS = 1L;


    /**
     * 尝试获取分布式锁
     *
     * @param jedis      Redis客户端
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

//        这个api在我使用redis的3.0版本竟然报错。
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }



    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */


//    KEYS[1] 用来表示在redis 中用作键值的参数占位，主要用來传递在redis 中用作keyz值的参数。
//
//    ARGV[1] 用来表示在redis 中用作参数的占位，主要用来传递在redis中用做 value值的参数。
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

}



