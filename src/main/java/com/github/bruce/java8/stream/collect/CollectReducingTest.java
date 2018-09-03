package com.github.bruce.java8.stream.collect;

import com.github.bruce.java8.methodReference.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.reducing;

public class CollectReducingTest {
    private static List<Apple> apples = Arrays.asList(
            new Apple(1, "green", "Bruce"),
            new Apple(6, "red", "John"),
            new Apple(3, "yellow", "Jack"),
            new Apple(3, "white", "Jack"),
            new Apple(7, "white", "Jack")
    );

    public static void main(String[] args) {
        // 算出所有苹果的重量
        long sumWeight = apples.stream().collect(reducing(0, Apple::getWeight, (i, j) -> i + j));
        // 或者 sumWeight = apples.stream().collect(reducing(0, Apple::getWeight, Integer::sum));
        // 或者 sumWeight = apples.stream().map(Apple::getWeight).reduce(Integer::sum).get();
        // 或者(性能最好，也最易读) sumWeight = apples.stream().mapToInt(Apple::getWeight).sum();
        System.out.println(sumWeight);
        // 算出最轻的苹果
        Optional<Apple> minWeight = apples.stream().collect(reducing((a, b) -> a.getWeight() < b.getWeight() ? a : b));
        System.out.println(minWeight.get());
    }
}
