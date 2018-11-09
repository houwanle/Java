package ByteDance20180825;

import java.util.Scanner;

/*题目描述
    一天，小凯同学震惊的发现，自己屋内的PM2.5指标是有规律的！小凯采样了PM2.5
    数值，发现PM2.5数值以小时为周期循环，即任意时刻的PM2.5总是和一小时前相等！
    他的室友小文同学提出了这样一个问题，在t小时的内的所有采样点中，选取若干采样
    点的数值，能否找到一个PM2.5不曾下降过的序列？这个序列最长是多少？

    输入描述：
    第一行有两个整数n和t，表示每小时的采样点个数，和询问多少小时的结果。
    第二行有n个整数，以空格分隔，表示一个小时内，每个采样点观测到的PM2.5
    数值。

    输出描述：
    一个整数，表示T小时内，最长的PM2.5不曾下降过的序列的长度。

    示例
    输入
    4 3
    10 3 7 5
    输出
    4

    说明
    3小时内的所有采样点为
    10 3 7 5 10 3 7 5 10 3 7 5
    选取第2,3,5,9个采样点，可以得到一个不曾下降过的序列
    3 7 10 10
    使用其他的方法也可以得到长为4的满足条件的序列但无法得到长度超过4的结果。

    备注：
    对于20%的数据，t=1
    对于50%的数据，t<=1000
    对于80%的数据，PM2.5数值不超过200
    对于100%的数据，1<=n<=1000,1<=t<=1000000,PM2.5数值为正整数，且不超过
    1000000000

 */

//通过率50%
public class Test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] number = new int[n];
        for(int i=0;i<n;i++) {
            number[i] = in.nextInt();
        }
        int cnt = 1;
        int[] numbers = new int[m*n];
        for(int i=0;i<m*n;i++) {
            numbers[i] = number[i%n];
            cnt++;
        }
        int rr = lis(numbers);
        System.out.println(rr);
    }

    public static int lis(int[] number) {
        int max;//记录当前对应的最大长度
        int ans = 0;//记录总共的最大长度
        for (int i = 1; i < number.length; i++) {
            max = 0;//对应该ch[i]开始时，总是要初始化max
            for (int j = ans; j >= 0; j--) {
                if (number[i] >= number[j]) {//找到比ch[i]小的
                    max = j + 1;//j代表的是ch[j]对应最大上升子序列的长度，加1也就是在该子序列后面再加ch[i]
                    ans=ans>max?ans:max;//如果ch[i]对应的长度大于ans,就赋值给ans
                    break;
                }
            }
            if( max==ans || number[i]<number[max])//max==ans表示当前得到的是最长的子序列，直接存下来就好了。否则得到的不是最长的，就要和之前的比较，存较小的。
                number[max]=number[i];
        }
        return ans+1;//下标加1才是长度。
    }

}
