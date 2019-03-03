# 构建全局唯一ID

* `java.util.UUID`包下jdk 1.5之后新增的类`java.util.UUID#randomUUID`
* SnowFlake算法即雪花算法

### UUID

~~~JAVA
public class UUIDDemo {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println("构建全局唯一ID：" + uuid);
        //把string类型的转UUID
        System.out.println( UUID.fromString(uuid));
        //指定byte大小的UUID的值
        System.out.println( UUID.nameUUIDFromBytes(new byte[100000000]));

        /**
         * 构建全局唯一ID：1bc06eb4-a0bf-4c28-9e26-795f5c4f1816
         * 1bc06eb4-a0bf-4c28-9e26-795f5c4f1816
         * 0f86d7c5-a618-3cf9-984c-1d21144d85b0
         */

    }
}
~~~

### SnowFlake

**分析**

SnowFlake算法产生的ID是一个64位的整型，结构如下每一部分用 - 符号分隔：

~~~java
0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000
~~~

* **1位标识部分**：在java中由于long的最高位是符号位，正数是0，负数是1
* **41位时间戳部分**：时间戳的差值（当前时间-固定的开始时间）
  * ![1550804115212](C:\Users\sunyang\AppData\Local\Temp\1550804115212.png)

* **10位节点部分**：Twitter实现中使用前5位作为数据中标识，后5位作为机器标识，可以部署1024个节点；
* **12位序列号部分**：支持同一毫秒内同一个节点可以生产4096个ID；

> SonwFlake算法生产的ID大致是按时间递增的，用在分布式系统中，需要注意数据中心标识和机器标识必须唯一，这样就能保证每个节点生产的ID都是唯一的。
>
> 灵活性：或许我们不一定都像上面那样使用5位作为数据中心标识，5位作为机器标识，可以根据我们业务的需要，灵活分配节点部分，如：不需要数据中心，完全可以使用全部10位作为机器标识；若数据中心不多，也可以只使用3位作为数据中心，7位作为机器标识。

~~~java
//Java中^：异或
//Java中<<：逻辑左移，左移一位相当于乘以2的1次方
~~~



#### 代码分析

~~~java
/**
 * twitter的snowFlake算法
 *
 * @author sunyang
 * @date 2019/2/22 13:07
 */
public class SnowFlake {

    /**
     * 起初的时间戳
     */

    private static final long START_STMP = 1550812123L;

    /**
     * 每一部分占用的位数
     * 序列号占用位数
     * 机器标识占用位数
     * 数据中心占用位数
     */
    private static final long SEQUENCE_BIT = 12;
    private static final long MACHINE_BIT = 5;
    private static final long DATACENTER_BIT = 5;

    /**
     * 每一部分的最大值
     */
    private static final long MAX_SEQUENCE_NUM = -1L ^ (-1L << SEQUENCE_BIT);
    private static final long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private static final long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);

    /**
     * 每一部分向左的位移
     */
    private static final long MACHINE_LEFT = SEQUENCE_BIT;
    private static final long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private static final long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    //数据中心
    private long datacenterId;
    //机器标识
    private long machineId;
    //序列号
    private long sequence = 0L;
    //上一次时间戳
    private long lastStmp = -1L;

    public SnowFlake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0){
            throw new IllegalArgumentException("传入数据中心参数有误");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0){
            throw new IllegalArgumentException("传入机器标识参数有误");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 生产下一个ID
     */
    public synchronized long nextId(){
        //获取新的时间戳
        long currStmp = getNewstmp();
        if (currStmp < lastStmp){
            throw new RuntimeException("不允许向后生成ID");
        }
        if (currStmp == lastStmp){
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE_NUM;
            if (sequence == 0L){
                //同一毫秒的序列数已经达到最大,获得下一个时间戳
                currStmp = getNextMill();
            }
        }else{
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }
        lastStmp = currStmp;
        /**
         * 时间戳部分
         * 数据中心部分
         * 机器标识部分
         * 序列号部分
         */
        return (currStmp - START_STMP) << TIMESTMP_LEFT
                | datacenterId << DATACENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
    }

    private long getNextMill() {
        //获得新的时间戳
        long mill = getNewstmp();
        while (mill <= lastStmp){
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

}
~~~

测试结果：

~~~java
/**
 * @author sunyang
 * @date 2019/2/22 10:02
 */
public class SnowFlakeDemo {

    public static void main(String[] args) {
        /**
         * 41为时间戳部分，可以使用69年
         */
       Long val1 = 1L << 41;
       Long val2 = 1000L * 60 * 60 * 24 * 365;
       System.out.println("分子：" + val1);
       System.out.println("分母：" + val2);
       System.out.println("年：" + (val1/val2) );

        System.out.println(val1 | val2 );

        SnowFlake snowFlake = new SnowFlake(2,3);
        for (int i = 0; i < 10; i++) {
            long orderId = snowFlake.nextId();
            System.out.println("orderId : " + orderId);
        }

    }

}
~~~



![1550818715919](C:\Users\sunyang\AppData\Local\Temp\1550818715919.png)



























