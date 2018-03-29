package com.github.bruce.service;

import com.github.bruce.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.apache.commons.lang.math.RandomUtils;

public class HystrixCacheService {

    @CacheResult(cacheKeyMethod = "getUserByNameCacheKey")
    @HystrixCommand
    public User getUserByName(String name) {
        HystrixRequestContext.initializeContext();
        User user = new User(RandomUtils.nextInt(1000), name);
        return user;
    }

    private String getUserByNameCacheKey(String name) {
        return name;
    }

    @CacheRemove(commandKey = "getUserById")
    @HystrixCommand
    public void update(@CacheKey("id") User user) {

    }
}
