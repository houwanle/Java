/*幸运ID
 * 题目描述
 * 小C有一张票，这张票的ID是长度为6的字符串，每个字符都是数字，
 * 他想让这个ID变成他的辛运ID，所以他就开始更改ID，每一次操作，
 * 他可以选择任意一个数字并且替换它。如果这个ID的前三位数字之和
 * 等于后三位数字之和，那么这个ID就是辛运的。你帮小C求一下，
 * 最少需要操作几次，能使ID变成辛运ID
 * 
 * 输入描述：
 * 输入只有一行，是一个长度为6的字符串。
 * 输出描述
 * 输出这个最小操作次数
 * 
 * 输入
 * 000000
 * 输出
 * 0
 * 
 */
import java.util.*;

public class First {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int n = 0;
		int head[] = new int[3];
		int rear[] = new int[3];
		int str1 = 0, str2 = 0;
		for (int i = 0; i < 3; i++) {
			head[i] = Integer.parseInt(str.substring(i, i + 1));
			str1 += head[i];
			rear[i] = Integer.parseInt(str.substring(i + 3, i + 4));
			str2 += rear[i];
		}
		Arrays.sort(head);
		Arrays.sort(rear);
		if (str1 > str2)
			n = step(str2, rear, str1, head);
		else
			n = step(str1, head, str2, rear);
		System.out.println(n);
	}
	
	public static int step(int s1, int[] head, int s2, int[] rear) {
		int count = 0;
		for (int i = 2; i >= 0; i--) {
			head[i] = 9 - head[i];
		}
		int i = 0, j = 2;
		while (s1 < s2 && i < 3 && j >= 0) {
			count++;
			if (head[i] < rear[j]) {
				s2 -= rear[j];
				j--;
			} else {
				s1 += head[i];
				i++;
			}
		}
		return count;
	}
}
