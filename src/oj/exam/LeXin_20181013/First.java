/* 给定一个字符串，找出该字符串的最长回文子串。回文字符串指的就是从左右两边看都一样的字符串，
 * 如aba，cddc都是回文字符串。
 * 输入
 * babcd
 * 输出
 * bab
 * 
 */
import java.util.*;
public class First {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String s = String.valueOf(str.charAt(0));
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				if (juge(str.substring(i, j)) && s.length() < (j - i)) {
					s = str.substring(i, j);
				}
			}
		}
		System.out.println(s);
	}

	public static boolean juge(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i <= j) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}
