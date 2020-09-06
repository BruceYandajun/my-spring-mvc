package com.github.bruce.base.collections.map;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class FindTwoNumberOfSummation8 {

    /**
     * 一个无序不重复的数组，找出两个和为8的的数字
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {2, 7, 8, 3, 0, 6, 1};
        Map<Integer, Integer> map = Maps.newHashMap();
        Arrays.stream(array).forEach(i -> map.put(i, -1));
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (map.containsKey(8 - next.getKey()) && map.get(8 - next.getKey()) == -1) {
                next.setValue(8 - next.getKey());
            } else {
                iterator.remove();
            }
        }
        System.out.println(map);
    }
}
