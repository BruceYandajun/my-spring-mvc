package com.github.bruce;

import com.github.bruce.service.Father;
import com.github.bruce.service.IFather;

public class TestFather {
    public static void main(String[] args) {
        IFather sub = new Father();
        System.out.println(sub.say());
    }
}
