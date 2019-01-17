# SQLite数据库
- 数据库：实现数据的持久性存储
- SQLite数据库：（嵌入式）一种轻量级嵌入式数据库  开源  c开发
2000年第一个版本  现在3
## 特点
小，效率高 零成本 支持市场上大多数的操作系统（android IOS）

- SQL: 结构化查询语言，操作数据库的语言
- Lite：简化的

- 数据库： 先有数据库文件.db
  - 数据库表：同一个库中的表名不可重复
    - 列名、字段名、属性、域
	- 数据行
	  		
**同一张表中字段不可重复
不区分大小写**

## 数据库的数据类型
- 整型：int/number/INTEGER
- 浮点型：double
- 字符串：vachar（长度）\nvarchar(设置10个，只用了两个，开辟两个)\text
- 二进制：BLOB	

**SQLite：没有数据类型，根据实际的数据分析类型
注意：在设计数据库时，要带上数据类型，方便数据开发**

## SQLite3的软件命令
命令：以点开头，结尾没有分号
- .help------显示支持的命令
- .open------打开数据库文件，存在打开，不存在新建
- .tables----显示当前数据库中的表名
- .schema----显示当前数据库中的建表语句
- .output---重定向，重新设置显示内容的目的地
- .import 文件名.后缀 表名----将指定的文件内容添加到指定的表中
- .output stdout:将显示数据的目的地重新设置为当前的软件


## SQL语句
1. 建表语句
- 格式：CREATE TABLE <表名>（字段名[约束条件][数据类型],....）
- 约束条件
  - 1).主键：primary key：唯一且不为空
  - 2).not null :不可为null
  - 3).default 值：默认值
```
创建学生表
create table Student(no int primary key,name varchar(10) not null,sex varchar(2),age int);(有分号)
```
2. 新增字段
- 格式： ALTER TABLE<表名> add 字段名称 [数据类型]
```
新增一个班级名称的字段
alter table Student add className varchar(10);
```
**注意：alter语句在SQLite中只支持add**

3. 删除表语句
- 格式：DROP TABLE<表名> drop table Student;

增删改查
4. 新增语句
- 格式：INSERT INTO <表名>[（字段名称），..] values(值1,值2..);
```
添加一名学生
insert into Student(no,name,sex,age) values(16160001,"小花","男",18);
(简写形式)
insert into Student values(1,"小明","女",18);
insert into Student values(2,"小花","女",15);
insert into Student values(3,"小华","男",19);
insert into Student values(4,"小李","男",25);

//查询学生表数据
	select*from Student
```
5. 修改语句
- 格式：UPDATE <表名> SET 字段名称=值，...[where 条件]
```
修改学号为4的年龄
update Student set age=12 where no="4";
修改Student表单中所有数据的className字段的值
update Student set className="android1616";
```
6.删除语句
- 格式： DELETE FROM <表名> [where 条件]
delete from Student where no="3";
```
 .open Test
 create table Dog(id int,type varchar(10),name varchar(10),price double);
 insert into Dog(id,type,name,price) values(1,"腊肠","a",11);
 insert into Dog values(2,"沙皮","b",22);
 insert into Dog values(3,"哈士奇","c",55);
 insert into Dog values(4,"藏獒","d",66);
 
 update Dog set type="中华田园犬" where id=2;
 delete from Dog where id=1;
```
7. 查询语句
- > < != <>：大于 小于 不等于 不等于
- between A and B :在A和B之间连续的
- in (值1，值2 ...) ： 在指定的值
- order by 字段名称 [ASC|DESC]:按照指定的顺序排序(默认升序 ASC)
- limit rowIndex,count:从指定行查询count行，分页
- like:模糊查询  
  - 注意：like在SQLite中不支持中文
  - %：任意个字符 
  - _:一个字符
  - 以A结尾：%A
  - 以A开头：A%
  - 包含A：%A%
- COUNT：计数
	COUNT（no）
- SUM:求和
- MAX：最大
- MIN：最小
- AVG:平均
- group by 字段名称：根据指定的名称进行分组
```
查询对应表中所有的数据
select*from Student
等价于
select no,name,sex,age,className from Student;

查询学生中所有年龄小于15的学生
select * from Student where age<15;
查询学生中年龄不等于20的学生
select * from Student where age!=20
select * from Student where age<>20
select * from Student where age>=20 or age<20;

查询表中年龄不等于16且大于13的学生
select * from Student where age!=16 and age>13;

查询表中年龄15-20的学生
select * from Student where age>=15 and age<=20;
select * from Student where between 15 and 20;

查询年龄12 15 20 的学生
select * from Student age=12 or age=15 or age=20;
select * from Student age in(12,15,20); 

按照年龄进行升序排序
select * from Student order by age;
select * from Student order by age ASC;
按照年龄进行降序排序
select * from Student order by no DESC;

按照年龄升序排序，年龄相同按照学号降序排列
select * from Student order by age,no DESC;

select * from Student;
查询从第一条开始到第二条
select * from Student limit 0,2;

查询年龄以1开头的两个字符
select * from Student where age like "1_";

查询年龄以1开头的任意个数
select * from Student where age like "1%"; 

查询学号以1结尾的
select * from Student where no like "%1";
查询年龄中包含2的
select * from Student where age like "%2%" 

查询Student表中数据的数量  计数 (一般计数主键)
select COUNT(no) from Student;
select COUNT(1) from Student;

select SUM(age),MAX(age),MIN(age) from Student;
select AVG(age) from Student;

查询一下男生和女生的个数,并按性别分组
select COUNT(no) ,sex from Student group by sex;

update Student set age=11 where no=(select no from Student limit 3,1);
```

## JDBC
java 语言规定的操作数据库的接口
各个数据库厂商来具体实现

### 使用步骤
1. 动态加载驱动
```
Class.forName("org.sqlite.JDBC");
```
2. 获取连接对象
```
Connection connection = DriverManager.getConnection("jdbc:sqlite:test.db");
```
3. 获取操作SQL对象
```
Statement statement = connection.createStatement();
```
4. 执行SQL语句
```
statement.executeUpdate("create table if not exists log (id INTEGER primary key,msg varchar(100))");
statement.executeUpdate("insert into Log(msg) values('你好吗')");
```
5. 获取查询结果
```
ResultSet resultSet = statement.executeQuery("select * from Log where msg not null");
while(resultSet.next()){
System.out.println("序号："+resultSet.getInt(1)+",内容 ："+resultSet.getString("msg"));
}
```
6. 关闭









