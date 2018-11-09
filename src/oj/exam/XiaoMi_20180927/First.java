/*
集合合并
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB

题目描述：
给定若干个32位int数字集合，每个集合中的数字无重复，譬如：{1,2,3}  {2,5,6}  {8}
将其中交集不为空的集合合并，保证合并完成后所有集合之间无交集，输出合并后的集合个数以及最大集合中元素的个数。

输入
输入格式：
1. 第一行为一个数字N，表示集合数。
2. 接下来N行，每行一个非空集合，包含若干个数字，数字之间用空格分开。

输出
输出格式：
1. 第一行为合并后的集合个数。
2. 第二个为最大集合中元素的个数。

样例输入
3
1 2 3
2 5 6
8
样例输出
2
5
 */
import java.util.*;

public class First {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fun(sc, n);
	}

	public static void fun(Scanner sc, int n) {
		Map<Integer, Integer> in = new HashMap<>();// 存储每个值和属于的集合编号
		Map<Integer, Integer> res = new HashMap<>();// 存储每个集合的编号和对应的元素个数。
		int arr[] = new int[n];
		// 初始化
		for (int i = 0; i < n; i++)
			arr[i] = i;
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String str1[] = sc.nextLine().split(" ");
			for (int j = 0; j < str1.length; j++) {
				int tmp = Integer.parseInt(str1[j]);
				if (in.containsKey(tmp)) {
					if (find_fun(in.get(tmp), arr) != find_fun(i, arr))
						union_fun(in.get(tmp), i, arr);
				} else {
					in.put(tmp, i);
				}
			}
		}
		int num = 0;
		int max = 0;
		for (int val : in.keySet()) {
			int temp = find_fun(in.get(val), arr);
			if (res.containsKey(temp)) {
				res.put(temp, res.get(temp) + 1);
			} else {
				num++;
				res.put(temp, 1);
			}
			if (res.get(temp) > max)
				max = res.get(temp);
		}
		System.out.println(num);
		System.out.println(max);
	}

	public static int find_fun(int i, int[] arr) {
		if (arr[i] != i)
			arr[i] = find_fun(arr[i], arr);
		return arr[i];
	}

	public static void union_fun(int i, int j, int[] arr) {
		arr[j] = find_fun(i, arr);
	}
}
