package com.github.bruce.java8.methodReference;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceTest {

    private void forEach() {
        List<Monster> features = Arrays.asList(new Monster("a"), new Monster("b"), new Monster("c"));
        // 流对象作为方法的参数
        features.forEach(this::out);
        // 流对象作为方法执行者
        features.forEach(Monster::test);
        // 流对象作为方法的参数，必须是static
        features.forEach(Monster::go);
    }

    private void out(Monster monster) {
        System.out.println(monster);
    }

    public static void main(String[] args) {
        new MethodReferenceTest().forEach();
    }
}

class Monster {
    private String name;
    public Monster(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void test() {
        System.out.println("test");
    }

    public static void go(Monster monster) {
        System.out.println(monster);
    }

}
