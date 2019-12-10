package com.github.bruce.test.base.collections.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListSplit {


    public static void main(String[] args) {
        int pageSize = 10;
        String studentIds = "1,2,5,6,7,9,2,9,22,3,3,123,2,5,6,7,9,2,9,22,3,3,123";
        List<String> list = Arrays.stream(studentIds.split(",")).collect(Collectors.toList());
        int size = list.size();
        String[] ids = new String[size % pageSize == 0 ? size / pageSize : size / pageSize + 1];
        for (int i = 0; i < size; i ++) {
            int bucket = i / pageSize;
            String s = ids[bucket];
            s = (s == null ? "" : s);
            s += (i % pageSize != 0 ? "," : "") + list.get(i);
            ids[bucket] = s;
        }
        Arrays.stream(ids).forEach(System.out::println);
    }
}
