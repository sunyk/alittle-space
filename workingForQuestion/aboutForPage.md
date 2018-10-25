### 关于Page问题如图：

![1540361539308](C:\Users\sunyang\AppData\Local\Temp\1540361539308.png)

分析类的代码如下：

~~~java
/**
 * 简化分页信息
 *
 * @author sunyang
 * @date 2018/10/22 18:28
 */
public class PageInfo<T>{

    private static final long serialVersionUID = 1L;

    private int pageNum;

    private int pageSize;

    private long pageTotal;

    private List<T> pageList;

//    private Page<T> page;内部page不需要定义和赋值

    public PageInfo() {
    }

    public PageInfo(List<T> pageList) {
        this.pageList = pageList;
    }

    public PageInfo(Page<T> page) {
        this.pageNum = page.getCurrent();
        this.pageSize = page.getSize();
        this.pageTotal = page.getTotal();
        this.pageList = page.getRecords();
    }

    public PageInfo(Page<T> page, List<T> pageList) {
        this.pageNum = page.getCurrent();
        this.pageSize = page.getSize();
        this.pageTotal = page.getTotal();
        this.pageList = pageList;
    }

    public PageInfo(int pageNum, int pageTotal, List<T> pageList) {
        this.pageNum = pageNum;
        this.pageTotal = pageTotal;
        this.pageList = pageList;
    }

    public PageInfo(int pageNum, int pageSize, int pageTotal, List<T> pageList) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageTotal = pageTotal;
        this.pageList = pageList;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    public long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
    }


    @Override
    public String toString() {
        return "PageInfo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
                ", pageList=" + pageList +
                '}';
    }
}
~~~





