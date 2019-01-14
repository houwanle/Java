# HTTP协议
超文本传输协议 目前互联网中使用范围最广泛的通信协议
## 常用的方式
### HttpURLConnection
#### 使用步骤：[GET]
1. 创建URL对象
```
URL url = new URL("地址");
```
2. 创建连接对象
```
HttpURLConnection conn = url.openConnction();
```
3. 设置请求属性或请求参数
```
conn.setRequestMethod("GET");
```
4. 连接
```
conn.connect();
```
5. 验证状态响应码
```
if(conn.getResponseCode==200)
```
6. 获取服务响应信息
```
conn.getInput();
conn.getOutput();
```
7. 关闭

#### 使用步骤：[POST]
1. 创建URL对象
```
URL url = new URL("地址");
```
2. 创建连接对象
```
HttpURLConnection conn = url.openConnction();
```
3. 设置请求属性或请求参数
```
conn.setRequestMethod("POST");
conn.setDoOutput(true);
conn.setDoInput(true);
```
4. 连接
```
conn.connect();
BufferedWriter bw = new BufferedWriter(new OutputStream(conn.getOutputStream));
bw.write（）;
```
5. 验证状态响应码
```
if(conn.getResponseCode==200)
BufferedReader
```
6. 获取服务响应信息
```
conn.getInput();
conn.getOutput();
```
7. 关闭

### okHttp
#### 使用步骤
1. 创建客户端对象
```
OkHttpClient client = new OkHttpClient();
```
2. 创建请求内容对象(POST)
```
FormBody.Builder build = new FormBody.Builder();
build.add();
RequsetBody body = build.build();
```
3. 创建请求对象
```
Request request = new Requst.Bulider().url("").post(body).build();
```
4. 创建响应对象(执行请求)
```
Response response = client.newCall(request).excute();
```
5. 验证是否成功
```
if(response.isSuccess)
```
6. 获取响应结果
```
response.body.string;
```

