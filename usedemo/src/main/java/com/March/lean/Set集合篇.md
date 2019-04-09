# Set 集合

了解Set集合

Set继承于Collection接口，是一个不允许出现重复元素，并且无序的集合，主要HashSet和TreeSet两大实现类

![1553086029274](C:\Users\sunyang\AppData\Local\Temp\1553086029274.png)

### 代码实用

#### HashSet 的基本操作

~~~java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sunyang
 * @date 2019/3/20 13:42
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        System.out.println("HashSet初始容量大小：" + hashSet.size());

        hashSet.add("my");
        hashSet.add("name");
        hashSet.add("is");
        hashSet.add("sunyk");
        hashSet.add(",");
        hashSet.add("Hello");
        hashSet.add("world");
        hashSet.add("!");
        System.out.println("HashSet初始容量大小：" + hashSet.size());

        //迭代器遍历：
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
        System.out.println("--------------------------------------------------");
        //增强for循环
        for (String str : hashSet){
            if ("sunyk".equals(str)){
                System.out.println("this is a " + str);
            }
            System.out.println(str);
        }

        //元素删除
        hashSet.remove("sunyk");
        System.out.println("HashSet初始容量大小：" + hashSet.size());
        hashSet.clear();
        System.out.println("HashSet初始容量大小：" + hashSet.size());
        //集合判断
        boolean isEmpty = hashSet.isEmpty();
        System.out.println("HashSet是否为空：" + isEmpty);
        boolean isContains = hashSet.contains("hello");
        System.out.println("HashSet是否为空：" + isContains);
    }

}
~~~

#### HashSet 元素添加操作

不允许添加重复元素? 

`HashSet` 调用HashMap的put（key, value）方法

原因：在向HashMap中添加元素时，先判断key的hashcode值是否相同，如果相同，则调用equals（），==进行判断，若相同则覆盖原有元素；如果不同，则直接向Map中添加元素

#### TreeSet的基本操作

~~~java
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author sunyang
 * @date 2019/3/20 16:53
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();
        System.out.println("TreeSet初始化容量大小：" + treeSet.size());
        treeSet.add("B我和");
        treeSet.add("A你和我");
        treeSet.add("A你1");
        treeSet.add("A你2");
        treeSet.add("1");
        treeSet.add("2");
        System.out.println("TreeSet元素顺序为：" + treeSet.toString());

        //迭代器遍历：升序
        Iterator<String> iteratorAesc = treeSet.iterator();
        while(iteratorAesc.hasNext()){
            String str = iteratorAesc.next();
            System.out.println("遍历升序："  +str);
        }

        Iterator<String> iteratorDesc = treeSet.descendingIterator();
        while (iteratorDesc.hasNext()){
            String str = iteratorDesc.next();
            System.out.println("遍历降序：" + str);
        }

        //元素获取：实现NavigableSet接口
        String firstEle = treeSet.first();
        System.out.println("TreeSet头结点为： " + firstEle);

        //获取指定元素之前的所有元素的集合：（不包含指定元素）
        SortedSet<String> headSet = treeSet.headSet("A你2");
        System.out.println("某结点之前的元素为：" + headSet.toString());

        //获取给定元素之间的集合：（包含头，不包含尾）
        SortedSet subSet = treeSet.subSet("1", "B我和");
        System.out.println("1到B我和之间节点元素为：" + subSet.toString());

        //集合判断
        boolean isEmpty = treeSet.isEmpty();
        System.out.println("TreeSet是否为空：" + isEmpty);
        treeSet.clear();
        String pollFirst = treeSet.pollFirst();
        String pollLast = treeSet.pollLast();

        System.out.println("删除的第一个元素：" + pollFirst + "," + pollLast);

    }
}
~~~

#### TreeSet元素排序

自然排序和自定义排序

~~~java
import java.util.TreeSet;

/**
 * @author sunyang
 * @date 2019/3/20 20:01
 */
public class TreeSetDemo2 {

    public static void main(String[] args) {
        naturalSort();
    }

