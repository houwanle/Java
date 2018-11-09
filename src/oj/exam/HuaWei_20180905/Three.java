package huawei_20180905;
/*题目描述
 * 将一段压缩后的字符串解压缩，并且排序输出
 * 解压规则：
 * 每个字符串后面跟随一个数字，表示这个字符的重复次数。
 * 例如，"a5"解压后的结果为"aaaaa";"abc3"解压后的结果为"abcabcabc"
 * 排序规则
 * 1.根据每个字符串的重复次数升序排序，然后输入结果。例如，"a3b2",输出的结果为"bbaaa"
 * 2.如果字符重复次数一样，则根据ASCII编码顺序作升序排序，然后输出结果。例如，"b2a2",输出的结果为"aabb"
 * 
 * 输入描述
 * 输入原始的字符串仅包含字母与数字
 * 输出描述
 * 输出的结果字符串仅包含字符
 * 
 * 示例
 * 输入
 * a11b2bac3bad3abcd2
 * 输出
 * abcdabcdbbbacbacbacbadbadbadaaaaaaaaaaa
 * 
 */
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

class char_num implements Comparable<char_num> {
	int number;
	String string;

	public char_num(int a, String str) {
		this.number = a;
		this.string = str;
	}

	public int compareTo(char_num o) {
		int n = this.number - o.number;
		if (n != 0) {
			return n;
		} else {
			return this.string.compareTo(o.string);
		}
	}
	public String toString() {
		String res = "";
		for(int i=0;i < this.number;i++) {
			res = res + this.string;
		}
		return res;
	}

}

public class Three {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		pop(str);
		
	}
	
	public static void pop(String str){
		int number = 0;
		String s = "";
		boolean flag = false;
		char[] ch = str.toCharArray();
		TreeSet<char_num> set = new TreeSet<char_num>();
		
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= '0' && ch[i] <= '9') {
				number = number * 10 + ch[i] - '0';
				if (i == ch.length - 1 || (ch[i + 1] > '9' || ch[i + 1] < '0')) {
					flag = true;
					set.add(new char_num(number, s));
					number = 0;
					s = "";
				}
			} else s += ch[i];
			
		}
		
		for(Iterator it = set.iterator(); it.hasNext(); ) { 
		    System.out.print(it.next().toString());
		}  
	}
}