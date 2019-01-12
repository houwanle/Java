# TCP、IP
## 网络编程
- IP：定位网络中的计算机 32位，常常看到的是十进制
- 端口：具有网络功能的软件的标识
- TCP/IP协议：传输控制协议/网际协议是目前网络应用范围最广泛的传输协议之一

## TCP的特点
1. 面向连接(三次握手)
2. 客户端-服务端
3. 每次传输没有大小限制
4. 数据相对安全，但是效率低

## java中使用TCP的步骤
1. 创建服务器套接字对象(ServerSocket)
ServerSocket ss = new ServerSocket();
2. 创建套接字对象(服务器监听)(Socket)
Socket socket = ss.accept();
3. 创建对应的流
BufferedReader
BufferedWriter
4. 操作数据
5.关闭