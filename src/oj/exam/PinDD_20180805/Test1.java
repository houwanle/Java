/*1、旋转的字符串
    给定一个字符串，按顺时针顺序输出为一个正方形，具体规则如下；
        1.从上边开始，上边从左到右
        2.然后到右边，右边从上到下
        3.然后是下边，下边从右到左
        4.最后是左边，左边从下到上
    输入：
    输入一行，包含4K（K为整数，1<=K<=10）个小写字母。
    输出：
    输出K+1行，按上面的规则输出正方形，正方形内部用空格填充。
    示例：
    输入：
    abdcefghijklmnop
    输入：
    abcde
    p   f
    o   g
    n   h
    mlkji
 */
import java.util.Scanner; 
 
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printSquare(str);
    }

    public static void printSquare(String str) {
        int flag = 0;
        if (str.length()%4 != 0) {
            return;
        }
        int k = str.length()/4 + 1;
        char a[][] = new char[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0;j < k; j++) {
                a[i][j] = ' ';
            }
        }
        for (int i = 0; i < k; i++) {
            a[0][i] = str.charAt(flag);
            flag++;
        }
        for (int i = 1; i < k; i++) {
            a[i][k-1] = str.charAt(flag);
            flag++;
        }
        for (int i = k-2; i >= 0; i--) {
            a[k-1][i] = str.charAt(flag);
            flag++;
        }
        for (int i = k-2; i > 0; i--) {
            a[i][0] = str.charAt(flag);
            flag++;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
