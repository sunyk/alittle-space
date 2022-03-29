/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.jdk8.streams;

import java.util.*;

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

