package com.github.bruce.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.github.bruce.utils.BaseUtil.line;

public class IntStreamTest {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 10).mapToObj(Integer::valueOf).collect(Collectors.toList());
        line(list);
        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }
}
