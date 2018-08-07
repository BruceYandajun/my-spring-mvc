package com.github.bruce.java8.methodReference;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceTest {

    private void forEach() {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(this::out);
    }

    private void out(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new MethodReferenceTest().forEach();
    }
}
