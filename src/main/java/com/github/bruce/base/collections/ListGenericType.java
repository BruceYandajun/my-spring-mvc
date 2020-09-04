package com.github.bruce.base.collections;

import com.google.common.collect.Lists;

import java.util.List;

public class ListGenericType {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 一个带Integer泛型的list，如何add进一个String对象
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        Class<?> aClass = Class.forName("java.util.ArrayList");
        List list1 = (List) aClass.newInstance();
        list1.add("abc");
        list.addAll(list1);
        System.out.println(list);
    }
}
