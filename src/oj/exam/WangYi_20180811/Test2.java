package WangYi20180811;
/*
    又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
    牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，
    所以他想考考牛牛。
    在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往
    右数第X个苹果是属于哪一堆的。
    牛牛觉得这个问题太简单，所以希望你来替他回答。

    输入描述：
    第一行一个数你（1<=n<=10^5).
    第二行n个数ai（1<=ai<=1000)，表示从左往右数第1堆有多少苹果
    第三行一个数m（1<=m<=10^5),表示有m次询问。
    第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
    输出描述：
    m行，第i行输出第qi个苹果属于哪一堆。

    示例：
    输入：
    5
    2 7 3 4 9
    3
    1 25 11
    输出：
    1
    5
    3

 */

import java.util.Scanner;

public class Test2 {
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) {
            if(i==0)
                a[i]=in.nextInt();
            else
                a[i]=in.nextInt()+a[i-1];
        }

        int m=in.nextInt();
        int qValue=0;
        for(int i=0;i<m;i++) {
            qValue=in.nextInt();
            System.out.println(halfFind(qValue, a)+1);
        }


    }

    //二分查找
    public  static int  halfFind(int q,int a[]) {
        int len=a.length;
        int high=len-1;
        int low=0;
        int mid=(high+low)/2;
        while(low<=high) {
            mid=(high+low)/2;
            if(a[mid]>=q)
            {
                if(mid==0||a[mid-1]<q)
                    return mid;
                high=mid-1;
            }
            else {
                if(mid==len-1||a[mid+1]>=q)
                    return mid+1;
                low=mid+1;
            }
        }
        return -1;
    }

}
