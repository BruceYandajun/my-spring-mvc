package com.github.bruce.java8.stream.collect;

import com.github.bruce.java8.methodReference.Apple;
import com.github.bruce.java8.methodReference.AppleWeightType;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static com.github.bruce.utils.BaseUtil.*;
import static java.util.stream.Collectors.maxBy;


public class CollectGroupingByTest {
    private static List<Apple> apples = Arrays.asList(
            new Apple(1, "green", "Bruce"),
            new Apple(2, "green", "Bruce"),
            new Apple(6, "red", "John"),
            new Apple(3, "yellow", "Jack"),
            new Apple(3, "white", "Jack"),
            new Apple(7, "white", "Jack")
    );

    public static void main(String[] args) {
        // 按轻重类型分
        Map<AppleWeightType, List<Apple> > appleMap = apples.stream().collect(groupingBy(AppleWeightType::getType));
        line(appleMap);
        // 二级分类：先按轻重分，内层用颜色分
        Map<AppleWeightType, Map<String, List<Apple>>> appleLayerMap = apples.stream().collect(groupingBy(AppleWeightType::getType, groupingBy(Apple::getColor)));
        line(appleLayerMap);
        // 按owner分组，计算出每个人有几个苹果
        Map<String, Long> ownerCountMap = apples.stream().collect(groupingBy(Apple::getOwner, counting()));
        line(ownerCountMap);
        // 获取每个owner的苹果重量
        Map<String, Integer> ownerWeightMap = apples.stream().collect(groupingBy(Apple::getOwner, summingInt(Apple::getWeight)));
        line(ownerWeightMap);
        // 获取每个owner的最轻的苹果
        Map<String, Optional<Apple>> ownerMaxWeightMap = apples.stream().collect(groupingBy(Apple::getOwner, maxBy(comparing(Apple::getWeight).reversed())));
        line(ownerMaxWeightMap);
        // 或者直接get出来，不是Optional
        Map<String, Apple> ownerMaxWeightMap1 = apples.stream().collect(groupingBy(Apple::getOwner, collectingAndThen(maxBy(comparing(Apple::getWeight).reversed()), Optional::get)));
        line(ownerMaxWeightMap1);
        // 获取每个owner有哪几种颜色(toSet会自动去重)
        Map<String, Set<String>> ownerColorMap = apples.stream().collect(groupingBy(Apple::getOwner, mapping(Apple::getColor, toSet())));
        line(ownerColorMap);

    }
}
