package com.github.bruce.controller;

import com.github.bruce.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping("/getUser")
    public String getUser() {
        try {
            return hystrixService.getUser(1);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "test";
    }

    @GetMapping("/getUserAsync")
    public String getUserAsync() throws ExecutionException, InterruptedException {
        Future<String> future = hystrixService.getUserByIdAsync();
        return future.get();
    }

}
