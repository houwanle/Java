/* 冒泡排序
 * 
 * 输入
 * [34,23,1,3,4,34,2,3]
 * 输出
 * [1, 2, 3, 3, 4, 23, 34, 34]
 * 
 */
import java.util.ArrayList;
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
		bubbleSort(numA);
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < lenA; i++){
			arr.add(numA[i]);
		}
		System.out.println(arr);
	}
	
	private static void bubbleSort(int[] arrays){
        //外层循环是排序的趟数
        for (int i = 0; i < arrays.length-1; i++){
            //每比较一趟就重新初始化为0
            int isChange = 0;

            //内层循环是当前趟数需要比较的次数
            for (int j = 0; j < arrays.length-1-i; j++){
                //前一位与后一位比较，如果前一位比后一位要大，那么交换
                if (arrays[j] > arrays[j+1]){
                    int temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;

                    //如果进到这里面了，说明发生置换了
                    isChange = 1;
                }
            }
            //如果比较完一趟没有发生置换，那么说明已经排好序了，不需要再执行下去了
            if (isChange == 0){
                break;
            }
        }
    }	
}
