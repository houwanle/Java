/* 题目描述
 * 2个大整数相加，每一位是一个小写字母，二十六进制，a表示0，z表示25，求结果。
 * 
 * 输入描述
 * 输入2个26进制数
 * 输出描述：
 * 输出两个26进制的和
 * 
 * 示例
 * 输入
 * z
 * bc
 * 输出
 * cb
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class One {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		add(arr1,arr2);	
	}
	
	public static void add(char[] arr1, char[] arr2){
		int n1 = 0;
		int n2 = 0;
		for (int i = 0; i < arr1.length; i++) {
			n1 += (arr1[i] - 'a' + 0) * Math.pow(26, arr1.length - 1 - i);
		}
		for (int i = 0; i < arr2.length; i++) {
			n2 += (arr2[i] - 'a' + 0) * Math.pow(26, arr2.length - 1 - i);
		}

		List<Long> list = new ArrayList<Long>();
		long sum = n1 + n2;
		if (sum == 0) {
			System.out.println('a');
		}
		while (sum > 0) {
			long temp = sum % 26;
			list.add(temp);
			sum = sum / 26;
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print((char) ('a' + list.get(i)));
		}
	}
}
