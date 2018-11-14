### 单例模式引发相关整理

#### 如何破坏单例模式

示例：

~~~java
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
~~~

测试得出结果

~~~java
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
~~~

上图的单例，最主要的一步是将构造方法私有化，从而外界无法new对象。但是java的反射可以强制访问private修饰的变量，方法和构造函数，如图

~~~java
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
~~~

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

~~~java
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
~~~

结果图

![1542163162518](C:\Users\sunyang\AppData\Local\Temp\1542163162518.png)

##### 推荐新写法

`jdk1.5`以后，实现单例新写法，只需要编写一个包含单个元素的枚举类型。

分析

枚举类能够实现接口，但不能继承类，枚举类使用enum定义后再编译时就默认继承了java.lang.Enum类，而不是普通的继承Object类。

枚举类会默认实现Serializable和Comparable两个接口，且采用enum声明后，该类会被编译器加上final声明，故该类是无法继承的。枚举类的内部定义的枚举值就是该类的实例。除此之外，枚举类和普通类一致。因此可以利用枚举类来实现一个单例模式。直观图如下：

![1542165521590](C:\Users\sunyang\AppData\Local\Temp\1542165521590.png)

推荐写法代码：

~~~java
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
~~~

测试是否反射破坏代码：

~~~java
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
~~~

结果图：



![1542166418016](C:\Users\sunyang\AppData\Local\Temp\1542166418016.png)

结论：单元素的枚举类型已经成为实现单例模式的最佳方法。

##### 源码分析

`java.lang.reflect.Constructor#newInstance`

~~~java
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
~~~

扩展：测试对枚举类进行序列化操作代码：

~~~java
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
~~~

结论图

![1542169010833](C:\Users\sunyang\AppData\Local\Temp\1542169010833.png)



