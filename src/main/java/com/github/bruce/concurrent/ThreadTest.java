package com.github.bruce.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

    public static void main(String[] args) {
        thread();
        pool();
    }

    private static void thread() {
        System.out.println("start");
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        try {
            t.join();// Wait thread completed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

    private static void pool() {
        System.out.println("start");
        Runnable r = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run");
        };
        Future future = Executors.newFixedThreadPool(10).submit(r);
        try {
            future.get();// Block until thread completed
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

}
