/*题目描述
 * 小易很喜欢斑马，因为它们身上黑白相间的花纹。
 * 一天小易得到了一串橡皮泥，这串橡皮泥只有黑色和白色，小易想把这串橡皮泥重新拼凑下，
 * 让这个橡皮泥串中最长的连续的黑白相间的子串最长，但是小易有强迫症，所以他可以对橡皮泥串进行一下的操作0次或多次：
 * 把橡皮泥从某个地方切割开，将两个得到的两个串同时翻转，在拼凑在一起。
 * 这个橡皮泥串可能太长了，所以小易没有办法计算最终可以得到的最长的连续的黑白相间的子串的长度，希望你能帮他计算出这个长度
 * 
 * 输入描述
 * 一个字符串s，只包含字母'b'和字母'w'，分别表示黑色和白色的橡皮泥块，满足1<= |s| <= 10^5,|s|代表字符串的长度
 * 输出描述
 * 一个整数，表示改变之后最长的连续的黑白相间的子串的长度。
 * 
 * 示例
 * 输入
 * bwbwb
 * 输出
 * 5
 * 示例2
 * 输入
 * wwb
 * 输出
 * 3
 */
import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.next();
		System.out.println(maxlen(s));
	}

	public static int maxlen(String s) {
		char ca[] = s.toCharArray();
		StringBuffer str1 = new StringBuffer();
		StringBuffer str2 = new StringBuffer();
		if (s.charAt(0) == s.charAt(s.length() - 1))
			return OneMAXlen(s);
		if (OneMAXlen(s) == s.length())
			return s.length();
		int i = 0;
		while (i < ca.length - 1) {
			if (ca[i] != ca[i + 1]) {
				str1.append(ca[i]);
				i++;
			} else {
				str1.append(ca[i]);
				i++;
				break;
			}
		}
		while (i < ca.length) {
			str2.append(ca[i]);
			i++;
		}
		str2.append(str1.toString());
		return OneMAXlen(str2.toString());

	}

	public static int OneMAXlen(String str) {
		int k = 1;
		int max = 0;
		char ca[] = str.toCharArray();
		for (int i = 0; i < str.length() - 1;) {
			if (ca[i] != ca[i + 1]) {
				k++;
				max = Math.max(max, k);
			} else {
				max = Math.max(max, k);
				k = 1;
			}
			i++;
		}
		return max;
	}

}
