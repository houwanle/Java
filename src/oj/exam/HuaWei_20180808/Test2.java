package HuaWei20180808;
/*2、0-1背包问题
    小偷来到了一个神秘的王宫，突然眼前一亮，发现5个宝贝，每个宝贝的价值都不一样，且重量
    也不一样，但是小偷的背包携带重量有限，所以他不得不在宝贝中做出选择，才能使偷到的财富
    最大，请你帮助计算一下。

     输入描述：
     宝贝价值：6,3,5,4,6
     宝贝重量：2,2,6,5,4
     小偷背包容量：10
     输出描述：
     偷到宝贝的总价值：15

     示例
     输入：6,3,5,4,6
     输出：15
 */
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] svalue = scanner.nextLine().split(",");
        String[] sweight = scanner.nextLine().split(",");
        int sum = scanner.nextInt();
        int[] w = new int[svalue.length];
        int[] v = new int[svalue.length];
        for (int i = 0; i < sweight.length; i++) {
            w[i] = Integer.parseInt(sweight[i]);
            v[i] = Integer.parseInt(svalue[i]);
        }
        System.out.println(knapsackOptimal(sum, w, v));
    }

    public static int knapsackOptimal(int c, int[] weight, int[] value) {
        int n = weight.length;
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] G = new int[n + 1][c + 1];
        for (int i = 1; i < n + 1; i++) {
            w[i] = weight[i - 1];
            v[i] = value[i - 1];
        }
        int[] values = new int[c + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int t = c; t >= w[i]; t--) {
                if (values[t] < values[t - w[i]] + v[i]) {
                    values[t] = values[t - w[i]] + v[i];
                    G[i][t] = 1;
                }
            }
        }
        return values[c];
    }
}



