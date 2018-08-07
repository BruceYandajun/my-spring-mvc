package com.github.bruce.java8.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Description
 * <p>
 * </p>
 * DATE 2/12/18.
 *
 * @author yandajun.
 */
public class PredicateTest {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        // 方法一：
        languages.forEach((str) -> {
            filter(str, "Starts with J is : %s", (a) -> a.startsWith("J"));
            filter(str, "Ends with a is : %s", (a) -> a.endsWith("a"));
            filter(str, "Length greater than 4 is : %s", (a) -> a.length() > 4);
            filter(str, "Language is : %s", (a) -> true);
        });

        System.out.println("---------------");

        // 方法二：
        languages.stream().filter((str) -> str.startsWith("J")).forEach((str) -> System.out.println("Starts with J is " + str));
        languages.stream().filter((str) -> str.endsWith("a")).forEach((str) -> System.out.println("Ends with a is " + str));
        languages.stream().filter((str) -> str.length() > 4).forEach((str) -> System.out.println("Length greater than 4 is " + str));
        languages.stream().forEach(System.out::println);
    }

    public static void filter(String name, String message, Predicate<String> condition) {
        if (condition.test(name)) {
            System.out.printf(String.format(message, name));
        }
    }
}
