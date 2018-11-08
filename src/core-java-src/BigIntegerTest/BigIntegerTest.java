package BigIntegerTest;

import java.math.BigInteger;
import java.util.Scanner;
/**
 * 假设你被邀请参加抽奖活动，并从490个可能的数值中抽取60个，这个程序将会得到中彩概率
 * 1/716395843461995557415116222540092933411717612789263493493351013459481104668848
 * 
 * 输入
 * 60
 * 490
 * 输出
 * Your odds are 1 in 716395843461995557415116222540092933411717612789263493493351013459481104668848. Good luck!
 * 
 * @author lele
 *
 */
public class BigIntegerTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many numbers do you need to draw? ");
		int k = sc.nextInt();
		
		System.out.print("What is the hightest number you can draw? ");
		int n = sc.nextInt();
		
		BigInteger lotteryOdds = BigInteger.valueOf(1);
		
		for(int i = 1; i <= k; i++){
			lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
		}
		System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
	}
}
