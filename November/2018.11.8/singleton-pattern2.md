### 单例模式引发相关整理

#### 关联线程安全

在多线程下，懒汉式会有一定修改。当两个线程在if(null == instance)语句阻塞的时候，可能由两个线程进入创建实例，从而返回了两个对象。对此，我们可以加锁，保证仅有一个线程处于getInstance（）方法中，从而保证了线程一致性。`多线程下的单例`

~~~java
/**
 * @author sunyang
 * @date 2018/11/8 12:18
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4(){

    }
    //需要加上synchronized 同步
    public static synchronized Singleton4 getInstance(){
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}
~~~



