### 单例模式整理

> 敲了多年代码后，回头来看会别有一番滋味在心头。。

#### 概念

单例模式是为了保证在一个jvm环境下，一个类仅有一个对象。

代码中常见的懒汉式。饿汉式，这些实现方式可以通过代码的设计来强制保证的单例，也可以通过文档，通过编码约束，可以认为是一个类仅有一个对象。

#### 代码场景

项目中被封装到底层的连接功能的类，数据库连接，socket连接，具有配置功能的类，工具类，辅助系统类，会需要使用单例模式。这些类的特点：是创建和销毁需要消耗大量的系统资源，或者不需要创建多个对象。

#### 实战

单例1，饿汉式

~~~java
/**
 * 最常见的单例，有两个必不可少的东西
 * 1.私有化类的所有构造函数，以阻止其他代码在该类的外界去创建对象
 * 2.提供获取对象的静态方法，以返回类唯一的对象引用
 *
 * @author sunyang
 * @date 2018/11/6 18:44
 */
//单例1，通过类的静态变量来持有一个该类的对象的引用，同时使用final关键字来阻止被再次赋值
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    public Singleton1() {
    }

    public static Singleton1 getINSTANCE() {
        return INSTANCE;
    }
}
~~~

单例2，饿汉式

~~~java
/**
 * 单例2，是使用静态变量维护该类的引用，但是要将对象创建放在静态代码块中
 *
 * @author sunyang
 * @date 2018/11/6 18:49
 */
public class Singleton2 {
    private static final Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    public Singleton2() {
    }

    public static Singleton2 getInstance(){
        return INSTANCE;
    }


}
~~~

单例3，懒汉式

~~~java
/**
 * 单例3，使用静态变量维持类的对象引用，在获取对象的方法中对象进行判断和创建
 *
 * @author sunyang
 * @date 2018/11/6 18:59
 */
public class Singleton3 {
    public static Singleton3 instance;

    private Singleton3(){

    }

    private static Singleton3 getInstance(){
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }

}
~~~

#### 分析

单例1和单例2，将对象创建放在类的初始化阶段，单例3则是将对象的创建放在类的使用阶段。

所以，单例1和单例2称为饿汉式，单例3称为懒汉式。优缺点：

饿汉式的优点是简单易懂，缺点是没有达到懒加载的效果。如果整个`生命周期`中自始至终未使用过这个实例，就会比较浪费连接资源和内存。

懒汉式并不复杂，可以起到懒加载的效果。于是，实际开发中更愿意使用懒汉式，因为节省内存，懒加载。



#### 联想

##### 类的生命周期：

###### 1.类的加载：

将类的字节码文件`.class`从硬盘载入方法区的过程

###### 2.类的连接：

该过程由三个部分组成：验证、准备和解析

###### 3.类的初始化：

将静态变量赋值，执行的顺序就是，

父类静态变量->静态代码块->子类静态变量->子类静态代码块

> 饿汉式的对象创建在这个阶段

###### 4.类的使用：

类的实例化，懒汉式的对象创建处于这个阶段，new关键字可以触发该生命周期

###### 5.类卸载

#### 验证

~~~java
/**
 * 如果验证？
 * 根据类的五个生命周期阶段，我们只需要验证在创建对象之前的
 * 那些操作能够触发类的初始化就行。
 *
 * @author sunyang
 * @date 2018/11/8 11:13
 */
public class ValidSingleton1 {
    /**
     * 首先在构造方法里添加打印语句，打印"init"
     * 再添加静态方法和一个静态变量
     *
     */
    private static final ValidSingleton1 INSTANCE = new ValidSingleton1();

    //打印init
    public ValidSingleton1() {
        System.out.println("init");
    }

    public static ValidSingleton1 getINSTANCE() {
        return INSTANCE;
    }
    //静态方法
    public static final void otherMethod(){

    }
    //静态变量
    public static final int staticField = 0;
}
~~~

开始验证

~~~java
/**
 * @author sunyang
 * @date 2018/11/8 11:26
 */
public class ValidSingletonDemo {

    public static void main(String[] args) {
        System.out.println("---------------------start");
        /*1.验证单例1,只声明，不会触发类的初始化阶段
        ValidSingleton1 validSingleton1 = null;
        if (null == validSingleton1){
            System.out.println("singleton1 is null");
        }*/
        /*//2.调用类的静态变量
        System.out.println(ValidSingleton1.staticField);*/

        //3.调用类的静态方法
//        ValidSingleton1.otherMethod();
        //4.初始化两次
        ValidSingleton1 validSingleton1 = new ValidSingleton1();
        //5.直接调用
//        ValidSingleton1.getINSTANCE();
        System.out.println("---------------------end");

        /**
         * -------start-------
         * singleton1 is null
         * -------end---------
         *
         * ---------------------start
         *  0
         *   ---------------------end
         *
         *   ---------------------start
         *  init
         *  ---------------------end
         *
         *  ---------------------start
         *  init
         *  init
         *  ---------------------end
         *
         *
         *  ---------------------start
         * init
         * ---------------------end
         */
    }
}
~~~

从输出上看，调用类的静态方法以下，会触发类的初始化阶段。

发现饿汉式，是不会产生线程安全的问题；

在设计上，懒汉式要优于饿汉式

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



