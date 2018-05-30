package com.github.bruce.base;

public class TestFather {
    public static void main(String[] args) {
        IFather sub = (IFather) new Father();
        System.out.println(sub.say());
    }
}
