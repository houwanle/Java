/*同构串
 * 题目描述
 * 给出两个字符串a1a2a3...an和b1b2b3...bm,如果存在一种映射ai=f(bi),且如果
 * ai不等于bi,f(ai)不等于f(bi),我们称这两个字符串同构。
 * 
 * 输入
 * 输入第一行包含一个t，表示数据组数，t<=20.
 * 对于每组数据，输入包含两行，每一行有一个字符串，每个字符串的长度不超过1000，
 * 字符串全部由小写字母组成。
 * 
 * 输出
 * 对于每组数据输出一行，如果字符串同构，输出"Yes",不同构则输出"No".
 * 
 * 样例输入
 * 2
 * abac
 * bcbd
 * aba
 * abc
 * 样例输出
 * Yes
 * No
 * 
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> list = new ArrayList<String>();
		sc.nextLine();
		for(int i = 0 ; i < n ; i++) {
			String a_array = sc.nextLine();
			String b_array = sc.nextLine();
			boolean ok = isOK(a_array, b_array);
			if (ok == true) {
				list.add("Yes");
			}else {
				list.add("No");
			}
		}
		for (String str : list) {
			System.out.println(str);
		}
	}
	
	public static boolean isOK(String a_array, String b_array) {
		int length = a_array.length();
		Map<Character, Character> map = new HashMap<Character, Character>();
		for(int i = 0 ; i < length ; i++) {
			char a = a_array.charAt(i);
			char b = b_array.charAt(i);
			if (map.containsKey(a)) {
				if (map.get(a) != b) {
					return false;
				}
			}else {
				if (map.containsValue(b)) {
					return false;
				}
				map.put(a, b);
			}
		}
		return true ;
	}
}
