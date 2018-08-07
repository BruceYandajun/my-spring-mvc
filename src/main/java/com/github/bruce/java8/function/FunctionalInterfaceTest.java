package com.github.bruce.java8.function;

import java.util.HashMap;
import java.util.Map;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        // Add $10000 for every employee except Freddy
        salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);

        salaries.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