    //自然排序顺序：升序
    public static void naturalSort(){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("a");
        treeSet.add("z");
        treeSet.add("2");
        treeSet.add("2.2");
        treeSet.add("1.0");
        treeSet.add("1.01");
        treeSet.add("2.01");
        treeSet.add("2.002");
        treeSet.add("1.001");
        treeSet.add("1.1");
        System.out.println("版本：" + treeSet.toString());
        System.out.println("字母顺序：" + treeSet.toString());
        /**
         * 字母顺序：[1, 11, 2, 22, a, z]
         */

        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(11);
        integerTreeSet.add(1);
        integerTreeSet.add(3);
        integerTreeSet.add(4);
        integerTreeSet.add(6);
        System.out.println("数字顺序：" + integerTreeSet.toString());
        /**
         * 数字顺序：[1, 3, 4, 6, 11]
         */
    }

~~~

自定义排序

~~~java
import java.util.TreeSet;

/**
 * @author sunyang
 * @date 2019/3/20 20:17
 */
public class TreeSetDemo3 {

    public static void main(String[] args) {
        customSort();
    }

    //自定义排序顺序：升序 com.March.lean.set.App cannot be cast to java.lang.Comparable
    //App需要实现Comparable接口

    public static void customSort(){
        TreeSet<App> treeSet = new TreeSet<>();

        App app1 = new App("xiaoqiang", 20);
        App app2 = new App("xiaoming", 25);
        App app3 = new App("xiaohei", 26);
        App app33 = new App("xiaohei", 20);
        App app4 = new App("xiaohuang", 27);

        treeSet.add(app1);
        treeSet.add(app2);
        treeSet.add(app3);
        treeSet.add(app33);
        treeSet.add(app4);
        System.out.println("TreeSet集合顺序为：" + treeSet);
    }
}

~~~

实现Comparable接口

~~~java
/**
 * @author sunyang
 * @date 2019/3/20 20:15
 */
public class App implements Comparable<App>{

    private String name;

    private Integer age;

    public App() {
    }

    public App(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(App app) {
        //比较name的长度
        int num = this.name.length() - app.name.length();
        //如果name长度一样，则比较年龄的大小
        return num == 0 ? this.age - app.age : num;
    }

    @Override
    public String toString() {
        return "App{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
~~~

实现自定义接口

~~~java
import java.util.Comparator;

/**
 * @author sunyang
 * @date 2019/3/20 20:38
 */
public class AppComparator implements Comparator<App2> {

    @Override
    public int compare(App2 app1, App2 app2) {
        int num = app1.getAge() - app2.getAge();
        //先比较年龄，年龄若相同在比较名字长度
        return num == 0 ? app1.getName().length() - app2.getName().length() : num;
    }
}

~~~

~~~java
public class App2{

    private String name;

    private Integer age;

    public App2() {
    }

    public App2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "App{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
~~~

~~~java
import java.util.TreeSet;

/**
 * @author sunyang
 * @date 2019/3/20 20:17
 */
public class TreeSetDemo4 {

    public static void main(String[] args) {
        customSort();
    }

    //自定义排序顺序：升序 com.March.lean.set.App cannot be cast to java.lang.Comparable
    //App需要实现自定义比较器类

    public static void customSort(){
        TreeSet<App2> treeSet = new TreeSet<App2>(new AppComparator());

        App2 app1 = new App2("xiaoqiang", 20);
        App2 app2 = new App2("xiaoming", 25);
        App2 app3 = new App2("xiaohei", 26);
        App2 app33 = new App2("xiaohei", 20);
        App2 app4 = new App2("xiaohuang", 27);
        App2 app44 = new App2("xiaohuang2", 27);

        treeSet.add(app1);
        treeSet.add(app2);
        treeSet.add(app3);
        treeSet.add(app33);
        treeSet.add(app4);
        treeSet.add(app44);
        System.out.println("TreeSet集合顺序为：" + treeSet);
        /**
         * TreeSet集合顺序为：[App{name='xiaohei', age=20}, App{name='xiaoqiang', age=20}, App{name='xiaoming', age=25}, App{name='xiaohei', age=26}, App{name='xiaohuang', age=27}, App{name='xiaohuang2', age=27}]
         */
    }
}
~~~





