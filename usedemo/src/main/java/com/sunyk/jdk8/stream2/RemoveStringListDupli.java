/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.jdk8.stream2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 去除List中重复的String，对比jdk8流式操作
 * @author sunyang
 * @date 2018/10/17 11:24
 */
public class RemoveStringListDupli {
    public List<String> removeStringListDupli(List<String> stringList){
        //java8简写
//        List<String> unique = stringList.stream().distinct().collect(Collectors.toList());

        Set<String> set = new LinkedHashSet<>();
        set.addAll(stringList);
        stringList.clear();
        stringList.addAll(set);
        return stringList;
    }

    //根据Person对象的id去重
    public static List<Person> removeDupliById(List<Person> persons){
        Set<Person> personSet = new TreeSet<>(((o1, o2) -> o1.getId().compareTo(o2.getId())));
        personSet.addAll(persons);
        List<Person> result = new ArrayList<>(personSet);
        return result;
    }


}

