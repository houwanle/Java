package bit_operation;
/*
 * 求一个十进制数对应的二进制数中的1个数
 */
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(countOne(n));
	}

	private static int countOne(int n) {
		int count = 0;
		while(n > 0){
			if(n!=0){
				n = n & (n-1);
			}
			count++;
		}
		return count;
	}
}
