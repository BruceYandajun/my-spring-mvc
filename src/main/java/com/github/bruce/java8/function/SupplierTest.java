package com.github.bruce.java8.function;

import org.apache.commons.lang.math.RandomUtils;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierTest {

    private static ThreadLocal<Integer> index = ThreadLocal.withInitial(() -> 0);

    public static int getLazyValue(Supplier<Integer> supplier) {
        return supplier.get();
    }

    public static void fibbonacci() {
        int[] fibs = {0, 1};
        Stream<Integer> fibonacci = Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        });
        fibonacci.forEach(System.out::print);
    }

    public static void main(String[] args) {
        System.out.println(index.get());

        Supplier<Integer> supplier = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  RandomUtils.nextInt();
        };
        System.out.println(getLazyValue(supplier));
        System.out.println("got");

        fibbonacci();
    }
}
