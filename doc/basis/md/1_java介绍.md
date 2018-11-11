# Java 介绍 #
## Java 发展史 ##
- oak:橡树
- Java:爪哇岛：生产咖啡
- java—hot:
    - 95年:诞生1.0版本;
    - 98年:1.2版本;针对的1.0的扩展和修改;
    - 05十周年大会：体系
## Java 体系 ##
- JavaSE:标准版,整个体系的核心;
- JavaEE:企业版,针对的是企业级开发;
- JavaMe:微型版,针对的是移动版和嵌入式;
## Java特性 ##
1. 面向对象的编程语言;
2. 健壮性(吸收了C和C++的优点);
3. 跨平台性(可移植性，jvm虚拟机);
4. 安全性(垃圾回收机制,强制类型检查,取消了指针);

**跨平台**：不同的平台有相应版本的虚拟机，每个虚拟机都屏蔽了底层平台的差别，完成了跨平台;

**jvm虚拟机作用**：执行或者解释java程序;

.java——>编译器（翻译）——>.class(字节码文件)——>虚拟机——>解释给硬件；
字节码文件是提供给jvm虚拟机识别的；

## Java 语言 ##
- 编译型(c)
- 解释型(basic)
- 步骤：
    - 编写源码
	  - 编译字节码
	  - 执行

- **jdk**: Java development kit Java 开发工具集
- **jre**:Java运行时环境

## 安装jdk ##
1. 下一步..
2. 属性->环境变量->系统变量
3. 新建JAVA_HOME 变量值输入java路径
4. 新建CLASSPATH 变量值输入 .;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar
5. 找到PATH 在变量值后面加上 ;%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin
6. 测试 java -version

## Java第一个程序 ##
```java
class Demo1{
	//程序主入口：相当于背包的最外层拉链，想要拿出程序中的内容，就需要这样进去
	//main:jvm只能识别main;主函数被jvm虚拟机调用；
	public static void main(String[] args){
		System.out.println("好好学习，天天向上");
	}
}
```
**class** :用来修饰类的：后续追加类的名字,相当于找一个人需要知道这个人的名字叫什么;

**public static**：都是修饰符
- **public**：公共的：公园  访问最容易；
- **static**：静态 不能动

**main**:主函数的名字：  jvm只能识别该名称（天生一对）；

**String**：
- 字符串：也就是多个文字或者是数字，字母啊构成的一个序列；
	- 标示：""
	- name"zhang" String

**[]**:
- **数组**：把一些数据集体的存起来：100个苹果  盒子

**String[] arrgs**：args代表了这个盒子的名称；

System.out.println();系统打印输出

**特殊格式：**
```java
class Demo2{
	static public void main(String p[]){
		System.out.println("好不好");
	}
}
	static public (互换位置)
```

- 一个Java文件最多有一个public
- class，可以有多个类;
- 如果一个类被public修饰，文件名称需要和类名一致。
