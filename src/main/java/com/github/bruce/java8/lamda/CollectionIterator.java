package com.github.bruce.java8.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description
 * <p>
 * </p>
 * DATE 2/12/18.
 *
 * @author yandajun.
 */
public class CollectionIterator {
    public static void main(String[] args) {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        System.out.println();

        // Lambda expression
        features.forEach(m -> System.out.println(m));
        features.forEach(System.out::println);
        System.out.println();
        features.stream().collect(Collectors.joining(","));

        System.out.println();

        List<A> list = Arrays.asList(new A(1), new A(2), new A(-1));
        list = list.stream().sorted((a, b) -> a.getI() > b.getI() ? 1 : -1).collect(Collectors.toList());
        list.forEach(n -> System.out.println(n.getI()));
        Map<Integer, A> mapa = list.stream().collect(Collectors.toMap(A::getI, Function.identity()));
        System.out.println(mapa);
    }
}

 class A {
    private Integer i;

    public A (int i){
        this.i = i;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

}
