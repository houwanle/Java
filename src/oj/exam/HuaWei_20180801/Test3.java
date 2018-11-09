package HuaWei20180801;
import java.util.Scanner;
/*3、广告牌选址问题
    已知某小镇的房子沿直线分布，给定一个有序整型数组arr，里面每个值代表小镇每栋房子
    的一维坐标点。现在需要建N个广告牌，广告牌只能建在这些坐标点上，使得每个坐标点离
    广告牌的总距离最短，请返回这个最短的总距离。

    输入：
    1、1<=N<=arr的长度；
    2、每个坐标点以最近的广告牌距离作为该坐标点离广告牌的距离；
    3、输入中最后一个为N值，其余为arr值，需要考生自行处理；

    输出：
    输出为所有坐标点离广告牌的最短总距离

    示例：
    输入
    1 2 3 4 5 1000 2
    输出
    6

    说明：arr=[1,2,3,4,5,1000]，N=2。第一个广告牌在3位置，第二个广告牌在1000的
    位置。这样arr上的点到广告牌位置分别为2、1、0、1、2、0，总距离为6，没有任何方案
    的总距离更短，故返回6。
 */
public class Test3 {
    public static int minDistances(int[] arr, int num) {
        if(arr == null || num < 1 || arr.length < num) {
            return 0;
        }
        int[][] w = new int[arr.length+1][arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                w[i][j] = w[i][j-1] + arr[j] - arr[(i+j)/2];
            }
        }
        int[][] dp = new int[num][arr.length];//动态规划数组
        int[][] s = new int[num][arr.length];
        for (int j = 0; j != arr.length; j++) {
            dp[0][j] = w[0][j];
            s[0][j] = 0;
        }
        int minK = 0;
        int maxK = 0;
        int cur = 0;
        for (int i = 1; i < num; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                minK = s[i-1][j];
                maxK = j == arr.length - 1 ? arr.length - 1 : s[i][j+1];
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = minK; k <= maxK; k++) {
                    cur = dp[i-1][k] + w[k+1][j];
                    if (cur <= dp[i][j]) {
                        dp[i][j] = cur;
                        s[i][j] = k;
                    }
                }
            }
        }
        return dp[num - 1][arr.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length-1];
        for (int i = 0; i < strs.length-1; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        int num = Integer.valueOf(strs[strs.length-1]);
        System.out.println(minDistances(arr,num));
    }
}
