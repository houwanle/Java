# Java结构&String
## 结构
- 顺序结构
- 判断结构
- 选择结构
- 循环结构

### 判断结构
- 语句1.

if（判断语句）{执行语句}
	如果判断语句返回true，则执行执行语句
- 语句2.
- 
if(){}
	else{}
		
**【String 比较用.equals（）比较内容  ==比较的是内存地址】**

### 选择结构

#### 格式
```java
switch（答案）{
    case 常量：break；
    case 常量：break；
    ...
    default：break；
}
```
- case：相当于一个选项
- switch（）：括号用来放自己的选项
- break：终止结束

#### 支持的数据类型
- 基本数据类型：byte short int char
- String	enum 枚举

#### 特殊格式
```java
switch(答案){
    case 常量：
    case 常量：
    ...
    case 常量： break;
```

#### 执行顺序
- 不管default在前还是在后，都会先执行case，
- case语句不符合才执行default；

### 循环结构
- while
- do..while无论是否符合条件，都会至少执行一次
链接数据库

- for
- foreach

**什么情况下使用while？**

在不清楚具体的循环次数的情况下使用

**break:终止当前的循环**

**contunie：终止本次循环**

//指定一个幸运的数字（随机），猜大小
如果猜的数字比幸运数字大则输出太大了
否则太小了，直到找到这个数字

获取0-9之间的随机数字
	random>0<1
	random*10	//double 值

## String常用方法
- **new String(bytes, offset, length);**
将bytes数组转换成字符串，从offset开始，总共的长度是length；
- **charAt(int index);** 返回对应索引值位置的字符
- **concat(String str);** 将str追加到原字符串的末尾
- **contains(String s);** 判断是否包含指定的s;
- **equals(Object obj);** 比较两个字符串的内容是否相同
- **equalsIgnoreCase(Object obj);** 忽略大小写比较两个字符串是否相同
- **indexof(String s):** 返回s第一次出现的索引值
- **lastIndexof(String s):** 返回s最后一次出现的索引值
- **toCharArray();** 将字符串转换为char数组
- **getBytes();** 将字符串转换为byte数组 
- **toLowerCase(String s);** 将字符串s转换为小写
- **toUpperCase(String s):** 将s转换为大写
- **subString(int begin);** 从begin开始，默认到末尾
- **subString(int start,int end);** 从start开始，到end-1结束
- **endsWith(String str);** 判断是否以指定的str结尾
- **startsWith(String str);** 是否以执行的str开头
- **trim();** 去除字符串两端的空格
- **replace(char old,char new);** 将old替换成new;
- **split(String s);** 以s分割字符串
- **compareTo(String s);** 比较字符串，返回对应的int值，如果大于0，在后面，小于0在前面，只有在相同的时候返回0
- **isEmpty();** 判断字符串是否为空
- **format(string s,date...d);** 格式化字符串，通常用来限制：让一个小数只保留两位小数；

String str = new String("123");

"123"--->字符串池：1个
new----》堆内存：2个

**String的值不能改变的，每次改变都会在内存中生成一个新的数据对象；**

**StringBufferStringBuilder和String的区别？**

都有缓冲区，在修改数据的时候，可以直接在后面追加或者直接删除某些数据，不会重新生成；
	

**StringBuffer和StringBuilder的 区别？**	
- Buffer：安全，效率低
- Builder：不安全，效率高
	
insert,append,revers