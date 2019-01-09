# File		
## 常用的用来访问属性的方法
- canRead();
- canWrite();
- getName();
- getPath();
- getAbsolutePath();
- length();以字节位单位
- exists();
- isDirectory();是否是一个目录
- isFile();是否是一个文件
- renameTo(File f);为文件重命名，或者剪切文件
		
## 常用的方法
- createNewFile();创建一个新的空文件
- delete();删除文件，从内往外删除；不能删除非空文件；
- mkdir();创建目录；
		
## 常用方法
- String[] list();返回指定目录下的所有文件的文件名称组成的数组	
- String[] list(fileNameFilter filter);通过过滤器获取符合条件的文件的名称组成的一个String数组
- File[] listFiles();返回指定目录下的所有文件组成的文件数组
- File[] listFiles(FileNameFilter filter);通过过滤器获取符合条件的文件，返回文件数组
	
## 实现过滤器
1. 匿名内部类：
```java
listFiles(new FileNameFilter(){
	public boolean accept(File dir, String name){
		//主要判断name的规则；
	}
});
```
2. 自定义过滤器：需要实现FileNameFilter接口，重写方法；

## 递归算法获取所有的子文件和目录
- 递归算法：
  - 自己调用自己
  - 递归出口
  - 递归体
    
    