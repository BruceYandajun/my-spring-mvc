package com.github.bruce.test.base;

/**
 * Description
 * <p>
 * </p>
 * DATE 10/15/17.
 *
 * @author yandajun.
 */
public class StringSplitTest {
    public static void main(String[] args) {
        String s = "123,";
        System.out.println(s.substring(0, s.length() - 1));
        String[] array = s.split(",");
        System.out.println(array.length);
        for (String i : array) {
            System.out.println(i);
        }
    }
}
