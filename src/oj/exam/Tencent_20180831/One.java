package Tencent_20180831;
/*
    小Q有X首长度为为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌
    组成一个总长度正好为K的歌单，每首歌最多只能在歌单中出现一次，在不考虑
    歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。

    输入描述
    每个输入包含一个测试用例
    每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)
    接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量
    x(x<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100),保证A不等于B。
    输出描述：
    输出一个整数，表示组成歌单的方法取模。因为答案可能会很大，输出对10000000
    取模的结果。

    示例1
    输入
    5
    2 3 3 3
*/
import java.util.Scanner;
public class One {
    static  int mod=1000000007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k=in.nextInt();
        int A=in.nextInt();
        int x=in.nextInt();
        int B=in.nextInt();
        int y=in.nextInt();
        long dp[][]=permutation(100);
        System.out.println(CountOfOption(A, x, B, y, k, dp));


    }

    public static  long CountOfOption(int A,int x,int B,int y,int k,long[][] dp) {
        long count=0;
        for(int i=0;i<=x;i++)
            if(i*A<=k&&(k-i*A)%B==0&&(k-i*A)/B<=y)
                count=(count+(dp[x][i]*dp[y][(k-i*A)/B])%mod)%mod;
        return count;
    }


    public static long[][]  permutation(int n) {
        long dp[][]=new long[n+1][n+1];
        for(int i=1;i<=n;i++) {
            dp[i][0]=1;
            dp[i][i]=1;
            for(int j=1;j<i;j++)
                dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%mod;
        }
        return dp;

    }
}
