/*给出两个字符串(字符串由a~z组成)str1,str2,例如abcd，acc，
 * 求将str2修改成str1所需要的次数
 * 
 * 输入
 * abcd
 * acc
 * 输出
 * 3
 * 
 * 备注
 * 插入b,d,删除c
 * 
 */
import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int res = minDistance(str1, str2);
		System.out.println(res);
	}

	private static int minDistance(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int dp[][] = new int[m + 1][n + 1];
		for(int i = 1; i <= m; ++i)
	        dp[i][0] = i;
	    for(int j = 1; j <= n; ++j)
	        dp[0][j] = j;
	    for(int i = 1; i <= m; ++i){
	        for(int j = 1; j <=n; ++j){
	            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
	                dp[i][j] = dp[i - 1][j - 1];
	            }else{
	                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
	            }
	        }
	    }
		return dp[m][n];
	}
}
