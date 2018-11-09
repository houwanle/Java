package HuaWei20180801;

import java.util.Scanner;

/*2、寻找最长连续子串
    给定一串字符，里面有些字符有连续出现的特点，请寻找这些连续出现字符中最长的串，
    如果最长的子串有多个，请输出字符ASCII码最小的那一串。

    输入：
    用cin输入一串字符

    输出：
    用cout输出其中最长的子串

    示例：
    输入：aaabbbbcccccccczzzzzzzz
    输出：cccccccc
    说明：c和z都可选，但c比z的ASCII码小。
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(mostLongSubString(str));
    }

    public static String mostLongSubString(String str) {
        String longStrList="";
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            int len = 1;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                len++;
                i++;
            }
            if(len >= maxLength) {
                if (longStrList != "" && maxLength == len && longStrList.charAt(0) <= str.charAt(i))
                    continue;
                maxLength = len;
                longStrList = "";
                for (int j = 0; j < maxLength; j++)
                    longStrList = longStrList + str.charAt(i);
            }
        }
        return longStrList;

    }
}
