package com.github.bruce.service;

import com.github.bruce.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class HystrixCollapseService {

    /** Asynchronous Execution */
    @HystrixCollapser(batchMethod = "getUserByIds")
    public Future<User> getUserByIdAsync(Integer id) {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return new User(1, "default");
            }
        };
    }

    @HystrixCommand
    public List<User> getUserByIds(List<Integer> ids) {
        List<User> users = new ArrayList<>();
        for (Integer id : ids) {
            users.add(new User(id, "name: " + id));
        }
        return users;
    }

}
