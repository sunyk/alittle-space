### nacos-spring-project项目commit：

![1539938174688](C:\Users\sunyang\AppData\Local\Temp\1539938174688.png)

获取当前毫秒数：System.currentTimeMillis(); 而不是new Date().getTime(); 说明：如果想获取更加精确的纳秒级时间值，用System.nanoTime。在JDK8中，针对统计时间等场景，推荐使用Instant类

~~~java
public class TimeMillisDemo {
        public static void main(String args[]) {
            // Positive example:
            long a = System.currentTimeMillis();
            // Negative example:
            long b = new Date().getTime();
    
            System.out.println(a);
            System.out.println(b);
        }
    }
~~~

