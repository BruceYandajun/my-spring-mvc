package com.github.bruce.controller;

import com.github.bruce.model.User;
import com.github.bruce.service.HystrixCacheService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hystrix/cache")
public class HystrixCacheController {

    @Resource
    private HystrixCacheService hystrixCacheService;

    @RequestMapping("/getUser")
    public String getUser(@RequestParam String name) {
        User user = hystrixCacheService.getUserByName(name);
        return user.toString();
    }

}
