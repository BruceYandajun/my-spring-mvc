package com.github.bruce.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.github.bruce.utils.BaseUtil.line;
import static java.util.stream.Collectors.joining;

public class IntStreamTest {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 10).mapToObj(Integer::valueOf).collect(Collectors.toList());
        line(list);
        String s = IntStream.rangeClosed(0, 10).boxed().map(i -> i.toString()).collect(joining(", "));
        line(s);
    }
}
