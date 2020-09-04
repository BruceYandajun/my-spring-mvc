package com.github.bruce.algorithm;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessIp {

    private static Map<String, AtomicInteger> map = Maps.newConcurrentMap();
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

    }

    private static int access(String ip) {
        if (map.containsKey(ip)) {
            map.get(ip).addAndGet(1);
        } else {
            lock.lock();
            if (map.containsKey(ip)) {
                map.get(ip).addAndGet(1);
            } else {
                map.put(ip, new AtomicInteger(1));
                lock.unlock();
            }
        }
        return map.get(ip).get();
    }
}
