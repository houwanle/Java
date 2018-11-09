/* 迷宫问题
 以一个M×N的长方阵表示迷宫，0和1分别表示迷宫中的通路和障碍。设计一个程序，
 对任意设定的迷宫，求所有路径数目。迷宫入口（0,0），出口（row-1，col-1）
	（1）    根据二维数组，输出迷宫的图形。
	（2）    探索迷宫的四个方向：RIGHT为向右，DOWN向下，LEFT向左，UP向上，输出从入口到出口的行走路径。
 * 
 */
import java.text.ParseException;
import java.util.Scanner;

public class Second {
	static int res = 0;

	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int col = in.nextInt();
		int a[][] = new int[row][col];
		int b[][] = new int[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				a[i][j] = in.nextInt();
		dfs(a, 0, 0, row, col, b);
		System.out.println(res);
	}

	public static void dfs(int a[][], int i, int j, int row, int col, int b[][]) {
		if (i == row - 1 && j == col - 1) {
			res++;
			return;
		}
		if (i >= row || j >= col || i < 0 || j < 0 || a[i][j] == 1 || b[i][j] == 1)
			return;
		b[i][j] = 1;
		dfs(a, i - 1, j, row, col, b);
		dfs(a, i + 1, j, row, col, b);
		dfs(a, i, j - 1, row, col, b);
		dfs(a, i, j + 1, row, col, b);
		b[i][j] = 0;
	}
}
