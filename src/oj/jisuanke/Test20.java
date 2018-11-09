package test;
/*
在一个数组中找出和最大的连续几个数。（至少包含一个数）
例如：
数组A[] = [−2, 1, −3, 4, −1, 2, 1, −5, 4]，则连续的子序列[4,−1,2,1]有最大的和6.

输入格式
第一行输入一个不超过1000的整数n。
第二行输入n个整数A[i]。
输出格式
第一行输出一个整数，表示最大的和。

样例输入
3
1 1 -2
样例输出
2
 */
import java.util.Scanner;

public class Test20 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			sum += sc.nextInt();
			if(sum > max){
				max = sum;
			}
			if(sum < 0){
				sum = 0;
			}
		}
		System.out.println(max);
	}
}
