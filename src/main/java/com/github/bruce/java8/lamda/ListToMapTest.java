package com.github.bruce.java8.lamda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToMapTest {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("1", true);
        map.put("2", false);
        List<Map> list = new ArrayList<>();
        list.add(map);

//        list.stream().collect(Collectors.toMap(a -> a.get(""), a.get("")));

    }
}
