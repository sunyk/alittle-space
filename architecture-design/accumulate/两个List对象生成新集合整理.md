## 场景：对两个List对象集合中的数据进行过滤，将相同的部分提取出来，然后重新生成集合，并添加标识



~~~java
/**
 * 获取两个ArrayList的交集
 * @author sunyang
 * @date 2018/10/15 19:38
 */
public class ReceiveCollectionList extends AbstraProcessList {
    @Override
    List processList(List<String> firstArray, List<String> secondList) {
        List<String> resultList = new ArrayList<String>();
        LinkedList<String> result = new LinkedList<String>(firstArray);// 大集合用linkedlist
        HashSet<String> othHash = new HashSet<String>(secondList);// 小集合用hashset
        Iterator<String> iter = result.iterator();// 采用Iterator迭代器进行数据的操作
        while(iter.hasNext()) {
            if(!othHash.contains(iter.next())) {
                iter.remove();
            }
        }
        resultList = new ArrayList<String>(result);
        return resultList;
    }
}
~~~









