package com.github.bruce.java8.stream.collect;

import com.github.bruce.java8.methodReference.Apple;

import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;

import static com.github.bruce.BaseUtil.*;

public class CollectStatisticsTest {
    private static List<Apple> apples = Arrays.asList(
            new Apple(1, "green", "Bruce"),
            new Apple(6, "red", "John"),
            new Apple(3, "yellow", "Jack"),
            new Apple(3, "white", "Jack"),
            new Apple(7, "white", "Jack")
    );
    public static void main(String[] args) {
        // 算出苹果的总数
        long count = apples.stream().collect(counting()); // 或者 Long count = apples.stream().count();
        line("The count of apples is " + count);
        // 算出苹果的总重量
        long sumWeight = apples.stream().collect(summingInt(Apple::getWeight));
        line("The total weight of apples is " + sumWeight);
        // 算出苹果的平均重量
        Double averageWeight = apples.stream().collect(averagingInt(Apple::getWeight));
        line("The average weight of apples is " + averageWeight);
        // 获取最重的苹果
        Optional<Apple> maxWeight = apples.stream().collect(maxBy(Comparator.comparing(Apple::getWeight)));
        line("The max weight of apples is " + maxWeight.get());
        // 一次性算出所有统计结果
        IntSummaryStatistics statistics = apples.stream().collect(summarizingInt(Apple::getWeight));
        line(statistics);
        // 搜集Jack拥有的苹果
        apples.stream().filter(app -> app.getOwner().equals("Jack")).collect(toList()).forEach(System.out::println);
        line();
    }

}
