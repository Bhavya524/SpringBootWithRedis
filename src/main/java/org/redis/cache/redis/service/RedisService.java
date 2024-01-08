package org.redis.cache.redis.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Slf4j
@Component
public class RedisService {
    public static final String MODULE = "[RedisRepository()]";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void initCache() {
        redisTemplate.opsForValue().set("name", "bhavya");
        log.info("Tenant&role : operations ");
    }

    public HashMap<String, String> getCache() {
        HashMap<String, String> cache = new HashMap<>();
        String key = null, value;
        String response = null;

        Set<String> res = redisTemplate.keys("*");
        value = redisTemplate.opsForValue().get(key);
        cache.put(key, value);
        log.info(String.valueOf(cache));
        response = String.valueOf(cache);

        return cache;
    }

    public String getCacheByName(Long tenantId, String rolename) {
        HashMap<String, String> cache = new HashMap<>();
        String value = null;
        String key = null;

        value = redisTemplate.opsForValue().get(key);
        cache.put(key, value);
        log.info(String.valueOf(cache));
        return value;
    }


    public Boolean delCacheByKey(String request) {
        Boolean response = false;
        String key = null;
        Long tenantId = null;
        try {
            response = redisTemplate.delete(key);

            log.info("key : " + key + " is deleted");
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return response;
    }
}
