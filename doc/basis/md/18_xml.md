# XML
一个跨平台、跨网络的跨程序的数据描述方式，可以方便数据交换，系统配置；

## XML的解析
### PULL解析：谷歌
#### 常量
- 0---开始文档
- 1---结束文档
- 2---开始标签
- 3---结束标签
- 4---文本内容

#### 解析步骤
1. 根据数据创建类
2. 创建解析工厂
3. 创建解析器
4. 设置解析数据源
5. 开始解析
	手动循环进行解析
6. 获取结果

```
//1.创建工厂
XMLPullPaserFactory factory = XMLPullPaserFactory.newInstance();

//2.获取解析器
XmlPullParser parser = factory.newPullParser();
		
//3.获取要解析的文件
parser.setInput(new InputStreamReader(new FileInputStream("Pull.xml"),"utf-8"));

//4.不同的事件,只要获取到的事件常量不等于END_DOCUMENT,一直解析读取；
//获取当前的事件常量
int event = parser.getEventType();
Student stu = null;
String tagName = "";
String value = "";
List<Student>list = new ArrayList<>();

//5.开始解析，只要！=
while(event!= XmlPullParser.END_DOCUMENT){
switch (event) {

case XmlPullParser.START_DOCUMENT:
break;

case XmlPullParser.START_TAG:
if(parser.getName().equals("Student")){//获取节点
stu = new Student();
}
System.out.println(parser.getName());
tagName = parser.getName();	
break;
				
case XmlPullParser.TEXT:
if(tagName.equals("name")){
stu.setName(parser.getText());
}
if(tagName.equals("id")){
stu.setId(Integer.parseInt(parser.getText()));
}
if(tagName.equals("age")){
stu.setAge(Integer.parseInt(parser.getText()));
}
if(tagName.equals("sex")){
stu.setSex(parser.getText());
}
break;

case XmlPullParser.END_TAG:
if(parser.getName().equals("Student")){
list.add(stu);
}
tagName = "";
break;

default:
break;
}
//告诉当前事件，开始下一个
event = parser.next();
}
		
System.out.println(list);
```

### SAX解析：SUN
以事件通知自动调用对应的方法
#### 解析步骤
1. 根据数据创建类
2. 创建自定义DefaultHandler类的子类并重写对应的方法
3. 创建解析工厂
4. 创建解析器
5. 创建自定义DefaultHandler类的子类对象
6. 开始解析
7. 获取解析结果
```
SAXPaserFactory factory = SAXPaserFactory.newInstance();
SAXPaser paser = factory.newSAXPaser();
StudentHandler dh = new StudentHandler();
paser.parse(new File(".xml"),dh);
dh.getXX
```