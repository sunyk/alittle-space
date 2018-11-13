#### springboot-@Async：自定义线程池

##### 线程池参数

`CorePoolSize`:核心线程数

`MaxPoolSize`:最大线程数

`QueueCapacity`:缓存队列大小

`KeepAliveSeconds`:允许线程池最大空闲数

`RejectedExecutionHandler`:线程池对拒绝任务的处理策略：一般为`CallerRunsPolicy()` ，当线程池没有处理能力的时候，该策略会直接在execute方法的调用线程中运行被拒绝的任务；如果执行程序已经关闭，则会丢弃

该任务。

`ThreadNamePrefix`：线程的名字前缀；

##### 配置线程池

> com.sunyk.springbootcore.config.TheadPoolConfig

~~~java
/**
 * @author sunyang
 * @date 2018/11/12 17:43
 */
/**
 * 自定义线程池Bean
 */
@EnableAsync
@Configuration
public class TheadPoolConfig {
        @Bean("taskExecutor")
        public Executor taskExecutor(){
            ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
            //核心线程数为10
            taskExecutor.setCorePoolSize(10);
            //最大线程数为20
            taskExecutor.setMaxPoolSize(20);
            //缓存队列大小200
            taskExecutor.setQueueCapacity(200);
            //允许线程池最大空闲60秒
            taskExecutor.setKeepAliveSeconds(60);
            //线程池对拒绝任务的处理策略：当线程池没有处理能力的时候，该策略会直接在execute方法的
            // 调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
            taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            //线程前缀
            taskExecutor.setThreadNamePrefix("taskExecutor-");
            return taskExecutor;
        }
}

~~~

##### 使用自定义线程池

~~~java
/**
 * @author sunyang
 * @date 2018/11/12 10:56
 */
@Component
public class TaskThread {

    private final static Logger log = LoggerFactory.getLogger(TaskThread.class);

    public static Random random = new Random();

    @Async("taskExecutor")
    public void doTaskOne() throws Exception{
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "ms");
    }

    @Async("taskExecutor")
    public void doTaskTwo() throws Exception{
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "ms");
    }

    @Async("taskExecutor")
    public void doTaskThree() throws Exception{
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end =  System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end -start) + "ms");

    }

}
~~~

##### 自我单元测试

~~~java
/**
 * @author sunyang
 * @date 2018/11/5 18:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SyncThreadTaskTests {

    @Autowired
    private TaskThread taskThread;

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 10; i++) {
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //------------------2
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //-------------3
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //-----------4
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //---------------5
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //--------------6
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //--------------7
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //--------------8
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
        }
        Thread.currentThread().join();
    }
}
~~~

##### 测试结果

![1542016520298](C:\Users\sunyang\AppData\Local\Temp\1542016520298.png)













