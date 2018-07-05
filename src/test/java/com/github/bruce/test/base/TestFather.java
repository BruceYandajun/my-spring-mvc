package com.github.bruce.test.base;

public class TestFather {
    public static void main(String[] args) {
        IFather sub = new Father();
        System.out.println(sub.say());
    }
}
