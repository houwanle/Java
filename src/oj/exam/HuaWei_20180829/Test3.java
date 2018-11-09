package HuaWei_20180829;
/*题目描述
    一个农夫饲养了一批怪物牛，他发现这批牛的繁殖能力惊人，
    一对牛每月繁殖一对小牛。每对小牛在出生后，需要花三个月
    时间来生长，第四个月开始繁殖。

    输入描述
    第一行输入N，表示N组数据
    第二行开始，输入N组数据，每组数据两行：分别为M(1<=M<=100)
    对牛，第N(1<=N<=50)个月
    输出描述
    输出N组数据的结果，每组结果占一行
    假设怪物牛不存在死亡的情况，计算开始初始数量为M(1<=M<=100)
    对牛的情况下，第N(1<=N<=50)个月牛的总数（对）。

    示例
    输入
    2
    1
    1
    1
    6
    输出
    2
    10
 */

import java.util.Scanner;
public class Test3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++) {
            a[i][0]=in.nextInt();
            a[i][1]=in.nextInt();
        }
        for(int i=0;i<n;i++) {
            System.out.println(coungOfcow(a[i][0], a[i][1]));
        }
    }

    public static int coungOfcow(int m,int n) {
        int temp0=m;
        int temp1=0;
        int temp2=0;
        int temp3=0;
        int temp=0;
        for(int i=1;i<=n;i++) {
            temp=temp3;
            temp3=temp2;
            temp2=temp1;
            temp1=temp0;
            temp0+=temp;
        }
        return temp0+temp1+temp2+temp3;
    }
}
