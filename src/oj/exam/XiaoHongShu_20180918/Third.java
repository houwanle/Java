package xiaohongshu_20180918;
/*薯队长在平时工作中需要经常跟数字打交道，某一天薯队长收到了一个满是数字的表格，
 * 薯队长注意到这些数字里面很多数字都包含1，比如101里边包含两个1,616里包含一个1.
 * 请你设计一个程序帮薯队长计算任意一个正整数n(0<n<=2147483647),从1到n（包括n）
 * 的所有整数数字里含有多少个1.
 * 
 * 输入描述
 * 正整数n(0<n<=2147483647)
 * 输出描述
 * 从1到n（包括n）的所有整数数字里含有多少个1
 * 
 * 输入
 * 1
 * 输出
 * 1
 * 
 * 输入
 * 13
 * 输出
 * 6
 * 
 */
import java.util.Scanner;

public class Third {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		num_fun(n);
	}

	public static void num_fun(long n) {
		long count = 0;
		long len = 0;
		long m = n;
		while (m > 0) {
			len++;
			m = m / 10;
		}
		for (int i = 0; i < len; i++) {
			int mod;
			if (i == 0) {
				mod = 1;
			} else {
				mod = (int) Math.pow(10, i);
			}

			long l = n % mod;
			long h = n / (mod * 10);
			long p = (n / mod) % 10;
			if (p == 0) {
				count += h * (Math.pow(10, i));
			} else if (p == 1) {
				count += h * (Math.pow(10, i)) + l + 1;
			} else if (p > 1) {
				count += (h + 1) * (Math.pow(10, i));
			}
		}
		System.out.println(count);
	}
}

