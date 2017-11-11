package com.github.bruce.base;

/**
 * 斐波那契额数列
 * 
 * @author yandajun
 *
 */
public class FibonaciTest {
	/**
	 * 用递归实现，时间复杂度O(n^2)
	 * 
	 * @param n
	 * @return
	 */
	public static int f(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		return f(n - 2) + f(n - 1);
	}

	/**
	 * 用迭代方式，时间复杂度为O(n)
	 * 
	 * @param n
	 * @return
	 */
	public static int f1(int n) {
		int f0 = 1;
		int f1 = 1;
		int f2 = 1;
		for (int i = 3; i <= n; i++) {
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}
		return f2;
	}

	public static void main(String[] args) {
		System.out.println(f(8));
		System.out.println(f1(8));
	}
}
