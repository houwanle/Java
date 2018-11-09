/*题目描述
    给定一个字符串str，求其中全部整数数字之和
    输入描述：
    1、忽略小数点，例如“A1.2",认为包含整数1和2；
    2、如果整数的左侧出现字符“-”，则奇数个认为是负整数，偶数个认为是正整数。
    例如“AB-1CD--2EF---3”，认为包含整数-1、2和-3.
    输出描述：
    输出即为字符串中所有整数数字之和
    示例1：
    输入
    AB1CD2E33
    输出
    36
 */
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        char[] ch = string.toCharArray();
        int result = 0;
        boolean flag = false;
        int flags = 1;
        int temp = 0;
        for(int i=0;i<ch.length;i++) {
            if(ch[i]<'0' || ch[i] >='9') {

                if(temp!=0) {
                    result = result + flags*temp;
                    flags = 1;
                }
                if(ch[i] == '-' ) {
                    flags = flags * -1;
                }
                temp = 0;
            }else {
                temp = temp * 10 + ch[i] - '0';
            }
        }
        if(temp!=0) {
            result = result + flags* temp;
        }
        System.out.println(result);
    }
}
