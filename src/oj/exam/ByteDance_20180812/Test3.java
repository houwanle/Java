package ByteDance20180812;

import java.util.Scanner;

/*积分卡牌游戏
    小a和小b玩一个游戏，有n张卡牌，每张上面有两个正整数x,y。
    取一张牌时，个人积分增加x，团队积分增加y。
    求小a，小b各取若干张牌，使得他们的个人积分相等，且团队积分最大。

    输入描述：
    第一行n
    接下来n行，每行两个正整数x,y.
    输出描述：
    一行一个整数
    表示小a的积分和小b的积分相等时，团队积分的最大值

    示例
    输入;
    4
    3 1
    2 2
    1 4
    1 4
    输出：
    10
    备注：
    数据范围：
    0<n<100
    0<x<1000
    0<y<1e6
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pv[] = new int[n + 1];
        int[] cv = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            pv[i] = sc.nextInt();
            cv[i] = sc.nextInt();
        }
        int OFFSET = 100000;
        int[][] dp = new int[n+1][20000];
        for (int i = -100000; i < 100000; i++) {
            dp[0][i + OFFSET] = Integer.MIN_VALUE;
        }
        dp[0][0 + OFFSET] = 0;

        for (int i = 1; i < n+1; i++) {
            for (int j = -100000; j < 100000; j++) {
                int temp1 = Integer.MIN_VALUE;
                int temp2 = Integer.MIN_VALUE;
                //放在第一堆
                if (j - pv[i] > -100000 && dp[i - 1][j - pv[i] + OFFSET] != Integer.MIN_VALUE) {
                    temp1 = cv[i] + dp[i - 1][j + OFFSET - pv[i]];
                }

                //放在第二堆
                if (j + pv[i] < 100000 && dp[i - 1][j + pv[i] + OFFSET] != Integer.MIN_VALUE) {
                    temp2 = cv[i] + dp[i - 1][j + OFFSET + pv[i]];
                }
                if (j == 19) {
                    System.out.println("j==39 i=" + i);
                }
                if(temp1<temp2) temp1 = temp2;
                if(temp1<dp[i-1][j+OFFSET]) temp1 = dp[i - 1][j+OFFSET];
                dp[i][j+OFFSET] = temp1;
            }
        }
        System.out.println(dp[n][OFFSET]);
    }

}
