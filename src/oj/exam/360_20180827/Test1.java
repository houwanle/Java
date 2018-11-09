/*城市修建
  时间限制：C/C++语言 1000MS；其他语言 3000MS
  内存限制：C/C++语言 65536KB；其他语言 589824KB
  题目描述;
  有一个城市需要修建，给你N个民居的坐标X,Y,把这么多民居全都包进城市的话，城市
  所需最小面积是多少（注意,城市为平行于坐标轴的正方形）

  输入
  第一行为N，表示民居数目（2<=N<=1000)
  下面为N行，每行两个数Xi，Yi，表示该居民的坐标(-10^9<=Xi,Yi<=10^9)
  输出
  城市所需最小面积

  样例输入
  2
  0 0
  2 2
  样例输出
  4
  补充样例
  输入样例2
  2
  0 0
  0 3
  输出样例2
  9
 */

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        int temp_x = 0;
        int temp_y = 0;
        for(int i=0;i<n;i++) {
            temp_x = in.nextInt();
            max_x = max_x<temp_x?temp_x:max_x;
            min_x = min_x>temp_x?temp_x:min_x;

            temp_y = in.nextInt();
            max_y = max_y<temp_y?temp_y:max_y;
            min_y = min_y>temp_y?temp_y:min_y;

        }
        System.out.println((int)Math.pow(Math.max(max_x, max_y)-Math.min(min_x, min_y),2));
    }
}
