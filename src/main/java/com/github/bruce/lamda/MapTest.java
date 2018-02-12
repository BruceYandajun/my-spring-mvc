package com.github.bruce.lamda;

import java.util.Arrays;
import java.util.List;
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
        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
        total = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("total:" + total);


        // collect
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);


        // distinct去重
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s, Without duplicates : %s %n", numbers, distinct);

        // 倒序排列
        numbers.stream().sorted((a,b) -> a < b ? 1 : -1).collect(Collectors.toList()).forEach(System.out::println);
    }
}
