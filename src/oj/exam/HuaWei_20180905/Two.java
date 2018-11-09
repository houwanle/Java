package huawei_20180905;
/* 题目描述
 * 两个字符串input1，和字符串input2，字符床中元素的值域是
 * 26个大写字母，判断input2中的所有字符是否都包含在字符串
 * input1中。
 * 如果包含返回：true
 * 否则返回：false
 * 
 * 输入描述
 * 两个字符串：input1和input2，其中input1的长度大于input2.要求两个输入字符串
 * input1和input2的长度不小于5，如：
 * A字符串：BBDDCFFE
 * B字符串：LCEFB
 * 输出描述：
 * true或false
 * 
 * 示例
 * 输入
 * BBDDCFFEL
 * 输出
 * true
 * 
 * 说明
 * 输入字符串LCEFB的每个字符都出现在BBDDCFFEL，因而返回true
 * 
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Two {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		include(ch1,ch2);
		
	}
	
	public static void include(char[] ch1,char[] ch2){
		
		Set s1 = new HashSet<>();
		Set s2 = new HashSet<>();
		
		for(int i = 0; i < ch1.length ; i++) {
			s1.add(ch1[i]);
		}
		for(int i = 0; i < ch2.length ; i++) {
			if (!s1.contains(ch2[i])) {
				System.out.println("false");
				return;
			}
		}
		System.out.println("true");
    }
}