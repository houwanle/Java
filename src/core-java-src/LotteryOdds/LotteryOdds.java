package LotteryOdds;
/**
 * 如果必须从1~50之间的数字中取6个数字来抽奖，那么会有(50*49*48*47*46*45)/(1*2*3*4*5*6)种
 * 可能的结果，所以中奖的几率是1/15890700。祝你好运
 */
import java.util.Scanner;

public class LotteryOdds {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many numbers do you need to draw? ");
		int k = sc.nextInt();
		
		System.out.print("What is the hightest number you can draw? ");
		int n = sc.nextInt();
		
		int lotteryOdds = 1;
		for(int i = 1; i <= k; i++){
			lotteryOdds = lotteryOdds * (n-i+1)/i;
		}
		System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
	}
}
