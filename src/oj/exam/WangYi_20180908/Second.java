package wangyi_20180908;
/*在一条街上有n幢房子，标号从1到n，两个在标号上相差为1的房子视为相邻，这些房子中有k幢房子已有住户。
 * 现你准备搬入这条街，你能搬入一幢房子的条件是这幢房子没有人住在里面，与此同时由于你非常热爱与邻居进行交流，
 * 故而你需要你所入住的房子两边都有住户。
 * 现要你求最小的可能符合要求的房子数，以及最大的可能符合要求的房子数。
 * Note：就样例来说，#代表已有住户，-代表空位，这种情况(###---)，没有满足条件的房子，为最小，故输出0
 * 最大的情况为(#-#-#-)，此种情况有两个位置满足条件，为最大，故输出2
 * 
 * 输入描述
 * 输入的一行为测试用例数t(1<=t<=200000),
 * 接下来t行，每行含两个整数n和k，(1<=n<=1000000000,0<=k<=n)
 * 输出描述
 * 对于每个用例输出最小的可能数以及最大的可能数
 * 
 * 示例1
 * 输入
 * 6
 * 1 0
 * 1 1
 * 2 0
 * 2 1
 * 2 2
 * 6 4
 * 输出
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 * 
 */

import java.util.*;

public class Second {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t > 0) {
			while (input.hasNext()) {
				int n = input.nextInt();
				int k = input.nextInt();
				int a[] = ppu(n, k);
				System.out.println(a[0] + " " + a[1]);
			}
			t--;
		}

	}

	public static int[] ppu(int n, int k) {
		int min = 0;
		int max = 0;
		int[] a = new int[2];
		if (n <= 2 || k < 2) {
			a[0] = min;
			a[1] = max;

		} else {
			int lc = (int) Math.ceil(n / 2);

			if (k > lc) {
				max = n - k;
			} else {
				max = k - 1;
			}
			a[0] = min;
			a[1] = max;
		}
		return a;
	}
}
