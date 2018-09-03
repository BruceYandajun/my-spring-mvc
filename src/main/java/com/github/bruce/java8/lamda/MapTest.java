package com.github.bruce.java8.lamda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * <p>
 * </p>
 * DATE 2/12/18.
 *
 * @author yandajun.
 */
public class MapTest {
    public static void main(String[] args) {
        // 不使用lambda表达式为每个订单加上12%的税
        double total = 0.0;
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
            total += price;
        }
        System.out.println("total:" + total);
        // 使用lambda表达式,reduce
        costBeforeTax.stream().map(cost -> cost + .12 * cost).forEach(System.out::println);
        total = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("total:" + total);

        // collect
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

        // distinct去重
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s, Without duplicates : %s %n", numbers, distinct);

        // 倒序排列
        numbers.stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList()).forEach(System.out::println);

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> a1 = new HashMap<>();
        a1.put("lesson", "a");
        a1.put("version", 1);
        Map<String, Object> a2 = new HashMap<>();
        a2.put("lesson", "a");
        a2.put("version", 2);
        Map<String, Object> b1 = new HashMap<>();
        b1.put("lesson", "b");
        b1.put("version", 1);
        Map<String, Object> b2 = new HashMap<>();
        b2.put("lesson", "b");
        b2.put("version", 2);

        list.add(a1);
        list.add(a2);
        list.add(b1);
        list.add(b2);

        list.stream().forEach(System.out::println);
        // 按lesson分组，并且version最大的那个
        Object l = list.stream().collect(Collectors.groupingBy(o -> o.get("lesson"), Collectors.maxBy(Comparator.comparingInt(o -> Integer.valueOf(o.get("version").toString())))));
        System.out.println(l);

    }
}
