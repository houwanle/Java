package meituan_20180906;
/*区间统计
 * 时间限制：C/C++语言;其他语言3000MS
 * 内存限制：C/C++语言65536KB;其他语言589824KB
 * 题目描述：
 * 小明拿到了一个数列a1,a2,...an,小明想知道存在多少个区间[l,r]同时满足下列两个条件：
 * 1、r-l+1=k;
 * 2、在al,al+1,...ar中，存在一个数至少出现了t次。
 * 输出满足条件的区间个数。
 * 
 * 输入
 * 输入第一行三个整数n,k,t(1<=n,k,t<=10^5).
 * 输出
 * 输出一个数，问题的答案。
 * 
 * 样例输入
 * 5 3 2
 * 3 1 1 1 2
 * 样例输出
 * 3
 * 
 * Hint
 * 区间[1,3]中出现了2次，区间[2,4]中1出现了3次，区间[3,5]中1出现了2次，所以一共有3个区间满足条件。
 * 
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Two {
	static HashMap<Integer, Integer> hm = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int t = sc.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int count = 0;
		for (int l = 0, r = k + l - 1; r < n; l++, r++) {
			if (judge(a, l, r, t)) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean judge(int[] a, int l, int r, int t) {

		if (l == 0) {// 如果是第一次利用hm
			for (int i = l; i <= r; i++) {
				if (hm.containsKey(a[i])) {
					hm.put(a[i], hm.get(a[i]) + 1);
				} else {
					hm.put(a[i], 1);
				}
			}
		} else {
			if (hm.get(a[l - 1]) == 1) {
				hm.remove(a[l - 1]);
			} else {
				hm.put(a[l - 1], hm.get(a[l - 1]) - 1);
			}
			if (hm.containsKey(a[r])) {
				hm.put(a[r], hm.get(a[r]) + 1);
			} else {
				hm.put(a[r], 1);
			}
		}

		// for(int i = l; i <= r; i++) {
		// if(hm.containsKey(a[i])) {
		// hm.put(a[i], hm.get(a[i]) + 1);
		// }else {
		// hm.put(a[i], 1);
		// }
		// }

		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue() >= t) {
				return true;
			}
		}
		return false;
	}
}


