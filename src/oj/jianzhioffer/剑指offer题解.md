# 剑指offer题解
* [1. 二维数组中的查找](#1.-二维数组中的查找)
* [2. 替换空格](#2.-替换空格)
* [3. 从尾到头打印链表](#3.-从尾到头打印链表)
## 1. 二维数组中的查找
### 题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
### 解题思路
从右上角开始查找。矩阵中的一个数，它左边的数都比它小，下边的数都比它大。因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间。
### AC代码
```java
public class Solution {
	public boolean find(int target, int[][] array) {
		boolean found = false;
		int lie = array[0].length;
		int hang = array.length;
		int column = lie - 1;
		int row = 0;
		while (hang > row && column >= 0) {
			int value = array[row][column];// 0,2 3
			if (target > value) {
				row++;
			} else if (target < value) {
				column--;
			} else {
				found = true;
				break;
			}
		}
		return found;
	}
}
```

## 2. 替换空格
### 题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
### AC代码
```java
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	if(str == null)
			return null;
		StringBuffer sBuffer = new StringBuffer();
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i)== ' '){
				sBuffer.append('%');
				sBuffer.append('2');
				sBuffer.append('0');
				
			}else{
				sBuffer.append(str.charAt(i));
			}
		}
		return sBuffer.toString();
    }
}
```
## 3. 从尾到头打印链表
### 题目描述
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
### 解题思路
#### 使用栈
```java
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
```

#### 使用递归
```java
import java.util.ArrayList;
public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead(listNode.next);
			list.add(listNode.val);
		}
		return list;
    }
}
```
#### 使用Collections.reverse()
```java
import java.util.*;

public class Solution {
    ArrayList<Integer> ret = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        while (listNode != null) {
            ret.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(ret);
        return ret;
    }
}
```