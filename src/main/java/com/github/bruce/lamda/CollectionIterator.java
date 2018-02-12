package com.github.bruce.lamda;

import java.util.Arrays;
import java.util.List;

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
        features.forEach(m -> System.out.println(m.length()));
        System.out.println();
        features.forEach(System.out::println);

        System.out.println();

        List<A> list = Arrays.asList(new A(1), new A(2));
        list.forEach(n -> System.out.println(n.getI()));
    }

    static class A {
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
}
