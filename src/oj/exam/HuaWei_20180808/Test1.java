package HuaWei20180808;
/*1、大小写字母转化
   输入任意个字符串，将其中的小写字母变为大写，大写字母变为小写，其他字符不用处理；

    输入描述：
    任意字符串：abcd12#%XYZ
    输出描述：
    输出字符串：ABCD12#%xyz

    示例
    输入：abcd12#%XYZ
    输出：ABCD12#%xyz

 */

import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char array[] = string.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (Character.isUpperCase(ch)) {
                array[i] = Character.toLowerCase(ch);
            }else if (Character.isLowerCase(ch)) {
                array[i] = Character.toUpperCase(ch);
            }
        }
        System.out.println(new String(array));
    }
}

