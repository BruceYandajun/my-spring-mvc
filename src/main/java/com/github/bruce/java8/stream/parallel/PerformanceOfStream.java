package com.github.bruce.java8.stream.parallel;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 测试几种流的性能表现（参见Java 8实战7.1.2）
 */
public class PerformanceOfStream {

    public static void main(String[] args) {
        long n = 10_000_000L;
        System.out.println("Sequential sum done in:" + measureSumPerformance(PerformanceOfStream::sequentialSum, n) + " msecs");
        System.out.println("Iterative sum done in:" + measureSumPerformance(PerformanceOfStream::iterativeSum, n) + " msecs");
        System.out.println("Parallel sum done in:" + measureSumPerformance(PerformanceOfStream::parallelSum, n) + " msecs");
        System.out.println("Parallel range sum done in:" + measureSumPerformance(PerformanceOfStream::parallelRangeSum, n) + " msecs");
    }

    /**
     * 顺序流
     */
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    /**
     * 普通迭代
     */
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    /**
     * 并行流
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    /**
     * 并行非装箱流
     */
    public static long parallelRangeSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }

    public static long measureSumPerformance(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}
