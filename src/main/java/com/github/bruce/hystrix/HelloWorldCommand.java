package com.github.bruce.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class HelloWorldCommand extends HystrixCommand<String> {
    private final String name;

    public HelloWorldCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        // a real example would do work like a network call here
        throw new Exception();
//        return "Hello " + name + "!";
    }

    @Override
    protected String getFallback() {
        return "Execute failed";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String s = new HelloWorldCommand("Bruce").execute();
        System.out.println(s);
        Future<String> f = new HelloWorldCommand("Bruce").queue();
        System.out.println(f.get());
        Observable<String> o = new HelloWorldCommand("Bruce").observe();
//        System.out.println(o.);
    }
}
