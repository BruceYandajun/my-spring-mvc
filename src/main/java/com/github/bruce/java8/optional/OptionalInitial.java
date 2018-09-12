package com.github.bruce.java8.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.github.bruce.utils.BaseUtil.line;

public class OptionalInitial {

    public static void main(String[] args) {
        Optional<String> o = Optional.empty();
        line(o);

        o = Optional.of("Hello Jack");
        o.filter(s -> s.endsWith("Jack")).ifPresent(System.out::println);
        line();

        o = Optional.ofNullable(null);
        line(o.filter(s -> s.endsWith("Bruce")).orElse("Unknown"));

        Map<String, String> map = new HashMap<>();
        map.put("123", "123");
        line(exist(map, "123"));
    }

    static boolean exist(Map<String, String> map, String key) {
        return Optional.ofNullable(map.get(key)).map(a -> true).orElse(false);
    }
}
