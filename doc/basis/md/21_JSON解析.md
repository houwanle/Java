# JSON
- 一种轻量级的数据交互的格式
- 跨平台、跨网络、跨编程语言
## 作用
作为数据交互

## 解析方式
1. JSON官方
- JSONObject:解析{}
- JSONArray:解析[]
```
String info = "{'name':'zhangsan','age':'20'}";
//String infoArr = "["{'name':'zhangsan','age:'20'}",{"{'name':'zhangsan','age:'20'}"}]";
//处理对象使用JsonObject，数组JsonArray
JSONObject json = new JSONObject(info);
String s = json.getString("name");
		
String str =JsonStr.ObjStrName;
JSONObject jsonPer = new JSONObject(str);
String strPer = jsonPer.optString("person1");
		
JSONObject jsonp1 = new JSONObject(strPer);
String name = jsonp1.optString("name");
int id = jsonp1.optInt("id");
String address= jsonp1.optString("address");
		
Person p1 = new Person();
p1.setAddress(address);
p1.setId(id);
p1.setName(name);
System.out.println(p1);
		
Persons ps = new Persons();
//ps.setPerson1(p1);
System.out.println(ps);
```

2. Gson谷歌
- Gson类的对象方法
- formJson:解析
```
Gson gson = new Gson();
XX xx = gson.fromJson("json数据字符串",xx.class);
new TypeToken<List<Student>>(){}.getType();
```
3. FastJson阿里
- JSON工具类
- parseObject:解析对象
- parseArray:解析数组
```
String json="{'id':12,'type':'藏獒','name':'豆豆'}";
Dog dog=JSON.parseObject(json, Dog.class);

String json1="[{'id':12,'type':'藏獒','name':'豆豆'},
{'id':12,'type':'藏獒','name':'豆豆'}]";

List<Dog> list=JSON.parseArray(json1, Dog.class);
```