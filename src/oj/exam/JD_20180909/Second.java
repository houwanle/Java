package jd_20180909;
/*对比
 * 现有n个物品，每个物品有三个参数ai,bi,ci,定义i物品不合格品的依据是：
 * 若存在物品j，且aj>ai,bj>bi,cj>ci,则称i物品为不合格品。
 * 现给出n个物品的a,b,c参数，请你求出不合格的数量。
 * 
 * 输入描述
 * 第一行包含一个整数n(1<=n<=500000)表示物品的数量。接下来有n行，每行有三个整数，ai,bi,ci
 * 表示第i个物品的三个参数，1<=ai,bi,ci<=10^9.
 * 输出描述
 * 输出包含一个整数，表示不合格的数量。
 * 
 * 样例输入
 * 3
 * 1 4 2
 * 4 3 2
 * 2 5 3
 * 样例输出
 * 1
 * 
 * 
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Things{
	int a ;
	int b ;
	int c ;
	public Things(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
public class Second {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Things> arr = new ArrayList<Things>();
		int n = sc.nextInt();
		for(int i=0 ; i<n ; i++) {
			Things ts = new Things(sc.nextInt(), sc.nextInt(), sc.nextInt());
			arr.add(ts);
		}		
		Set<Things> s = new HashSet<Things>();
		for(int i = 0; i<arr.size()-1; i++)
			for(int j = i+1 ; j<arr.size();j++ ) {
				if (arr.get(i).a>arr.get(j).a && arr.get(i).b>arr.get(j).b&& arr.get(i).c>arr.get(j).c) {
					s.add(arr.get(j));
				}else if (arr.get(i).a<arr.get(j).a && arr.get(i).b<arr.get(j).b&& arr.get(i).c<arr.get(j).c) {
					s.add(arr.get(i));
				}
			}
		System.out.println(s.size());
	}
}
