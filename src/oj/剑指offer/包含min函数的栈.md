# 包含min函数的栈
## 题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
## AC代码
思路：用一个栈data保存数据，用另外一个栈min保存依次入栈最小的数

比如:
- data中依次入栈：5,4,3,8,10,11,12,1
- 则min依次入栈:5,4,3,no,no,no,no,1
 
no代表此次不如栈

每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则不如栈。
```java
import java.util.Stack;

public class Solution {
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    Integer temp = null;
    public void push(int node) {
        if(temp != null){
            if(node <= temp){
                temp = node;
                min.push(node);
            }
            data.push(node);
        }else{
            temp = node;
            data.push(node);
            min.push(node);
        }
    }
    
    public void pop() {
        int m = data.pop();
        int n = min.pop();
        if(m != n){
            min.push(n);
        }
    }
    
    public int top() {
        int m = data.pop();
        data.push(m);
        return m;
    }
    
    public int min() {
        int n = min.pop();
        min.push(n);
        return n;
    }
}
```