package com.github.bruce.function;

import java.util.function.Function;

public class UseFoo {

    public static String add(String string, Foo foo) {
        return foo.method(string);
    }

    public static String add(String string, Function<String, String> function) {
        return function.apply(string);
    }

    public static void main(String[] args) {
        // Before Java 8
        Foo foo = parameter -> parameter + " are foo";
        String result = add("You", foo);
        System.out.println(result);
        foo.defaultMethod();
        // Java 8 functional interface

        Function function = string -> string + " are foo";
        String result1 = add("They", function);
        System.out.println(result1);

    }
}
