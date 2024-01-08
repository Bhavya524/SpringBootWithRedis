package org.redis.cache.redis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.redis.cache.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1" + "/redis")
public class RadisController {
    @Autowired
    private RedisService redisService;


    @PostMapping("/createCache")
    public void createCache() throws JsonProcessingException {
        redisService.initCache();
    }

    @GetMapping("/getCache")
    public String getCache() {
        String res = null;
        try {
            res = String.valueOf(redisService.getCache());
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return res;
    }

    @DeleteMapping("/delCacheByKey/{key}")
    public Boolean delCacheByKey(@PathVariable String key) {
        Boolean req = null;
        try {
            req = redisService.delCacheByKey(key);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return req;
    }

    @GetMapping("/getCacheById/{key}")
    public String getCache(@PathVariable Long tenantId, String key) {
        String res = null;
        try {
            res = String.valueOf(redisService.getCacheByName(tenantId, key));
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return res;
    }

}



