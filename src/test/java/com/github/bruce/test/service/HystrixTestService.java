package com.github.bruce.test.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
@DefaultProperties
public class HystrixTestService {
    private int total = 0;
    private int fallback = 0;

    @HystrixCommand(defaultFallback = "defaultUser",
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
    })
    public String getUser(Integer userId) {
        total ++;
        System.out.println("total : " + total);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        throw new NullPointerException();
        return "user";
    }

    private String getUserFallBack(Integer userId) {
        fallback ++;
        System.out.println("fallback : " + fallback);
        return "getUserFallBack";
    }

    @HystrixCommand(fallbackMethod = "defaultUser")
    public Future<String> getUserByIdAsync() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                int a = 1 / 0 ;
                return "user";
            }
        };
    }

    private String defaultUser() {
        fallback ++;
        System.out.println("fallback : " + fallback);
        return "defaultUser";
    }

//    @TestAspect
    public String test() {
        return "test";
    }

}
