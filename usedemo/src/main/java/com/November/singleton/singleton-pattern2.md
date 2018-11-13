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

如果一个项目中有100次获取实例，那么jvm就会有100次进行加锁，释放锁的操作，每次操作都浪费资源。

可以在最外层再加一层判断，如下

~~~java
/**
 * @author sunyang
 * @date 2018/11/12 19:07
 */
public class Singleton41 {
    private static Singleton41 instance;

    private Singleton41(){}

    private static synchronized void doGetInstance(){
        if (null == instance){
            instance = new Singleton41();
        }
    }

    public static synchronized Singleton41 getInstance(){
        if (null == instance){
            doGetInstance();
        }
        return instance;
    }
}
~~~

简化形式后：

~~~java
/**
 * @author sunyang
 * @date 2018/11/12 19:13
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5(){}

    //如果多个线程同时通过第一次检查，并且其中一个线程
    // 首先通过了第二次检查并实例化了对象，那么剩余通过了
    //第一次检查的线程就不会再去实例化对象。提升了效率
    public static Singleton5 getInstance(){
        if (null == instance){
            synchronized (Singleton5.class){
                if (null == instance){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
~~~

> 题外话：一个类在new的时候，一般经历以下三个顺序：
>
> 1.开辟空间
>
> 2.符号引用改空间，并在空间内对类进行初始化操作
>
> 3.将符合引用转为直接引用这个时候if(null==instance) return false;

------------------------------------

>在实际的情况中，为了降低CPU的闲置时间，jvm会对指令进行重排序以形成指令流水线。顺序可能乱序：
>
>1.开辟空间
>
>2.转为直接引用
>
>3.初始化类

结论：双重检查机制就会出现问题：可能返回一个未被完全初始化的类；

代码不安全截图

![1542025736992](C:\Users\sunyang\AppData\Local\Temp\1542025736992.png)

##### volatile单例中的作用

- 可见性：jvm中每一个线程都有自己的内存区域。对变量使用volatile修饰，可以强制将每一次的读写都写入堆内存中，实现了各个线程都能共享的最新数据。
- 禁止指令重排序优化：被volatile修饰的变量，在赋值的结尾会插入一个内存屏障，从而防止指令重排序。volatile增强了数据的一致性。

~~~java
/**
 * 解决上图双重检查机制出现的问题，可能返回一个未被完全初始化的类
 *
 * @author sunyang
 * @date 2018/11/12 20:24
 */
public class Singleton51 {

    private static volatile Singleton51 instance;

    private Singleton51(){}
    public static Singleton51 getInstance(){
        if (null==instance){
            synchronized (Singleton51.class){
                if (null == instance){
                    instance = new Singleton51();
                }
            }
        }
        return instance;
    }
}
~~~

##### 如果实现懒加载

先了解下静态嵌套类的使用

静态嵌套类：是一种在类之外声明的嵌套类，由于是静态的，所以不经过初始化，就可以通过类名直接调用。

内部类：该类作为另一个类的成员，因此只有引用另一个类，才能创建这个类。通过静态嵌套类，便可以实现

对饿汉式进行懒化的效果。

~~~java
/**
 * @author sunyang
 * @date 2018/11/12 20:42
 */
public class Singleton6 {
    private Singleton6(){}
    //静态内部类
    private static class SingletonHolder{
        private static Singleton6 INSTANCE = new Singleton6();
    }

    //通过静态嵌套类，便可以实现对饿汉式进行懒化的效果
    public static final Singleton6 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
~~~

##### 分析

要分析这种方式有没有实现懒加载，就要分析一下语句new Singleton6()是什么时候被调用的.

使用javac进行编译，会得到如下图的三个class文件：

![1542027696077](C:\Users\sunyang\AppData\Local\Temp\1542027696077.png)

从图上可以看到，静态嵌套类是单独作为一个class存在，而其中创建对象的逻辑位于嵌套类中，jvm读取嵌套类的字节码以后才能创建对象，从硬盘中读取class文件，在内存中分配空间，是一件费事费力的工作，所以jvm选择按需加载，没有必要加载的就不加载，没必要分配就不分配。

