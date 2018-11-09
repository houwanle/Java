/*优势洗牌
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
返回 A 的任意排列，使其相对于 B 的优势最大化

输入
2个正整形的A、B数组

数组输入值以英文逗号分开

输出
重排后的A数组

样例输入
A=[2,7,11,15],B=[1,10,4,11]
样例输出
[2, 11, 7, 15]

通过率：未知
 */
 
 import java.util.*;

public class Third {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		int lindex1 = s1.indexOf('[');
		int rindex1 = s1.indexOf(']');
		String sA = s1.substring(lindex1 + 1, rindex1);
		int lindex2 = s1.lastIndexOf('[');
		int rindex2 = s1.lastIndexOf(']');
		String sB = s1.substring(lindex2 + 1, rindex2);
		String strA[] = sA.split(",");
		String strB[] = sB.split(",");
		int lenA = strA.length;
		int lenB = strB.length;
		int numA[] = new int[lenA];
		int numB[] = new int[lenB];
		for (int i = 0, j = 0; i < lenA || j < lenB; i++, j++) {
			if (i < lenA)
				numA[i] = Integer.parseInt(strA[i]);
			if (j < lenB)
				numB[i] = Integer.parseInt(strB[i]);
		}

		System.out.println(maxAdvantage(numA, numB));
	}

	// 主要使用TreeMap的getHigherEntry函数。找到比B当前元素大的最小值，若没有比它大的，就用最小值来对它（田忌赛马）。
	public static ArrayList<Integer> maxAdvantage(int[] A, int[] B) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int num : A) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
			Map.Entry<Integer, Integer> matchingEntry = map.higherEntry(B[i]);
			if (matchingEntry == null) {
				matchingEntry = map.firstEntry();
			}

			res.add(matchingEntry.getKey());
			if (matchingEntry.getValue() == 1) {
				map.remove(matchingEntry.getKey());
			} else {
				map.put(matchingEntry.getKey(), matchingEntry.getValue() - 1);
			}
		}
		return res;
	}
}
