# 链表中倒数第k个结点
## 题目描述
输入一个链表，输出该链表中倒数第k个结点。
## 解题思路
设置两个指针，让其中一个指针比另一个指针先前移k-1步，然后两个指针同时往前移动。循环直到先行的指针的值为NULL时，另一个指针所指的位置就是所要找的位置。
```java
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k < 1)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i = 0; i < k-1 && p1 != null;i++)//前移k-1步
            p1 = p1.next;
        if(p1 == null){
            return null;
        }
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
```