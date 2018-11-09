//两个大数的乘法
public class BigDataCount {
	public static void main(String[] args){
		long[] arr = new long[100];
		arr[arr.length-1] = 8;
		arr[arr.length-2] = 8;
		arr[arr.length-3] = 8;
		arr[arr.length-4] = 8;
		arr[arr.length-5] = 8;
		long count = 88888888;
		arr = getCount(arr, count);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
		}
	}
	
	public static long[] getCount(long[] arr,long c){
		for(int i = 0; i < arr.length; i++){
			arr[i] = arr[i] * c;
		}
		
		for(int i = arr.length-1;i > 0;i--){
			arr[i-1] += arr[i]/10;
			arr[i] %= 10;
		}
		return arr;
	}
}
