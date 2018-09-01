package com.github.bruce.java8.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(1, 2, 3);
        s = s.stream().filter(i -> i > 1).collect(Collectors.toList());
        System.out.println(s);
    }
}
