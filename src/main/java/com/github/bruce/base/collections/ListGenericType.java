package com.github.bruce.base.collections;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ListGenericType {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // 一个带Integer泛型的list，如何add进一个String对象
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        for (Method method : list.getClass().getMethods()) {
            if ("add".equalsIgnoreCase(method.getName()) && method.getParameterCount() == 1) {
                method.invoke(list, "abc");
            }
        }
        System.out.println(list);
    }
}
