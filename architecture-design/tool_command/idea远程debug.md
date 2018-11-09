#### idea springboot 远程debug配置

### 配置IDEA

##### 1.打开配置，如图

![1541672352635](C:\Users\sunyang\AppData\Local\Temp\1541672352635.png)

##### 2.可以选择默认配置

也可以修改配置，Host和Port自定义

![1541672453107](C:\Users\sunyang\AppData\Local\Temp\1541672453107.png)

##### 3.指定classpath包路径

--------------------------------------------------------------

### 配置启动端

接下来配置，启动jar

~~~shell
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9009 -jar document-api.jar
~~~

![1541672820981](C:\Users\sunyang\AppData\Local\Temp\1541672820981.png)

> 此处有坑

`application.properties`里面的server port的端口一定不能和address一样，防止端口被占用。。

服务启动监听在9001端口了。可以通过以下命令来检查是否监听成功：

~~~shell
netstat -anp | findstr 9001
~~~

查看哪个进程或者程序占用了9001端口：

~~~java
tasklist|findstr "9001"
~~~







