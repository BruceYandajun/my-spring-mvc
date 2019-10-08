package com.github.bruce.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || k == 0)
            return res;
        System.out.println(res);
        res = combine(n - 1, k - 1);
        if (res.isEmpty())//n==k时才有可能为空
            res.add(new ArrayList<>());
        for (List<Integer> list : res) {
            list.add(n);
        }
        res.addAll(combine(n - 1, k));
        return res;
    }

    private static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        return res;
    }
}
