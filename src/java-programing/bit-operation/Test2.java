package bit_operation;

import java.util.Scanner;

/*
 * 判断一个数是否为2的n次方
 */
public class Test2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(isPower(n));
	}

	private static boolean isPower(int n) {
		if(n < 1) 
			return false;
		int m = n & (n - 1);
		return m == 0;
	}
}
