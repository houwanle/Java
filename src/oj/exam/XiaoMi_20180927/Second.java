/*
如何添加运算符
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB

题目描述：
给出一个数字N，对于数字序列 1,2,3 ... N。现在在其中插入“+”, "-", " "，使得表达式的和为M。" "的含义是把相邻的两个数字组成一个数。例如：1 + 2 3 - 4，含义是：1 + 23 - 4 = 20。
给出N和M，求出所有合法的序列的个数。

输入
两个整数N,M ( N <= 7, M <= 100)
输出
合法序列的个数

样例输入
7 0
样例输出
6

Hint
样例中的六种合法序列
1+2-3+4-5-6+7 
1+2-3-4+5+6-7 
1-2 3+4+5+6+7 
1-2 3-4 5+6 7 
1-2+3+4-5+6-7 
1-2-3-4-5+6+7
 */
import java.util.Scanner;

public class Second {
	static int count = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		String s = "";
		for (int i = 1; i <= n; i++) {
			s = s + i;
		}
		dfs(s, m, 0, true);
		System.out.println(count);
	}

	public static void dfs(String num, int target, int nowSum, boolean flag) {
		if (num.length() == 0 && nowSum == target)
			count++;
		for (int i = 1; i <= num.length(); i++) {
			String nowStr = num.substring(0, i);
			String nextStr = num.substring(i);
			if (flag) {
				dfs(nextStr, target, Integer.parseInt(nowStr), false);
			} else {
				dfs(nextStr, target, nowSum + Integer.parseInt(nowStr), flag);
				dfs(nextStr, target, nowSum - Integer.parseInt(nowStr), flag);
			}
		}
	}
}
