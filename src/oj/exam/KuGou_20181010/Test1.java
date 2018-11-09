/* 给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符(需要区分大小写)。
输入描述:
输入数据一个字符串，包括字母,数字等。

输出描述:
输出首先出现三次的那个英文字符

示例
输入
Have you ever gone shopping and

输出
e
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] split = str.replaceAll(" ", "").split("");
		String[] strs = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", 
				"l", "m", "n", "o", "p", "q", "r", "s","t", "u", "v", "w", "x", 
				"y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
				"L", "M", "N","O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
				"Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8","9" };
		List<String> asList = Arrays.asList(strs);
		Map<String, Integer> map = new HashMap<>();
		for (String s : split) {
			if (asList.contains(s)) {
				if (!map.containsKey(s)) {
					map.put(s,1);
				} else {
					map.put(s, map.get(s) + 1);
					if (map.get(s) == 3) {
						System.out.println(s);
						return;
					}
				}
			} 
		}
	}
}

=====================================================================================================================

方法二：
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Test8 {    
	public static void main(String[] args) throws IOException {        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
		char[] strArr = br.readLine().toCharArray();//String类型转化为字符数组        
		int[] count = new int[128];//存储每个字符        
		for (int i = 0; i < strArr.length; i++) {            
			if (('A' <= strArr[i] && strArr[i] <= 'Z') || 
					(strArr[i] >= 'a' && strArr[i] <= 'z')||
					(strArr[i]>='0' && strArr[i]<='9')) {                
				++count[strArr[i]];//针对每个字符进行计数                
				if(count[strArr[i]] == 3){                    
					System.out.println(strArr[i]);                    
					break;                
				}            
			}        
		}      
	}
}
