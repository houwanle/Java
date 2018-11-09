package PinDD20180805;

/*2、有趣的变换
    字符串形式的正整数（可能包含前缀0,  1<=length<=10），先将这个字符串拆成两部分，
    接着可以在这两部分中分别加入一个小数点也可以不加入，分别形成一个整数或小数，找出
    所有经“拆分”和“变化”两次操作后所有可能组合的数目。
    要求：
    1、对于新形成的整数和小数，不可包含多余的前缀0，比如010和010.1不合法；
    2、对于小数，不可包含多余的后缀0，比如0.10不合法；
    3、.1和1.这样的小数不合法。

    输入：
    输入一行。包含一个字符串形式的正整数。

    输出：
    输出为一行，找出经过“拆分”和“变化”后的所有组合的数目。

    示例
    输入：
    123

    输出：
    4

    说明：
    可能的组合如下：
    [[1, 23], [12, 3], [1.2, 3], [1, 2.3]]

 */

import java.util.HashMap;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        HashMap<String,String> map = new HashMap<String,String>();
        if (str == null || str.length() == 0) {
            System.out.println(count);
            return;
        }
        for (int i = 1; i < str.length(); i++) {
            map.put(str.substring(0,i), str.substring(i,str.length()));
        }
        for (String key : map.keySet()) {
            if (isOk(key) * isOk(map.get(key)) != 0) {
                count = count + isOk(key) * isOk(map.get(key));
            }
        }
        System.out.println(count);
    }

    private static int isOk(String s) {
        if (s.length() == 1) {
            return 1;
        }
        if (s.startsWith("0") || s.endsWith("0")) {
            if (s.startsWith("0") && s.endsWith("0")) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return s.length();
        }
    }
}
