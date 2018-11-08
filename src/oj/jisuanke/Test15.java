package test;
/*
假设你现在正在爬楼梯，楼梯有 n级。每次你只能爬 1级或者 2级，那么你有多少种方法爬到楼梯的顶部？

输入格式
第一行输入一个整数 n(1≤n≤50)，代表楼梯的级数。
输出格式
输出爬到楼梯顶部的方法总数。

样例输入
5
样例输出
8

分析：
假设从底走到第n级的走法有dp[n]种，走到第n级有两个方法，
一个是从(n-1)级走一步，另一个是从第(n-2)级走两步，前者有dp[n-1]种方法，
后者有dp[n-2]种方法，所以有dp[n] = dp[n-1] + dp[n-2],还有dp[0]=0,dp[1]=1,dp[2]=2。

 */
import java.util.Scanner;

public class Test15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(StepDP(n));
	}

	private static int StepDP(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		if (n > 0) {
			dp[1] = 1;
		}
		if (n > 1) {
			dp[2] = 2;
		}
		if (n > 2) {
			for (int i = 3; i < n + 1; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		return dp[n];
	}
}
