package PinDD_20180830;
/*题目描述
    现在给出N个长度都为L的单词。单词中仅包含大写英文字母（A-Z）。
    你可以从这些单词中的第一个字母中挑一个作为你拼词的第一个字母，
    所有单词的第二个字母中挑一个作为你拼词的第二个字母...
    以此类推。
    比如给出 N=3 个L=4的单词：
    CAKE
    TORN
    SHOW
    你可以（但不限于）拼出以下单词：
    CORN
    SAKE
    CHRE
    但你不能拼出：
    KARE（因为N个单词中没有首字母为K的）
    问：按照上述规则拼出一个与输入的N个单词都不相同的单词。若无法拼出
    则输出"-"。若有超过一个符合条件的单词，则输出字典序最小的那一个单词
    数据范围：
    1<=N<=2000
    1<=L<=10

    输出描述：
    输出占一行，仅包含一个字符串，表示题目要求的单词（若找不到这样的单词，
    则按题目表述输出"-").

    示例
    输入
    3 4
    COKE
    TARN
    SHOW
    输出
    CAKE

 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        sc.nextLine();
        char[][] chars = new char[l][n];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String tmp = sc.nextLine();
            set.add(tmp);
            for (int j = 0; j <l ; j++) {
                chars[j][i] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < l; i++) {
            Arrays.sort(chars[i]);
        }

        char[] res = new char[l];

        if( getHelp(chars, set, 0, res)) return;
        System.out.println("-");

    }

    private static boolean getHelp(char[][] chars, HashSet<String> set, int start, char[] res) {
        if(start==res.length){
            if (!set.contains(String.valueOf(res))) {
                System.out.println(String.valueOf(res));
                return true;
            }
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            res[start] = chars[start][i];
            if(getHelp(chars,set,start+1,res)==true) return true;
        }
        return false;
    }

}
