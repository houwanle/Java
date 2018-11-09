package ByteDance20180825;

import java.util.Scanner;

/*题目描述
    我们定义合法的标识符为：数字0-9组成的字符串。（可以包含多个前导0）
    定义合法的表达式为：
        1.若X为合法的标识符，则X为合法的表达式
        2.若X为合法的表达式，则X为合法的表达式
        3.若X和Y均为合法的表达式，则X+Y，X-Y均为合法的表达式
    如，以下均合法的表达式：1,100,1+2，（10），1-（3-2）
    以下为不合法的表达式：(,-1,1+-2
    给定长度n，求长为n的合法表达式的数目。长为n的合法表达式可能有非常多，
    你只需输出结果对1000000007取模的余数即可。

    输入描述：
    一个整数n
    输出描述：
    长为n的合法表达式的数目对1000000007取模的余数

    示例
    输入
    1
    输出
    10

    备注：
    对于40%的数据，n<=10
    对于100%的数据，0<=n<=1000

 */

//通过率20%
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int count = 0;
        n = in.nextInt();
        if (n == 0)
            count = 0;
        else {
            int sign = (n - 1) / 2;
            for (int i = sign; i >= 0; i--) {
                count += get_num(i, n);
                count = count % 1000000007;
            }
        }
        // cout <<jiecheng(0, 0)<<endl;
        System.out.println(count);
    }

    static int jiecheng(int x, int n) {
        int sum = 1;
        while ((n--) != 0) {
            sum *= x--;
            sum = sum % 1000000007;
        }
        return sum;
    }

    static int c_m_n(int m, int n) {
        return jiecheng(m, n) / jiecheng(n, n);
    }

    static int brack_num(int brack, int num) {
        int sum = 0;
        for (int i = num; i >= 1; --i)
            sum += i;
        sum = (int) Math.pow(sum, brack);
        return sum;
    }

    static int get_num(int sign, int n) {

        int count = 0;
        int loc_num = sign + 1;
        int temp_num = 0;
        int brack = (n - sign - loc_num) / 2;
        for (int i = 0; i <= brack; ++i) {
            temp_num = n - sign - 2 * i;
            // cout << i <<temp_num << endl;
            // count += c_m_n(temp_num-1,loc_num-1) * pow(10, temp_num) * pow(2, sign) *
            // brack_num(i, sign+loc_num);
            int temp = c_m_n(temp_num - 1, loc_num - 1) * (int) Math.pow(10, temp_num) % 1000000007;
            temp = temp * (int) Math.pow(2, sign) % 1000000007;
            temp = temp * brack_num(i, sign + loc_num) % 1000000007;
            count += temp;
            count %= 1000000007;
        }
        return count;
    }

}
