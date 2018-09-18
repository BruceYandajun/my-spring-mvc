package com.github.bruce.java8.parallel;

import java.util.concurrent.*;

import static com.github.bruce.utils.BaseUtil.line;

public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(() -> {
            Thread.sleep(2000);
            return 1.0;
        });

        Thread.sleep(1000);

        Double result = future.get(1000, TimeUnit.SECONDS);

        line(result);
    }
}
