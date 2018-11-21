package com.github.bruce.test.base.collections.list;

import com.github.bruce.java8.methodReference.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.github.bruce.utils.BaseUtil.line;

/**
 * note that: Arrays.asList method produces a fixed size list which can't be add element
 */
public class ListMerge {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>(Arrays.asList(
                new Apple(1, "green", "Bruce"),
                new Apple(6, "red", "John"),
                new Apple(3, "yellow", "Jack"),
                new Apple(3, "white", "Jack"),
                new Apple(7, "white", "Jack")
        ));
        List<Apple> apples1 = Arrays.asList(
                new Apple(7, "green", "1"),
                new Apple(1, "red", "1")
        );
        List<Apple> apples2 = Arrays.asList(
                new Apple(5, "green", "2"),
                new Apple(3, "red", "2")
        );
        line(apples);
        insert(apples, apples1);
        insert(apples, apples2);
        line(apples);
    }

    private static void insert(List<Apple> apples, List<Apple> insertList) {
        for (Apple insert : insertList) {
            int index = findIndex(apples, insert);
            apples.add(index, insert);
        }
    }

    private static int findIndex(List<Apple> apples, Apple apple) {
        for (int i = 0; i < apples.size(); i ++) {
            if (apples.get(i).getWeight().intValue() == apple.getWeight().intValue()) {
                return i + 1;
            }
        }
        return 0;
    }
}
