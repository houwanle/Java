# 最小的k个数
## 题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
## 解题思路
- 冒泡排序的思想
  - 最外层循环K次就可以了，也就是说不用全部排序，只挑出符合提议的K个就可以。
```java
import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (k > input.length) {
            return al;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            al.add(input[input.length - i - 1]);
        }
        return al;
    }
}
```
- 基于堆的解法
  - 创建大小为k的数组，基于堆排序的原理来设计数组为最大堆
```java
import java.util.*;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
        while(input==null || k<=0 || k>input.length)
            return leastNumbers;
        int[] numbers=new int[k];  //用于放最小的k个数
        for(int i=0;i<k;i++)
            numbers[i]=input[i];//先放入前k个数
        for(int i=k/2-1;i>=0;i--){
            adjustHeap(numbers,i,k-1);//将数组构造成最大堆形式
        }
        for(int i=k;i<input.length;i++){
            if(input[i]<numbers[0]){ //存在更小的数字时
                numbers[0]=input[i];
                adjustHeap(numbers,0,k-1);//重新调整最大堆
            }
        }
        for(int n:numbers)
            leastNumbers.add(n);
        return leastNumbers;
    }

    //最大堆的调整方法，忘记时可以复习一下堆排序。
    private void adjustHeap(int[] arr,int start,int end){
        int temp=arr[start];
        int child=start*2+1;
        while(child<=end){
            if(child+1<=end && arr[child+1]>arr[child])
                child++;
            if(arr[child]<temp)
                break;
            arr[start]=arr[child];
            start=child;
            child=child*2+1;
        }
        arr[start]=temp;
    }
}
```
