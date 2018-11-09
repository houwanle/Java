/*
给定一个长度为n的整数数组 A 。
假设Bk是数组A顺时针旋转k个位置后的数组，我们定义 A 的“旋转函数” F 为：
F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
计算F(0), F(1), ..., F(n-1)中的最大值。

注意:
可以认为 n 的值小于 105。

示例:
A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 */
import java.util.Scanner;

public class Second {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		int lindex1 = s1.indexOf('[');
		int rindex1 = s1.indexOf(']');
		String sA = s1.substring(lindex1 + 1, rindex1);
		String strA[] = sA.split(",");
		int lenA = strA.length;
		
		int numA[] = new int[lenA];
		for(int i = 0; i < lenA; i++){
			if(i < lenA)
				numA[i] = Integer.parseInt(strA[i]);
		}
		System.out.println(maxRotateFunction(numA));
	}
	
    public static int maxRotateFunction(int[] A) {
        int n = A.length;
        //假设不旋转下的f0的值
        int f0 = 0;
        //当顺序位移一位后，抛出变成0的那个，那么整体增加的
        int sumOfA = 0;
        for(int i=0;i<n;i++){
            f0 += A[i] * i;
            sumOfA += A[i];
        }
        int max = f0;
        int fi = f0;
        //开始考虑旋转的
        for(int i=1;i<n;i++){
            //旋转后，所有加1
            fi += sumOfA;
            //上一回合的 最后一个需要减去n个(原来n-1 刚刚又加了一个)
            fi -= n * A[ n -i ];
            max = Math.max(max,fi);
        }
        return max;
    }
}
