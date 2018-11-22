### JDK8 Stream 串行流和并行流

测试demo

~~~java
/**
 * 串行流和并行流的比较compare
 *
 * @author sunyang
 * @date 2018/11/22 14:06
 */
public class StreamTest9 {

    public static void main(String[] args) {
        //准备500W个uuid来用不同的流进行排序
        List<String> list = new ArrayList<>(5000000);

        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("开始排序----------串行流-------------");
        long startTime = System.nanoTime();
        list.stream().sorted().count();
        long endTime = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("串行流排序耗时：" +  millis);

        System.out.println("开始排序------------并行流--------------");
        startTime = System.nanoTime();
        list.parallelStream().sorted().count();
        endTime = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("并行流排序耗时：" + millis);
    }
}
~~~

![1542868412002](C:\Users\sunyang\AppData\Local\Temp\1542868412002.png)

