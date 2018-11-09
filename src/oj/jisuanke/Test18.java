package test;
/*
数组内存放了一些个位数字，组成一个大数（从高位到低位），现在将这个数加 1，并输出加一以后的结果。
例如：
A = [2,3,1,1,4]
则结果为 [2,3,1,1,5]。
A = [7,8,9]
则结果为 [7,9,0]。

输入格式
第一行输入一个正整数 n(1≤n≤100)，接下来的一行，输入用空格分隔的 n个 0到 9的非负整数组成的数组 A[n]。
输出格式
输出一行，n个用空格分隔的整数，表示加一后的新数组。
 */
import java.util.Scanner;

public class Test18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] arr1 = new int[len];
		int[] arr2 = new int[len + 1];
		for (int i = 0; i < len; i++) {
			arr1[i] = sc.nextInt();
		}
		arr1[len - 1] += 1;
		for (int i = len - 1; i > 0; i--) {
			if (arr1[i] == 10) {
				arr1[i] = 0;
				arr1[i - 1] += 1;
			}
		}
		int flag = 0;
		if (arr1[0] == 10) {
			arr2[0] = 1;
			arr2[1] = 0;
			flag++;
			if (len + 1 > 2) {
				for (int i = arr1.length - 1; i >= 2; i--) {
					arr2[i] = arr1[i];
				}
			}
		}
		if (flag == 0) {
			for (int i = 0; i < len; i++) {
				System.out.print(arr1[i] + " ");
			}
		} else {
			for (int i = 0; i <= len; i++) {
				System.out.print(arr2[i] + " ");
			}
		}
	}
}
