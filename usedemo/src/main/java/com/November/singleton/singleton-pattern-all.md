### 那些年蓦然回首单例模式

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

如果一个项目中有100次获取实例，那么jvm就会有100次进行加锁，释放锁的操作，每次操作都浪费资源。

可以在最外层再加一层判断，如下

```java
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
```

简化形式后：

```java
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
```

> 题外话：一个类在new的时候，一般经历以下三个顺序：
>
> 1.开辟空间
>
> 2.符号引用改空间，并在空间内对类进行初始化操作
>
> 3.将符合引用转为直接引用这个时候if(null==instance) return false;

------

> 在实际的情况中，为了降低CPU的闲置时间，jvm会对指令进行重排序以形成指令流水线。顺序可能乱序：
>
> 1.开辟空间
>
> 2.转为直接引用
>
> 3.初始化类

结论：双重检查机制就会出现问题：可能返回一个未被完全初始化的类；

代码不安全截图

![Alt](https://img2018.cnblogs.com/blog/612682/201811/612682-20181114135032509-1733190840.png)

##### volatile单例中的作用

- 可见性：jvm中每一个线程都有自己的内存区域。对变量使用volatile修饰，可以强制将每一次的读写都写入堆内存中，实现了各个线程都能共享的最新数据。
- 禁止指令重排序优化：被volatile修饰的变量，在赋值的结尾会插入一个内存屏障，从而防止指令重排序。volatile增强了数据的一致性。

```java
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
```

##### 如果实现懒加载

先了解下静态嵌套类的使用

静态嵌套类：是一种在类之外声明的嵌套类，由于是静态的，所以不经过初始化，就可以通过类名直接调用。

内部类：该类作为另一个类的成员，因此只有引用另一个类，才能创建这个类。通过静态嵌套类，便可以实现

对饿汉式进行懒化的效果。

```java
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
```

##### 分析

要分析这种方式有没有实现懒加载，就要分析一下语句new Singleton6()是什么时候被调用的.

使用javac进行编译，会得到如下图的三个class文件：

![alt](https://img2018.cnblogs.com/blog/612682/201811/612682-20181114135048559-1705134876.png)

从图上可以看到，静态嵌套类是单独作为一个class存在，而其中创建对象的逻辑位于嵌套类中，jvm读取嵌套类的字节码以后才能创建对象，从硬盘中读取class文件，在内存中分配空间，是一件费事费力的工作，所以jvm选择按需加载，没有必要加载的就不加载，没必要分配就不分配。

### 单例模式引发相关整理

#### 如何破坏单例模式

示例：

```java
/**
 * 如果破坏单例模式
 *
 * @author sunyang
 * @date 2018/11/13 20:14
 */
public class Singleton7 {
    private Singleton7(){
        System.out.println("Singleton7");
    }
    private static final class SingletonHolder{
        SingletonHolder(){
            System.out.println("SingletonHolder");
        }
        private static final Singleton7 INSTANCE = new Singleton7();
    }
    public static Singleton7 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
```

测试得出结果

```java
/**
 * @author sunyang
 * @date 2018/11/13 20:18
 */
public class Test {

    /**
     * ----------------------start-------------
     *Singleton7
     * -----------------------end---------------
     *
     */
    public static void main(String[] args) {
        System.out.println("----------------------start-------------");
        Singleton7.getInstance();
        System.out.println("-----------------------end---------------");
    }
}
```

上图的单例，最主要的一步是将构造方法私有化，从而外界无法new对象。但是java的反射可以强制访问private修饰的变量，方法和构造函数，如图

```java
/**
 * @author sunyang
 * @date 2018/11/13 20:31
 */
public class ReflectTest {

    /**
     * Singleton7
     * Singleton7
     * 反射获取构造器和直接获取构造器，比较是否同一个：false
     */

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Class<Singleton7> singleton7Class = Singleton7.class;
        Constructor<Singleton7> constructor = singleton7Class.getDeclaredConstructor();
        constructor.setAccessible(true);
        //反射获取构造函数
        Singleton7 singleton1 = constructor.newInstance();

        Singleton7 singleton2 = Singleton7.getInstance();

        System.out.println("反射获取构造器和直接获取构造器，比较是否同一个：" + (singleton1 == singleton2));

    }
}
```

##### 联想

java中的四种创建对象的方式

| type         | explan                                                       |
| ------------ | ------------------------------------------------------------ |
| new          | 需要调用构造函数                                             |
| reflect      | 需要调用构造函数，免疫一切访问权限的限制public，private等    |
| clone        | 需要实现Cloneable接口，分浅复制，深层                        |
| Serializable | 1.将对象保存在硬盘中 2.通过网络传输对象，需要实现Serializable |

单例模式，是不能抵抗反射，clone，序列化的破坏的。

#### 如何保护单例模式

思路：

对于clone和序列化，可以在设计的过程中不直接或间接的去实现Cloneable和Serializable接口即可。

对于反射，可以通过在调用第二次构造函数的方式进行避免。

尝试解决代码：

```java
/**
 * 保护单例模式测试demo
 *
 * @author sunyang
 * @date 2018/11/14 10:32
 */
public class ReflectTestProtect {
    public static void main(String[] args) {
        try {
            Class<Singleton7Protect> clazz = Singleton7Protect.class;
            Constructor<Singleton7Protect> constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Singleton7Protect singleton1 = constructor.newInstance();
            Singleton7Protect singleton2 = Singleton7Protect.getInstance();
            System.out.println("保护单例模式："+ (singleton1 == singleton2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
```

结果图

![alt](https://img2018.cnblogs.com/blog/612682/201811/612682-20181114134500047-1724387062.png)

##### 推荐新写法

`jdk1.5`以后，实现单例新写法，只需要编写一个包含单个元素的枚举类型。

分析

枚举类能够实现接口，但不能继承类，枚举类使用enum定义后再编译时就默认继承了java.lang.Enum类，而不是普通的继承Object类。

枚举类会默认实现Serializable和Comparable两个接口，且采用enum声明后，该类会被编译器加上final声明，故该类是无法继承的。枚举类的内部定义的枚举值就是该类的实例。除此之外，枚举类和普通类一致。因此可以利用枚举类来实现一个单例模式。直观图如下：

![alt](https://img2018.cnblogs.com/blog/612682/201811/612682-20181114134539057-881282767.png)

推荐写法代码：

```java
/**
 * 新写法：枚举类来实现一个单例，
 * 来测试破坏,是否会成功？
 *
 * @author sunyang
 * @date 2018/11/14 11:22
 */
public enum  Singleton8 {
    INSTANCE;

    public static Singleton8 getInstance(){
        return INSTANCE;
    }
}
```

测试是否反射破坏代码：

```java
/**
 * 枚举测试反射是否能破坏单例
 * 结论：可以防止单例模式被侵犯
 * @author sunyang
 * @date 2018/11/14 11:26
 */
public class EnumTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Singleton8> clazz = Singleton8.class;
        Constructor<Singleton8> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
```

结果图：

![alt](https://img2018.cnblogs.com/blog/612682/201811/612682-20181114134603621-1957585729.png)

结论：单元素的枚举类型已经成为实现单例模式的最佳方法。

##### 源码分析

`java.lang.reflect.Constructor#newInstance`

```java
@CallerSensitive
    public T newInstance(Object ... initargs)
        throws InstantiationException, IllegalAccessException,
               IllegalArgumentException, InvocationTargetException
    {
        if (!override) {
            if (!Reflection.quickCheckMemberAccess(clazz, modifiers)) {
                Class<?> caller = Reflection.getCallerClass();
                checkAccess(caller, clazz, null, modifiers);
            }
        }
        //反射再通过newInstance创建对象时，会检查该类是否ENUM修饰，如果是则抛出异常，反射失败。
        if ((clazz.getModifiers() & Modifier.ENUM) != 0)
            throw new IllegalArgumentException("Cannot reflectively create enum objects");
        ConstructorAccessor ca = constructorAccessor;   // read volatile
        if (ca == null) {
            ca = acquireConstructorAccessor();
        }
        @SuppressWarnings("unchecked")
        T inst = (T) ca.newInstance(initargs);
        return inst;
    }
```

扩展：测试对枚举类进行序列化操作代码：

```java
/**
 * 测试枚举类是否能防止序列化破坏单例模式
 * 结果：可以防止序列化破坏单例模式
 *
 * @author sunyang
 * @date 2018/11/14 11:52
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception{
        File objectFile = new File("Singleton8.javaObject");
        Singleton8 instance1 = Singleton8.INSTANCE;
        Singleton8 instance2 = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            //序列化到本地
            oos = new ObjectOutputStream(new FileOutputStream(objectFile));
            oos.writeObject(instance1);
            oos.flush();
            //反序列化到内存
            ois = new ObjectInputStream(new FileInputStream(objectFile));
            instance2= (Singleton8) ois.readObject();
        }catch (Exception e){

        }finally {
            oos.close();
            ois.close();
        }

        //true,说明两者引用着同一个对象
        System.out.println(Objects.equals(instance1, instance2));

    }
}
```

结论图

![alt](https://img2018.cnblogs.com/blog/612682/201811/612682-20181114134620560-223737319.png)

