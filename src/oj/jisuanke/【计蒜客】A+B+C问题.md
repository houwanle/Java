# 1. 题目描述
输入为一行，包括了用空格分隔的三个整数 A、B、C（数据范围均在−40 ~ 40之间）。
输出为一行，为“A+B+C”的计算结果。

样例输入
22 1 3
样例输出 
26 
# 2. AC代码
```java
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int sum = a+b+c;
		
		System.out.println(sum);
	}
}
```

