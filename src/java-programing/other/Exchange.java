//不用第三个变量交换两个变量的值的几种方法
public class Exchange {
	public static void main(String[] args){
		int a = 5;
		int b = 3;
		System.out.println("a,b的初始值为：a = " + a + " b = "+ b);
		
		//方法一
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a + " " + b);
		
		//方法二
		a = a + b -(b = a);
		System.out.println(a + " " + b);
		
		//方法三
		a = a * b;
		b = a / b;
		a = a / b;
		System.out.println(a + " " + b);
		
		//方法四
		a = a * b/(b=a);
		System.out.println(a + " " + b);
		
		//方法五
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + " " + b);
	}
}
