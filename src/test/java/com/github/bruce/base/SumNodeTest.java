package com.github.bruce.base;

/**
 * 求出两个链表的和,超过10进一位；每个链表的值小于或等于9 如： Input:(2 -> 4 -> 3), (5 -> 6 -> 4) Output:7
 * -> 0 -> 8
 * 
 * @author Bruce
 *
 */
public class SumNodeTest {
	public static Node createNode(int[] a) {
		Node node = null;
		for (int i = a.length - 1; i >= 0; i--) {
			Node newNode = new Node(a[i]);
			newNode.next = node;
			node = newNode;
		}
		return node;
	}

	public static void print(Node node) {
		Node n = node;
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
	}

	public static Node sumNode(Node a, Node b) {
		Node node = null;
		int flag = 0;
		int aValue = 0;
		int bValue = 0;
		while (a != null || b != null) {
			aValue = (a == null ? 0 : a.val);
			bValue = (b == null ? 0 : b.val);
			int sum = aValue + bValue + flag;
			flag = sum > 10 ? 1 : 0;
			Node newNode = new Node(sum - 10 > 0 ? sum - 10 : sum);
			newNode.next = node;
			node = newNode;
			if (a != null)
				a = a.next;
			if (b != null)
				b = b.next;
		}
		return node;
	}

	public static void main(String[] args) {
		int[] a = { 4, 7, 1 };
		int[] b = { 5, 8, 9, 1 };
		// print(createNode(a));
		// print(createNode(b));
		print(sumNode(createNode(a), createNode(b)));
	}
}

class Node {
	public int val;
	public Node next;

	public Node(int val) {
		this.val = val;
	}
}
