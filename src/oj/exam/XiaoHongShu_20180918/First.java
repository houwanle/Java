/*题目描述
 * 输入一串字符，轻编写一个字符串压缩程序，将字符串中连续出现的重复字符进行压缩，
 * 并输出压缩后的字符串。
 * 例如：
 * aac 压缩为 1ac
 * xxxxyyyyyzbbb 压缩为 3x5yz2b
 * 
 * 输入描述：
 * 任意长度字符串
 * 输出描述：
 * 压缩后的字符串
 * 
 * 输入
 * xxxxyyyyyzbbb
 * 输出
 * 3x5yz2b
 */
import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str_num(str);
	}

	public static void str_num(String str) {
		for (int i = 0; i < str.length(); i++) {
			int n = 0;
			int j;
			for (j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					n++;
				else 
					break;
			}
			
			if (n == 0)
				System.out.print(str.charAt(i));
			else 
				System.out.print(n + "" + str.charAt(i));
			i = j - 1;
		}
	}
}
