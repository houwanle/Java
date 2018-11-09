//寻找数组中的最大值和最小值
public class MaxMin {
	static int Max;
	static int Min;
	public static void main(String[] args){
		int[] arr = {7,3,19,40,4,7,1,0};
		GetMaxAndMin(arr);
		System.out.println("max = " + Max);
		System.out.println("min = " + Min);
	}
	
	private static void GetMaxAndMin(int[] arr) {
		Max = arr[0];
		Min = arr[0];
		for(int i = 1; i < arr.length-1; i+=2){
			if(i + 2 == arr.length-1){
				if(arr[i+2] > Max)
					Max = arr[i+2];
				if(arr[i+2] < Min)
					Min = arr[i+2];
			}
			
			if(arr[i] > arr[i+1]){
				if(arr[i] > Max)
					Max = arr[i];
				if(arr[i+1] < Min)
					Min = arr[i+1];
			}
			
			if(arr[i] < arr[i+1]){
				if(arr[i] < Min)
					Min = arr[i];
				if(arr[i+1] > Max)
					Max = arr[i+1];
			}
		}
	}
}
