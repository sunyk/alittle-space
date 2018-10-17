/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.jdk8.streams;

import java.util.*;

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

