package com.github.bruce.java8.lamda;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.bruce.utils.BaseUtil.line;

public class PeekTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java", "Scala", "C++", "Haskell", "Lisp");
        List<String> containsA = Lists.newArrayList();
        List<String> languages = stream.filter(s -> s.contains("a")).peek(s -> containsA.add(s)).map(s -> s.toUpperCase()).collect(Collectors.toList());
        line(languages);
        line(containsA);
    }

}
