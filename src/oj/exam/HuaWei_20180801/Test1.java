package HuaWei20180801;

import java.util.Scanner;

/*1、找出重复字符串
    找出输入字符串中的重复字符，再根据ASCII把重复的字符从小到大排序。

    输入：
    一个长度不超过100的字符串

    输出：
    排序后的字符串

    示例：
    输入：ABCABCdd
    输出：ABCd

 */
public class Test1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] arr = new int[128];
        for (char ch : str.toCharArray()) {
            arr[ch]++;
        }

        StringBuffer bf = new StringBuffer();
        for(int i = 0; i < arr.length; i++){
            if (arr[i] >= 2) {
                bf.append((char)i);
            }
        }
        System.out.println((bf.toString()));
    }
}
