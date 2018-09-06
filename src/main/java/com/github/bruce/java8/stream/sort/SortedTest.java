package com.github.bruce.java8.stream.sort;

import com.github.bruce.java8.methodReference.Apple;

import java.util.Arrays;
import java.util.List;

import static com.github.bruce.utils.BaseUtil.line;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class SortedTest {
    private static List<Apple> apples = Arrays.asList(
            new Apple(1, "green", "Bruce"),
            new Apple(2, "green", "Bruce"),
            new Apple(6, "red", "John"),
            new Apple(3, "yellow", "Jack"),
            new Apple(3, "white", "Jack"),
            new Apple(7, "white", "Jack")
    );

    public static void main(String[] args) {
        // 按重量排序
        List<Apple> sortedList = apples.stream().sorted(comparingInt(Apple::getWeight)).collect(toList());
        line(sortedList);
        // 按颜色指定顺序
        List<Apple> sortedList1 = apples.stream().sorted(comparingInt(SortedTest::sortByColor)).collect(toList());
        line(sortedList1);

    }

    public static int sortByColor(Apple apple) {
        return sortByColor(apple.getColor());
    }

    public static int sortByColor(String color) {
        // 颜色顺序：赤橙黄绿蓝靛紫
        List<String> sortedColors = Arrays.asList("red", "orange", "yellow", "green", "blue", "indigo", "violet");
        for (int i = 0; i < sortedColors.size(); i ++) {
            if (sortedColors.get(i).equalsIgnoreCase(color)) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
