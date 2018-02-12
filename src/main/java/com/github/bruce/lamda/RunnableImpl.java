package com.github.bruce.lamda;

/**
 * Description
 * <p>
 * </p>
 * DATE 2/12/18.
 *
 * @author yandajun.
 */
public class RunnableImpl {
    public static void main(String[] args) {
        // jdk 1.8 ago
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runing...");
            }
        }).start();

        // now in jdk 1.8
        new Thread(() -> System.out.println("Lambda expression...")).start();
    }
}
