package _4399_20180911;
/*
 * 小九设计了一款迷宫游戏，迷宫地图可以看作一个X*Y(X<100,Y<100)的网格，
 * 豆娃(游戏里的角色)要在此网格内从左上角到右下角，只能走格点且只能向右或者向下走。
 * 请设计一个算法，计算豆娃有多少种走迷宫的方法。
 */
import java.math.BigInteger;

public class Second {
	public static void main(String[] args) {
		BigInteger [][]dp = new BigInteger[100][100];
		
		for(int i = 1; i < 100; i++) {
			dp[i][0] = new BigInteger("1");
		}
		for(int j = 1; j < 100; j++) {
			dp[0][j] = new BigInteger("1");
		}
		for(int  i = 1; i < 100; i++) {
			for(int j = 1; j < 100; j++) {
				dp[i][j] = dp[i - 1][j].add(dp[i][j - 1]);

			}
		}
		
		System.out.println(dp[99][99]);
	}
	
}

