/*矩阵观察与输出
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
查看下面4*4矩阵的规律，打印出N*N矩阵的结果 (2<=N<=100)

10 9 8 7
11 2 1 6
12 3 4 5
13 14 15 16

输入
输入正整数N，  N可以去2到100之间的任意整数

输出
如题干中的形式打印结果矩阵， 元素之间一个空格，每行顶头开始打印

样例输入
5
样例输出
25 24 23 22 21
10 9 8 7 20
11 2 1 6 19
12 3 4 5 18
13 14 15 16 17
 * 通过率：100%
 */
 import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int[][] nums = generateMatrix(h);
		for(int i=0;i<nums.length;i++) {
			for(int j = 0; j<nums[i].length;j++) {
				if(j==nums[i].length-1) {
					System.out.print(nums[i][j]);
				}else {
				System.out.print(nums[i][j]+" ");
				}
			}
			System.out.println();
		}
	}

	public static int[][] generateMatrix(int n) {
		 int[][] nums = new int[n][n];
			int[] post = { 0, 1, 0, -1 }; // 控制 x y 下一次加的方向
			int nowx = 0, nowy = 0, i = 1; // 开始 x y 的方向
			int x,y; 
			if(n%2==0) {
				x = y = n-1;
			}else {
				x = y = 0;
			}
			
			boolean flag = false; // 可以通过 这个 控制 输出的顺序
			i = n * n;
			while (i > 0) {
				if (x + post[nowx] >= n || y + post[nowy] >= n || x + post[nowx] < 0 || y + post[nowy] < 0
						|| nums[x + post[nowx]][y + post[nowy]] != 0) { // 出现转弯的情况 x y 交替 转
					if (flag == true) { // x 转弯
						nowx = (nowx + 1) % 4;
						flag = false;
					} else {
						nowy = (nowy + 1) % 4;
						flag = true;
					}
				} else {
					x = x + post[nowx];
					y = y + post[nowy];
					nums[x][y] = i;
					i--;
				}
					
			}
			return nums;
	}
}

===============================================================================================================================

import java.util.Scanner;

public class First {
    private int n; //
    private int a[][]; // 声明一个矩阵
    private int value = 1;// 矩阵里数字的值
 
    public First(int i) {
        this.n = i;
        a = new int[n][n];
    }
 
    // 计算第m层左上角的数字
    private int getcorner(int m) {
        int corner = 1;
        int o = n - 1;
        for (int i = 0; i < m - 1; ++i) {
            corner += 4 * o;
            o = o - 2;
        }
        return corner;
    }
 
    // 生成矩阵的每一层的每一边的数
    // s表示4个方向，分别取值1,2,3,4，表示4个不同的方向。
    // o表示这条边的起始值。
    // x表示第m层每条边的数字个数
    private void side(int s, int o, int x, int m) {
        int i = 0;
        int j = 0;
        switch (s) {
        case 1:
            i = m - 1;
            j = m - 1;
            for (int k = 0; k < x; ++k) {
                a[i][j + k] = value;
                ++value;
            }
 
            break;
        case 2:
            i = m - 1;
            j = m - 1 + x;
            for (int k = 0; k < x; ++k) {
                a[i + k][j] = value;
                ++value;
            }
            break;
        case 3:
            i = m - 1 + x;
            j = m - 1 + x;
            for (int k = 0; k < x; ++k) {
                a[i][j - k] = value;
                ++value;
            }
            break;
        case 4:
            i = m - 1 + x;
            j = m - 1;
            for (int k = 0; k < x; ++k) {
                a[i - k][j] = value;
                ++value;
            }
            break;
        }
    }
 
    // 生成蛇形矩阵的第m层
    private void shell(int m)// m表示第m层
    {
        int x = n - 1 - (m - 1) * 2; // x表示第m层每条边的数字个数
        int o = getcorner(m);
        int o1 = o;
        int o2 = o1 + x;
        int o3 = o2 + x;
        int o4 = o3 + x;
        // System.out.println(o4);
 
        side(1, o, x, m);
        side(2, o, x, m);
        side(3, o, x, m);
        side(4, o, x, m);
    }
 
    // 生成蛇形矩阵
    public void snakeMatrix() {
        int m = (n + 1) / 2;// 计算一共有多少层
        for (int i = 1; i <= m; ++i) {
 
            shell(i);
        }
        if (n % 2 == 1) {
            a[n / 2][n / 2] = n * n;
        }
 
    }
 
    // 打印矩阵
    public void print() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (a[i][j] < 10) {
                    System.out.print(a[i][j] + "  ");
                } else {
                    System.out.print(a[i][j] + " ");
                }
 
            }
            System.out.println();
        }
    }
 
    public static void main(String args[]) {
        First my = new First(new Scanner(System.in).nextInt());  //利用Scanner获取控制台输入
        my.snakeMatrix();
        my.print();
    }
}

/*
输入
4
输出
1  2  3  4  
12 13 14 5  
11 16 15 6  
10 9  8  7  


