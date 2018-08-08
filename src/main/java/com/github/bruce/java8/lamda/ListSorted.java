package com.github.bruce.java8.lamda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListSorted {
    private static void line() {
        System.out.println("-----------------------------------------------------");
    }
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "Bruce"),
                new User(5, "John"),
                new User(3, "Lily"),
                new User(1, "Bruce"));
        line();
        // 排序
        users.stream().sorted(Comparator.comparingInt(User::getAge)).forEach(System.out::println);
        line();
        // 转成map，name做key，并去重（name一样，选择age小的）
        Map<String, User> userMap = users.stream().collect(Collectors.toMap(User::getName, Function.identity(),
                (user1, user2) -> user1.getAge() < user2.getAge() ? user1 : user2));
        System.out.println(userMap);
        line();
        // 转成map，name做key，并且按name分组
        Map<String, List<User>> userListMap = users.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println(userListMap);
        line();
        // 取年龄最小的那个user
        System.out.println(users.stream().collect(Collectors.minBy(Comparator.comparingInt(User::getAge))).get());

    }

}

@Setter
@Getter
@AllArgsConstructor
class User {
    private int age;
    private String name;

    @Override
    public String toString() {
        return name + ":" + age;
    }

}