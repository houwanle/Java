package ByteDance20180825;

import java.util.Scanner;

/*题目描述
    双生词是指满足如下条件的两个字符串：（假设两个字符串分别为S和S')
        1.字符串S与S'长度相同
        2.将字符串S首尾相接绕成环，再选一个位置切开，顺时针或逆时针
          能够得到字符串S'
    容易得到，若S与S'为双生词，则S'与S也为双生词。
    给定一批仅由英文小写字母组成的字符串，询问他们之中是否存在双生词。

    输入描述：
    首先给出测试组数t,表示一共有多少组数据。
    对于每组数据，第一行为一个整数n，表示一共有多少个字符串。接下来n
    行，每行一个字符串。
    输出描述
    对于每组数据，若存在双生词，输出Yeah。若不存在双生词，输出Sad。

    示例
    输入：
    3
    2
    helloworld
    hdlrowolle
    2
    helloworld
    worldhello
    2
    abcde
    acbde
    输出
    Yeah
    Yeah
    Sad

    备注：
    对于40%的数据，n<1000
    对于100%的数据，1<=t<=10,n<100000,字符串长度在1~32之间。

 */
//通过率40%
public class Test3 {
    public static void main(String[] args) {
        int m = 0;
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(in.nextLine());
            String[] temps = new String[m];
            for (int j = 0; j < m; j++) {
                temps[j] = in.nextLine();
            }
            result[i] = isShuang(temps);

        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static String isShuang(String temps[]) {
        if (temps == null || temps.length < 1) {
            return "Sad";
        }
        for (int i = 0; i < temps.length; i++) {
            for (int j = i+1; j < temps.length; j++) {
                if (isShuang(temps[i], temps[j]).equals("Yeah")) {
                    return "Yeah";
                }
            }
        }
        return "Sad";
    }

    private static String isShuang(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return "Yeah";
        }

        if (str1.length() == str2.length() && str1.length() == 0) {
            return "Yeah";
        }

        if (str1.length() != str2.length()) {
            return "Sad";
        }
        StringBuffer temp = new StringBuffer(str1);
        StringBuffer tmp = new StringBuffer();
        for (int i = 0; i < str1.length(); i++) {
            tmp.append(temp.substring(i, str1.length()));
            tmp.append(temp.substring(0, i));
            if (tmp.toString().equals(str2) || tmp.reverse().toString().equals(str2)) {
                return "Yeah";
            }
            tmp.delete(0, tmp.length());
        }

        return "Sad";

    }

}
