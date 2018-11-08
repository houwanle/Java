package test;
/*
给定一个升序排列的数组，去掉重复的数，并输出新的数组的长度。
例如：数组A={1,1,2}，你的程序应该输出 2即新数组的长度，新数组为{1,2}。
要求：不能新开数组分配额外的空间，即常数空间限制。

输入格式
输入一个整数 n(1≤n≤1000)。
接下来一行 n个整数 Ai(−1000≤Ai≤1000)，表示数组 A中的每个元素。
输出格式
输出一个整数，表示新数组长度。

样例输入
5
0 0 1 1 2
样例输出
3
 */
import java.util.Scanner;

public class Test10 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] arr = new int[len];
		for(int i = 0; i < len; i++){
			arr[i] = sc.nextInt();
		}
		int count = 0;
		for(int i = 0; i < len-1; i++){
			if(arr[i] != arr[i+1]){
				count++;
			}
		}
		System.out.println(count+1);
	}
}
