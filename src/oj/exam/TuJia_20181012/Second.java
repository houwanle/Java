/*报数问题
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数）， 凡报到3的人退出圈子，
问最后留下的是原来第几号的那位

输入
输入n表示有n个人围成一圈
输出
输出m表示最后剩余的人原来的排序序号

样例输入
73
样例输出
10 

通过率：100%
 */
 
方法一：
import java.util.Scanner;

public class Second {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(yuShefu(n,3));
    }

    public static int yuShefu(int n,int m){
        int sum=0;
        for(int i=2;i<=n;i++)sum=(sum+m%i)%i;
        return sum+1;
    }
}
======================================================================================================
方法二：
import java.util.Scanner;

public class Second {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fun(n);
	}

	private static void fun(int n) {
		boolean[] arr = new boolean[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = true;
		}
		int left = n;
		int count = 0;
		int m = 0;
		while (left > 1) {
			if (arr[m] == true) {
				count++;
				if (count == 3) {
					count = 0;
					arr[m] = false;
					left--;
				}
			}
			m++;
			if (m == n) {
				m = 0;
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == true) {
				System.out.println(i + 1);
			}
		}
	}
}
