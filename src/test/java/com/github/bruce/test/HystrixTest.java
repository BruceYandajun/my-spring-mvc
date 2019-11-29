package com.github.bruce.test;

import com.github.bruce.test.service.HystrixTestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HystrixTest extends DefaultTest {

    @Autowired
    private HystrixTestService hystrixTestService;

    @Test
    public void test() {
        CountDownLatch runningCounter = new CountDownLatch(1);
        List<Thread> workers = Stream.generate(() -> new Thread(new Worker(runningCounter, hystrixTestService)))
                .limit(1).collect(Collectors.toList());
        workers.forEach(Thread::start);
        runningCounter.countDown();
    }

}

class Worker implements Runnable {

    private CountDownLatch runningCounter;

    private HystrixTestService hystrixService;

    Worker(CountDownLatch counter, HystrixTestService hystrixService) {
        runningCounter = counter;
        this.hystrixService = hystrixService;
    }

    @Override
    public void run() {
        try {
            runningCounter.await();
            hystrixService.getUser(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}