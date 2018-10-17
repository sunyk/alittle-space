### 两个List<T>进行合并处理-交集

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

### 差集处理

~~~java
/**
 * 获取两个ArrayList的差集
 * @author sunyang
 * @date 2018/10/15 19:24
 */
public class ReceiveDefectList extends AbstraProcessList {

    @Override
    List processList(List<String> firstArray, List<String> secondList) {
        List<String> resultList = new ArrayList<>();
        //大集合使用
        LinkedList<String> result = new LinkedList<String>(firstArray);
        //小集合使用hashset
        HashSet<String> hashSet = new HashSet<>(secondList);
        //采用iteror迭代器进行数据操作
        Iterator<String> iter = result.iterator();
        while (iter.hasNext()){
            if (hashSet.contains(iter.next())){
                iter.remove();
            }
        }
        resultList = new ArrayList<>(result);
        return resultList;
    }
}
~~~

### 去重合并集合

~~~java
/**
 * 获取两个ArrayList的去重并集
 * @author sunyang
 * @date 2018/10/15 19:40
 */
public class ReceiveUnionList extends AbstraProcessList {
    @Override
    List processList(List<String> firstArray, List<String> secondList) {
        List<String> resultList = new ArrayList<String>();
        Set<String> firstSet = new TreeSet<String>(firstArray);
        for(String id : secondList) {
            // 当添加不成功的时候 说明firstSet中已经存在该对象
            firstSet.add(id);
        }
        resultList = new ArrayList<String>(firstSet);
        return resultList;
    }
}
~~~







