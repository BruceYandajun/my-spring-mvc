package com.github.bruce.base;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Description
 * <p>
 * </p>
 * DATE 10/19/17.
 *
 * @author yandajun.
 */
public class LocalHostTest {
    public static void main(String[] args) {
        try {
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
