/*完全多部图
 * 给定一张包含N个点，M条边的无向图，每条边连接两个不同的点，且任意两点间最多只有一条边。
 * 对于这样的简单无向图，如果能将所有的点划分成若干个集合，使得任意两个同一集合内的点之间
 * 没有边相连，任意两个不同集合内的点之间有边相连，则称该图为完全多部图。现在你需要判断给定的
 * 图是否为完全多部图。
 * 
 * 输入描述
 * 第一行输入一个整数T表示数据组数，1<=T<=10
 * 每组数据格式为：
 * 第一行包含两个整数N和M，1<=N<=1000,0<=M<=N(N-1)/2;
 * 接下来M行，每行包含两个整数X和Y，表示第X个点和第Y个点之间有一条边，1<=X,Y<=N
 * 输出描述
 * 每组输出占一行，如果给定的图为完全多部图，输出Yes，否则输出No
 * 
 * 样例输入
 * 2
 * 5 7
 * 1 3
 * 1 5
 * 2 3
 * 2 5
 * 3 4
 * 4 5
 * 3 5
 * 4 3
 * 1 2
 * 2 3
 * 3 4
 * 样例输出
 * Yes
 * No
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class First {

	static class M {
		public void init() {
			Scanner aa = new Scanner(System.in);
			int J = aa.nextInt();
			for (int JD = 1; JD <= J; JD++) {
				int n = aa.nextInt();
				long m = aa.nextInt();
				int a[][] = new int[n][n];
				for (long i = 0; i < m; i++) {
					int x = aa.nextInt();
					int y = aa.nextInt();
					a[x - 1][y - 1] = 1;
					a[y - 1][x - 1] = 1;
				}
				if (m == 0) {
					System.out.println("Yes");
					continue;
				}
				boolean flag[] = new boolean[n];
				boolean res = true;
				while (true) {
					ArrayList<Integer> list2 = new ArrayList<>();
					int index = -1;
					for (int i = 0; i < n; i++) {
						if (flag[i] == false) {
							index = i;
							break;
						}
					}
					if (index == -1)
						break;
					list2.add(index);
					flag[index] = true;
					for (int i = 0; i < n; i++) {
						if (i != index && flag[i] == false && a[index][i] == 0) {
							list2.add(i);
							flag[i] = true;
						}
					}
					if (!isRight(list2, a)) {
						res = false;
						break;
					}
					list2.clear();
				}
				if (res)
					System.out.println("Yes");
				else
					System.out.println("No");
			}
		}

		public boolean isRight(ArrayList<Integer> list, int a[][]) {
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < a.length; j++) {
					if (list.contains(j)) {
						if (a[list.get(i)][j] == 1)
							return false;
					} else {
						if (a[list.get(i)][j] == 0)
							return false;
					}
				}
			}
			return true;
		}
	}

	public static void main(String[] argsa) {
		new M().init();
	}
}
