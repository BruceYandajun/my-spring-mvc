package com.github.bruce.algorithm.arrays;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindNotDupArray {
    public static void main(String[] args) {
        String s = "abcdaefgf";
        // 字符串，求出最大的不包含重复字符的子串
        char[] chars = s.toCharArray();
        Set<Character> notDup = new HashSet<>();
        List<Character> maxList = Lists.newArrayList();
        List<Character> tmpList = Lists.newArrayList();
        for (char aChar : chars) {
            if (!notDup.contains(aChar)) {
                notDup.add(aChar);
                tmpList.add(aChar);
            } else {
                tmpList = tmpList.subList(tmpList.indexOf(aChar) + 1, tmpList.size());
                tmpList.add(aChar);
                if (tmpList.size() > maxList.size()) {
                    maxList = tmpList;
                }
            }
        }
        System.out.println(maxList);
    }
}
