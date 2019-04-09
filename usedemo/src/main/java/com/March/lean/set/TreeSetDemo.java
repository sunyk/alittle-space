/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.lean.set;

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

