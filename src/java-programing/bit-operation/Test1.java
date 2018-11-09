/*
 * 利用移位操作实现乘法运算
 */
public class Test1 {
	public static void main(String[] args){
		System.out.println("3乘以8 = " + powerN(3,3));
		System.out.println("3乘以16 = " + powerN(3,4));
	}

	private static int powerN(int m, int n) {
		for(int i = 0; i < n; i++ ){
			m = m << 1;
		}
		return m;
	}
}
