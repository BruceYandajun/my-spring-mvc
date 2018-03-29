package com.github.bruce.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;


public class TestObservableCommand extends HystrixObservableCommand{

    protected TestObservableCommand(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Observable construct() {
        return null;
    }
}
