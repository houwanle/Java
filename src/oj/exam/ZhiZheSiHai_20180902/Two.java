package ZhiZheSiHai_20180902;
/*题目名称：求并集
  时间限制：1000ms

  题目描述
  输出两个单向有序链表的并集 如链表A{1->2->5->7},
  链表B{3->5->7->8} 输出：{1->2->3->5->7->8}.
  (测试用例仅做参考，我们会根据代码质量进行评分)

  输入描述：
  第一行输入整数n,m(1<=n,m<=1000)分别表示两个链表
  长度。
  第二行给出A链表所包含元素。(1<=a<=1000)
  第三行给出B链表所包含元素。(1<=b<=1000)
  输出描述：按题目描述输出。

  示例
  输入
  4 4
  1 2 5 7
  3 5 7 8
  输出
  1->2->3->5->7->8

 */
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < m + n; i ++) {
            set.add(sc.nextInt());
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int x : set) {
            if(flag) {
                sb.append(String.valueOf(x));
                flag = false;
            }else {
                sb.append("->");
                sb.append(String.valueOf(x));
            }
        }
        System.out.println(sb.toString());
    }
}
