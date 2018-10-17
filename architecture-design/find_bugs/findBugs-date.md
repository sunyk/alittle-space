### Findbugs中的BUG关于java.util.Date

* 报错提示页面

![1539137946673](C:\Users\sunyang\AppData\Local\Temp\1539137946673.png)

* 分析原因：

在于Calendar类和Date的实体获取机制不同导致

* 代码调试

~~~java
public class TestModel {

    private Date createTime;

    public Date getCreateTime() {
        return (Date) createTime.clone();
    }

    public void setCreateTime(Date createTime) {
//        this.createTime = (Date) createTime.clone();
        this.createTime = (Date) createTime.clone();
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "createTime=" + createTime +
                '}';
    }
}
~~~

~~~java
public class CloneObjectDemo {
    public static void main(String[] args) {
        TestModel obj = new TestModel();
        Date now = new Date();
        obj.setCreateTime(now);
        System.out.println(obj.getCreateTime().toString());
        now.setYear(5);
        System.out.println(obj.getCreateTime().toString());
    }
}
~~~

结果展示：

~~~
Wed Oct 10 10:13:17 CST 2018
Wed Oct 10 10:13:17 CST 2018
~~~

