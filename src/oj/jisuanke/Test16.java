package test;
/*
设计函数int sqrt(int x)，计算 x的平方根。

输入格式
输入一个 整数 x，输出它的平方根。直到碰到文件结束符（EOF）为止。
输出格式
对于每组输入，输出一行一个整数，表示输入整数的平方根。

样例输入
1
2
3
4
5
6
7
8
9
样例输出 
1
1
1
2
2
2
2
2
3
 */
import java.util.Scanner;

public class Test16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int x = sc.nextInt();
			System.out.println(fun(x));
		}
	}

	private static int fun(int x) {
		int low = 0;
		int high = x;
		while (low <= high) {
			long mid = (long) (low + high) / 2;
			if (mid * mid < x) {
				low = (int) mid + 1;
			} else if (mid * mid > x) {
				high = (int) mid - 1;
			} else {
				return (int) mid;
			}
		}
		return high;
	}
}
