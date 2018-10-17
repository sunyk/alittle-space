/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.jdk8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

