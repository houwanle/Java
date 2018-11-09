package fenghuokj_20180917;
/*交友大会
 * 沫璃组织了一场交友大会，现场来了n个人，沫璃打算将他们分成m组进行交友，每
 * 组至少有一个人，大会结束后同一组的人都成为了朋友，沫璃想知道怎样分组会得到
 * 最少对朋友和最多对朋友，若两个不同的人在同一组，那么他们将成为一对朋友。
 * 
 * 输入
 * 第一行一个数T(T<=100),表示数据组数。
 * 对于每组数据，第一行两个整数n,m(1<=m<=n<=10^9)
 * 输出
 * 对于每组数据，输出一行，两个整数，分别表示最少对朋友和最多对朋友。
 * 
 * 样例输入
 * 2
 * 3 2
 * 6 3
 * 
 * 样例输出
 * 1 1
 * 3 6
 * 
 */
import java.util.Scanner;

public class Second {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] array = new long[n][2];
		for(int i = 0; i < n ; i++) {
			array[i][0] = sc.nextInt();
			array[i][1] = sc.nextInt();
		}
		long[][] minAndMax = findMinAndMax(array,n);
		for(int i =0 ; i < n ; i++) {
			System.out.println(minAndMax[i][0]+" "+minAndMax[i][1]);
		}
	}
	
	public static long[][] findMinAndMax(long[][] array,int n){
		long[][] minAndMax= new long[n][2]; 
		for(int i = 0 ; i < n ; i ++) {
			minAndMax[i][1] = (array[i][0]-array[i][1]+1)*(array[i][0]-array[i][1])/2;
			long m = array[i][0]/array[i][1];
			long k = array[i][0]%array[i][1] ;
			minAndMax[i][0] = (m*(m+1))/2*k+(m*(m-1)/2*(array[i][1]-k));
		}
		
		return minAndMax;
	}
}

