package ZhiZheSiHai_20180902;
/*题目名称：括号的使用
  时间限制：1000ms

  题目描述：判断一段文本中()的使用是否正确的，正确的含义是左右成对，不多不少
  如"IS LIUKAN(SH)AN IN(ZHI()HU)" 正确
    "()(())(())" 正确
    "((LIUKANSHAN(IS HERE((" 不正确
    "()((" 不正确

  输入描述：
  输入一行包含括号的字符串str。
  (1<=strlen(str)<=1000)
  输出描述：
  输出True/False

  示例
  输入
  IS LIUKAN(SH)AN IN(ZHI()HU)
  输出
  True

 */
import java.util.Scanner;
import java.util.Stack;

public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char [] chs = str.toCharArray();

        Stack<Character> st = new Stack<>();
        for(char ch : chs) {
            if(ch == '(') {
                st.push('(');
            }
            if(ch == ')') {
                if(!st.isEmpty()) {
                    st.pop();
                }else {
                    System.out.println("False");
                    return;
                }
            }
        }
        if(st.empty()) {
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
