package com.razorpay.demospringproject.providers.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author sarabjeet.singh on 11/09/24
 */
@Service
public class RedisStore {

    private final StringRedisTemplate redisTemplate;

    public RedisStore(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setValue(String key, String value, long ttl, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, ttl, unit);
    }

    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }


}