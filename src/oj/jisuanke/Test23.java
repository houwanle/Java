package test;
/*
下面我将描述一个简单的函数：
f(8)=2
f(16)=1
f(32)=0
f(2048)=3
读入一个x(1≤x≤101000)，请你找出f(x)的值。
输入包括一行，仅一个数字x。
输出包括一行，仅一个数字f(x)。
提示：
f(0)=1, f(1)=0, f(2)=0, f(3)=0, f(4)=0, f(5)=0, f(6)=1, f(7)=0, f(8)=2, f(9)=1
有时候看数据猜题意也是很重要的技能，如果你看到这里还不知道题意的话，那么我来告诉你，
f(x)表示x的十进制表示中有多少个圈圈。

样例输入
2048
样例输出
3
 */
import java.util.Scanner;

public class Test23 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char[] str = sc.nextLine().toCharArray();
		int count = 0;
		for(int i = 0; i < str.length; i++){
			if(str[i] == '0' || str[i] == '6' || str[i] == '9'){
				count++;
			}
			if(str[i] == '8'){
				count += 2;
			}
		}
		System.out.println(count);
	}
}
