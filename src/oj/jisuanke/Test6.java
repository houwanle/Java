package test;

/*
小米是一个幼儿园老师，每学期的泥塑课上，她都会给每个学生发不超过 250立方厘米的等量橡皮泥，教大家做泥塑。
在上课过程中，她发现每个班都恰好有一个小朋友会去抢另一个小朋友的橡皮泥，于是她决定，在正式开始做泥塑前，
让大家把手里的橡皮泥都捏成一个立方体，并且测量手里捏好的橡皮泥的长、宽和高。
这样，她就可以知道谁被谁抢了橡皮泥了。

输入格式
小米老师在不同的学期可能会带一个班或者同时带多个班，因此输入数据可能有一组或者多组。
每组输入数据的第一行为一个整数 n，表示了这个班的小朋友数，之后 n行每行包括了由空格分隔的三个整数和一个字符串，
那个字符串表示了小朋友的名字，前面三个整数则是这个学生手里橡皮泥块的长、宽、高数据。按照幼儿园的规定，
每个班最多有 9个小朋友，最少也要有 2个小朋友，每个小朋友在学籍系统中的名称不超过 8个字符长。
当出现一个班级的小朋友数为 -1时，表示没有更多的班级了。
输出格式
输出行数与小米老师带的班级数相同，形式为X took clay from Y.，具体请参考样例输出。

样例输入
3
10 10 2 Jill
5 3 10 Will
5 5 10 Bill
4
2 4 10 Cam
4 3 7 Sam
8 11 1 Graham
6 2 7 Pam
-1
样例输出
Bill took clay from Will.
Graham took clay from Cam.

 */
import java.util.Scanner;

class Student{
	int len;
	int wid;
	int hig;
	int vol;
	String name;
	
	public Student(int len, int wid, int hig, String name) {
		super();
		this.len = len;
		this.wid = wid;
		this.hig = hig;
		this.name = name;
		this.vol = len*wid*hig;
	}
}

public class Test6 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n == -1){
				break;
			}
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int k1 = 0;
			int k2 = 0;
			
			Student[] stu = new Student[n];
			for(int i = 0; i < n; i++){
				stu[i] = new Student(sc.nextInt(),sc.nextInt(), sc.nextInt(), sc.next());
				if(stu[i].vol > max){
					max = stu[i].vol;
					k1= i;
				}
				if(stu[i].vol < min){
					min = stu[i].vol;
					k2 = i;
				}
			}
			System.out.println(stu[k1].name + " took clay from " + stu[k2].name + ".");
		}
	}
}