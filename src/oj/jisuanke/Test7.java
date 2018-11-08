package test;

/*
有一个奇怪的国家，里面的国民对于事情的态度永远只有两面。
当两个人遇到一起讨论一个事情的时候——两个持赞同观点的人遇到一起后会对这个事情都继续赞同；
一个持赞同观点的人遇到一个持不赞同观点的人的时候，两人都会不再继续赞同；
两个持不赞同观点的人遇到一起讨论后反而会对这个事情开始赞同。

输入格式
输入包括两行，每行包括N(1≤N≤50)个数字，分别表示两个人对于 N个事情对应的看法——0表示不赞同、1表示赞同。
输出格式
输出包括一行，包括 N个数字，表示两人相遇后，对于这 N件事情的最终看法。

样例输入
11100101
00101011
样例输出
00110001
 */

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int len = str1.length();
		for(int i = 0; i < len; i++){
			if(str1.charAt(i) != str2.charAt(i)){
				System.out.print(0);
			} else {
				System.out.print(1);
			}
		}
	}
}
