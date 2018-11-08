package test;
/*
判断一个数是否能被另一个整数整除是一个挺简单的问题，一般一个模运算就可以搞定了，
懒惰的晓萌还是不想自己做，于是找到你帮他写代码，你就帮帮他吧。

输入格式
输入包括两个由空格分开的整数 M和N(1≤M,N≤500)。

输出格式
输出包括一行，如果 M可以被 N整除就输出YES，否则输出NO（结果大小写敏感）。

样例输入
21 7
样例输出
YES
*/

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a%b!=0){
			System.out.println("NO");
		}else
			System.out.println("YES");
	}
}
