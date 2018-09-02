package com.github.bruce.java8.methodReference;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructMethodReferenceTest {

    public static void main(String[] args) {
        // 无参构造方法
        Supplier<Apple> supplier = Apple::new; //等价于supplier = () -> new Apple();
        System.out.println(map(5, supplier));

        // 一个参数的构造方法
        Function<Integer, Apple> function1 = Apple::new; // 等价于function1 = weight -> new Apple(weight);
        List<Integer> weights = Arrays.asList(7, 3, 4, 10, 5);
        System.out.println(map(weights, function1));

        Function<String, Apple> function2 = Apple::new;// 等价于function2 = color -> new Apple(color);
        List<String> colors = Arrays.asList("green", "red", "yellow");
        System.out.println(map_color(colors, function2));

        // 两个参数的构造方法
        BiFunction<Integer, String, Apple> biFunction = Apple::new; // 等价于biFunction = (weight, color) -> new Apple(weight, color);
        List<Map<String, Object>> apples = new ArrayList<>();
        Map<String, Object> app1 = new HashMap<>();
        app1.put("weight", 1);
        app1.put("color", "green");
        apples.add(app1);
        Map<String, Object> app2 = new HashMap<>();
        app2.put("weight", 2);
        app2.put("color", "red");
        apples.add(app2);
        System.out.println(map(apples, biFunction));

        // 三个参数的构造方法(由于java没有三个入参的Function，需要自己建)
        TriFunction<Integer, String, String, Apple> triFunction = Apple::new;
        Apple apple = triFunction.apply(1, "green", "Bruce");
        System.out.println(apple);
    }

    private static List<Apple> map(Integer count, Supplier<Apple> supplier) {
        List<Apple> result = Lists.newArrayList();
        for (int i = 0; i < count; i ++) {
            Apple apple = supplier.get();
            result.add(apple);
        }
        return result;
    }

    private static List<Apple> map(List<Integer> weights, Function<Integer, Apple> function) {
        List<Apple> result = Lists.newArrayList();
        weights.forEach(weight -> {
            Apple apple = function.apply(weight);
            result.add(apple);
        });
        return result;
    }

    private static List<Apple> map_color(List<String> colors, Function<String, Apple> function) {
        List<Apple> result = Lists.newArrayList();
        colors.forEach(color -> {
            Apple apple = function.apply(color);
            result.add(apple);
        });
        return result;
    }

    private static List<Apple> map(List<Map<String, Object>> maps, BiFunction<Integer, String, Apple> biFunction) {
        List<Apple> result = Lists.newArrayList();
        maps.forEach(map -> {
            Apple apple = biFunction.apply((Integer)map.get("weight"), (String)map.get("color"));
            result.add(apple);
        });
        return result;
    }
}

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
