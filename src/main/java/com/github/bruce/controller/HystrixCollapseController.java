package com.github.bruce.controller;

import com.github.bruce.model.User;
import com.github.bruce.service.HystrixCollapseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/hystrix/collapse")
public class HystrixCollapseController {

    @Autowired
    private HystrixCollapseService hystrixCollapseService;

    @RequestMapping("/getUser")
    public String getUser(@RequestParam Integer id) throws ExecutionException, InterruptedException {
        Future<User> future = hystrixCollapseService.getUserByIdAsync(id);
        User user = future.get();
        return user.toString();
    }

}
