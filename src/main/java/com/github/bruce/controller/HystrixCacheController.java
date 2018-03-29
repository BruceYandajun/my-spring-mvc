package com.github.bruce.controller;

import com.github.bruce.model.User;
import com.github.bruce.service.HystrixCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix/cache")
public class HystrixCacheController {

    @Autowired
    private HystrixCacheService hystrixCacheService;

    @RequestMapping("/getUser")
    public String getUser(@RequestParam String name) {
        User user = hystrixCacheService.getUserByName(name);
        return user.toString();
    }

}
