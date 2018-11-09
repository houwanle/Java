/*
 * 局长有N种食物，每种食物有Ai份。
       每天局长会吃一份食物，或者买一份食物（即每天只能进行吃或买其中的一种动作），这样过了M天
       现在局长想知道M天后第p种食物的份数排名（从大到小，相同算并列，例如3 3 2，则排名为1 1 3）
   N,M,P<=100,Ai<=1000

       输入描述
      第一行N M P
      第二行N个数Ai
      接下来M行，每行A i或者B i分别表示买一份食物i，吃一份食物i
      输出描述
      一个答案

      输入
  3 4 2
  5 3 1
  B 1
  A 2
  A 2
  A 3
     输出
  1
 */
import java.util.*;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); 
        int p = sc.nextInt();
        rank(sc, n, m, p);
    }

	private static void rank(Scanner sc, int n, int m, int p) {
		int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) 
            count[i] = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            String[] str = sc.nextLine().split(" ");
            if(str[0].charAt(0)=='A') 
            	count[Integer.parseInt(str[1])]++;
            else  
            	count[Integer.parseInt(str[1])]--;
        }

        int r = 1;
        for (int i = 1; i <= n; i++) {
            if(count[i] > count[p]) 
            	r++;
        }
        System.out.println(r);
	}
}
