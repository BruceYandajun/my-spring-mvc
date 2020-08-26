package com.github.bruce.java8.function;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperatorTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("bob", "josh", "megan");
        names.replaceAll(String::toUpperCase);
        names.forEach(System.out::println);

        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        int sum = values.stream().reduce(0, (i1, i2) -> i1 + i2);
        System.out.println(sum);

        List<List<Integer>> list = Arrays.asList(Arrays.asList(3, 5), Arrays.asList(4, 7));
        List<Integer> integers = list.stream().reduce((a, b) -> Stream.of(a, b)
                .flatMap(Collection::stream)
                .collect(Collectors.toList())).get();
        System.out.println(integers);
    }
}
