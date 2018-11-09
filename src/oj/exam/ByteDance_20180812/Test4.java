package ByteDance20180812;

import java.util.*;


/*
    两个长度为n的序列a,b,问有多少个区间[l,r]满足
    max(a[l,r])<min(b[l,r])即a区间的最大值小于b
    区间的最小值
    数据范围：
    n<1e5
    ai,bi<1e9

    输入描述：
    第一行一个整数n
    第二行n个数，第i个为ai
    第三行n个数，第i个为bi
    输出描述：
    一行一个整数，表示答案

    示例
    输入：
    3
    3 2 1
    3 3 3
    输出：
    3
 */
/*public class Test4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=in.nextInt();
        for(int i=0;i<n;i++)
            b[i]=in.nextInt();
        int sumCount=0;
        for(int i=1;i<=n;i++) {
            sumCount+=countOfragion(a, b, i, n);
        }
        System.out.println(sumCount);
    }


    public static int countOfragion(int a[],int b[],int k,int n) {
        int count=0;
        Deque<Integer> dqa=new ArrayDeque();
        Deque<Integer>  dqb=new ArrayDeque();
        for(int i=0;i<k;i++) {
            if(dqa.isEmpty()) dqa.addLast(i);
            else {
                while(!dqa.isEmpty()&&a[dqa.getLast()]<a[i])
                    dqa.removeLast();
                dqa.addLast(i);

            }
            if(dqb.isEmpty()) dqb.addLast(i);
            else {
                while(!dqb.isEmpty()&&b[dqb.getLast()]>b[i])
                    dqb.removeLast();
                dqb.addLast(i);
            }
        }
        if(a[dqa.getFirst()]<b[dqb.getFirst()]) count++;
        for(int i=1;i<=n-k;i++) {

            while(!dqa.isEmpty()&&a[dqa.getLast()]<a[i+k-1])
                dqa.removeLast();
            dqa.addLast(i+k-1);
            if(dqa.getFirst()<i) dqa.removeFirst();
            while(!dqb.isEmpty()&&b[dqb.getLast()]>b[i+k-1])
                dqb.removeLast();
            dqb.addLast(i+k-1);
            if(dqb.getFirst()<i) dqb.removeFirst();
            if(a[dqa.getFirst()]<b[dqb.getFirst()]) count++;
        }
        return count;
    }
 }*/

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        System.out.println(getNum(a, b,n));
    }

    private static int getNum(int[] a, int[] b,int n) {
        int start = 0, res = 0;
        Deque<Integer> aqueue = new LinkedList<>();
        Deque<Integer> bqueue = new LinkedList<>();
        int min=0, max=0;
        for (int i = 0; i < n;i++ ) {
            //若a[i]不小于b[i],清空队列，从新的序列开始
            if(a[i]>=b[i]) {
                aqueue.clear();
                bqueue.clear();
                continue;
            }
            //只有一个值的区间的个数加1
            res++;
            //若是新的序列刚开始，队列为空的时候，当前值进队列，并设置为最大最小值，并且总的值加1.
            if(aqueue.isEmpty()&&bqueue.isEmpty()) {
                start=i;
                aqueue.add(i);
                max=a[i];
                bqueue.add(i);
                min=b[i];
                continue;
            }

            //队列根据顺序依次存储大于/小于对首的值的索引，队首是最小/最大值的索引。
            if(a[i]<max)  aqueue.add(i);
            else {
                aqueue.clear();
                aqueue.add(i);
            }
            if(b[i]>min)  bqueue.add(i);
            else {
                bqueue.clear();
                bqueue.add(i);
            }
            min = b[bqueue.getFirst()];
            max = a[aqueue.getFirst()];

            //如果max不比min小了，可能有两种情况，一种是a[i]比b队列的队首大。一种是b[i]比a队的队首小。
            if(max>=min) {
                //当a[i]比b队列的队首大时，从b队的队首开始，逐个寻找新的比a[i]大的值作为b队队首，并把这个索引设置为新的start.
                if(a[i]==max) {
                    bqueue.removeFirst();
                    while(!bqueue.isEmpty()&&b[bqueue.getFirst()]<=max)
                        bqueue.removeFirst();
                    start=bqueue.getFirst();

                }
                //当b[i]比a队的队首小时，从a队的队首开始，逐个寻找新的比b[i]小的值作为a队队首，并把这个索引设置为新的start.
                else {//b[i]==min的情况
                    aqueue.removeFirst();
                    while(!aqueue.isEmpty()&&a[aqueue.getFirst()]>=min)
                        aqueue.removeFirst();
                    start=aqueue.getFirst();
                }
                res+=i-start;
            }
            else {
                res+=i-start;
            }
        }
        return res;
    }


}
