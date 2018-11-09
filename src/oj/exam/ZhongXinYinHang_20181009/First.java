/* 格雷码是一种二进制数值系统。在一组数的编码中，任意两个相邻的代码只有一位二进制数不同。
 * 给定一个非负整数n表示格雷码的位数，输出所有格雷码。格雷码序列从0开始。格雷码不唯一。
 
输入
2
输出
00
01
11
10
 */
import java.util.*;

public class First {
    public static void main(String[] args)  {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int maxsize = 1 << n;

        for(int i = 0; i < maxsize; ++i)
        {
            int t=i ^ (i >> 1);
            for(int j = n; j > 0; --j) {
                int temp=t>>j-1;
                System.out.print(temp&1);
            }
            System.out.println();
        }
        return ;
    }
}
