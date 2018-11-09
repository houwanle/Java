package PinDD_20180830;
/*题目描述
    给出被除数和除数，求出循环小数的开始位置（小数点之后的位数）
    和循环长度

    输入描述
    第一行包含两个数字分别是被除数a和除数b(1<=a,b<=1000000).
    输出描述
    输出一行，包含一个两个数字，分别表示循环小数的开始位置和循环体的长度
    （无循环则开始位置为结束位置，长度为0）。

    示例
    输入：
    1 3
    输出：
    0 1

 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int pos = 0;
        int remainder = a % b;
        Map<Integer, Integer> map = new HashMap<>();
        while (remainder != 0) {
            remainder = (remainder * 10);
            if (map.containsKey(remainder)) {

                System.out.print(map.get(remainder));
                System.out.print(" ");
                System.out.print(pos - map.get(remainder));
                return;
            }
            map.put(remainder, pos++);
            remainder %= b;
        }
        System.out.print(pos);
        System.out.print(" ");
        System.out.print(0);
    }
}