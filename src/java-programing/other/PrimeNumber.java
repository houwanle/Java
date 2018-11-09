/*
 * 找出闭区间[200,300]中的所有素数，并打印出来；
 */
public class PrimeNumber {
	public static void main(String[] args){
		int i = 200;
		int j = 2;
		for(i = 201; i <= 300;i = i + 2){
			for(j = 2;j < Math.sqrt(i);j++){
				if(i % j == 0){
					break;
				}
			}
			if(j > Math.sqrt(i)){
				System.out.print(i + " ");
			}
		}
	}
}
