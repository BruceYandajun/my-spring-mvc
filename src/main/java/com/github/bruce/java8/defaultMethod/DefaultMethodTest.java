package com.github.bruce.java8.defaultMethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.github.bruce.utils.BaseUtil.line;

public class DefaultMethodTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 4, 3);
        numbers.sort(Comparator.naturalOrder());
        line(numbers);
    }
}
