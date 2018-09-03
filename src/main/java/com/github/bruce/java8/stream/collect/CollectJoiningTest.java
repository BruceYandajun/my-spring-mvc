package com.github.bruce.java8.stream.collect;

import com.github.bruce.java8.methodReference.Apple;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class CollectJoiningTest {
    private static List<Apple> apples = Arrays.asList(
            new Apple(1, "green", "Bruce"),
            new Apple(6, "red", "John"),
            new Apple(3, "yellow", "Jack"),
            new Apple(3, "white", "Jack"),
            new Apple(7, "white", "Jack")
    );

    public static void main(String[] args) {
        String s = apples.stream().map(Apple::getOwner).collect(joining(","));
        System.out.println(s);
    }
}
