package com.github.bruce.java8.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Boolean a = false;
        System.out.println(Optional.ofNullable(a).orElse(true));

        Map<String, String> map = new HashMap<>();
        map.put("123", "123");
        System.out.println(exist(map, "123"));
    }

    static boolean exist(Map<String, String> map, String key) {
        return Optional.ofNullable(map.get(key)).map(a -> true).orElse(false);
    }
}
