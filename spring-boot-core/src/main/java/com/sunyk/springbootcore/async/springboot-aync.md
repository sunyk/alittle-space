#### springboot-@Async

##### 概念

什么是异步调用？

异步调用对应的是同步调用，即默认调用方式，

同步调用是指程序按照定义顺序依次执行，每一行代码都必须等待上一行程序执行完成之后才能执行；

异步调用是指程序在顺序执行时，不等待异步调用的语句返回结果就执行后面的程序。

##### 实战

同步调用代码

~~~java
/**
 * @author sunyang
 * @date 2018/11/5 18:19
 */
@Component
public class SyncTask {

    public static Random random = new Random();

    public void doTaskOne()throws Exception{
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end -start) + "ns");
    }

    public void doTaskTwo() throws InterruptedException {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        System.out.println("完成任务二，耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

    public void doTaskThree() throws InterruptedException {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        System.out.println("完成任务三，耗时："+ (System.currentTimeMillis() - start) + "ms");
    }
}
~~~

自我单元测试

~~~java
/**
 * @author sunyang
 * @date 2018/11/5 18:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SyncTaskTests {

    @Autowired
    private SyncTask syncTask;

    @Test
    public void test() throws Exception {
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }
}
~~~

![1541414109509](C:\Users\sunyang\AppData\Local\Temp\1541414109509.png)

主线程中，任务一，任务二，任务三按从上到下的顺序完成执行。

异步调用代码

~~~java
/**
 * @author sunyang
 * @date 2018/11/5 18:19
 */
@Component
public class AsyncTask {

    public static Random random = new Random();

    @Async
    public void doTaskOne()throws Exception{
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end -start) + "ns");
    }

    @Async
    public void doTaskTwo() throws InterruptedException {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        System.out.println("完成任务二，耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

    @Async
    public void doTaskThree() throws InterruptedException {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        System.out.println("完成任务三，耗时："+ (System.currentTimeMillis() - start) + "ms");
    }
}
~~~

单元测试开始，注意结果

~~~java
/**
 * @author sunyang
 * @date 2018/11/5 18:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AsyncTaskTests {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void test() throws Exception {
        System.out.println("start async.........");
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
        System.out.println("end async.........");
    }
}
~~~

![1541414846272](C:\Users\sunyang\AppData\Local\Temp\1541414846272.png)

执行多次的结果，会有：

* 没有任何任务相关输出
* 有部分任务相关输出
* 乱序的任务相关输出

分析：

目前`doTaskOne`、`doTaskTwo`、`doTaskThree`三个函数已经是异步执行了。

主线程在异步调用之后，主线程并不会理会这三个函数是否执行完成，由于没有其他需要执行的内容，所以程序就自动结束了，导致了不完整或是没有输出任务相关内容情况。

> 注意：@Async所修饰的函数不要定义为static类型，静态方法这样异步调用不会生效

思考：

异步调用在springboot中很方便使用，最重要的是如何选择使用场景，在什么场景下使用，能达到最大优化作用。若任务本身之间不存在依赖关系，可并发执行的话；同步调用执行效率方面比较差等情况下，可以优化起来。



#### 题外话：异步回调

~~~java
/**
 * @author sunyang
 * @date 2018/11/5 18:19
 */
@Component
public class FutureAsyncTask {

    public static Random random = new Random();

    @Async
    public Future<String> doTaskOne()throws Exception{
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end -start) + "ns");
        return new AsyncResult<>("完成任务一");
    }

    @Async
    public Future<String> doTaskTwo() throws InterruptedException {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        System.out.println("完成任务二，耗时：" + (System.currentTimeMillis() - start) + "ms");
        return new AsyncResult<>("完成任务二");
    }

    @Async
    public Future<String> doTaskThree() throws InterruptedException {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        System.out.println("完成任务三，耗时："+ (System.currentTimeMillis() - start) + "ms");
        return new AsyncResult<>("完成任务三");
    }
}
~~~

单元测试走起

~~~java
/**
 * @author sunyang
 * @date 2018/11/5 18:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FutureAsyncTaskTests {

    @Autowired
    private FutureAsyncTask asyncTask;

    @Test
    public void test() throws Exception {
        System.out.println("start async.........");
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncTask.doTaskOne();
        Future<String> task2 = asyncTask.doTaskTwo();
        Future<String> task3 = asyncTask.doTaskThree();
        while (true){
            if (task1.isDone() && task2.isDone() && task3.isDone()){
                //等待三个任务都调用完成，退出循环
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end-start) + "ms");
    }
}
~~~

运行结果：

![1541419149248](C:\Users\sunyang\AppData\Local\Temp\1541419149248.png)

可以看到，通过异步调用，让任务一，任务二，任务三并发执行，有效的减少了程序总运行时间。