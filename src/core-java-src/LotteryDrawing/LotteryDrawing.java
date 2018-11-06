package LotteryDrawing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 产生一个抽彩游戏中的随机数值组合。假如抽彩是从49个数值中抽取不重复的6个，那么程序可能的输出结果为？
 * @author lele
 *
 */
public class LotteryDrawing {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many numbers dou you need to draw? ");
		int k = sc.nextInt();
		
		System.out.print("What is the hightest number you can draw? ");
		int n = sc.nextInt();
		
		int[] numbers = new int[n];
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = i + 1;
		}
		
		int[] result = new int[k];
		for(int i = 0; i < result.length; i++){
			int r = (int)(Math.random() * n);
			result[i] = numbers[r];
			numbers[r] = numbers[n-1];
			n--;
		}
		Arrays.sort(result);
		System.out.println("Bet the following combination. It'll make you rich!");
		for(int e : result){
			System.out.println(e);
		}
				
				
	}
}
