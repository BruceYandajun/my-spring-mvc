package com.github.bruce.test.base;

public class TestInteger {
    public static final int a = 9527;

    public static void main(String[] args) {
        Integer b = new Integer(9527);
        System.out.println(b.intValue() == a);
    }
}
