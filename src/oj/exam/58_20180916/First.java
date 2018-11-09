/*
 * 给定一个整数数组，请计算出数组中有几个元素是4的幂。
 * 输入
 * 2,3,4,16
 * 输出
 * 2
 */
import java.util.Scanner;

public class First {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(",");//将输入的数字字符分隔开后，存到str数组中
		int[] arr = new int[str.length];//初始化一个和str数组相同长度的整型数组
		for(int i = 0; i < arr.length; i++){//将字符数组转换为整型数组
			arr[i] = Integer.parseInt(str[i]);
		}
		System.out.println(fun(arr));
	}

	private static int fun(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {//判断数组中的元素是否为4的幂
			/*1、num&(num-1) 判断一个数是否为2的幂数，这个不多说。 
			  2、4的幂级数为1,4,16，即0001，0100,10000，也就是1出现在1,3,5,7。。。。位置上。
			     0x55555555在32位系统里表示0b01010101010101010101010101010101。 
			 */
			if(((arr[i]&(arr[i]-1)) == 0) && arr[i] > 0 && ((arr[i]&0x55555555) != 0)){
				count++;
			}
		}
		return count;
	}
}
