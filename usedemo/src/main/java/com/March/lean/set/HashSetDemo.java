/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.lean.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sunyang
 * @date 2019/3/20 13:42
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        System.out.println("HashSet初始容量大小：" + hashSet.size());

        hashSet.add("my");
        hashSet.add("name");
        hashSet.add("is");
        hashSet.add("sunyk");
        hashSet.add(",");
        hashSet.add("Hello");
        hashSet.add("world");
        hashSet.add("!");
        System.out.println("HashSet初始容量大小：" + hashSet.size());

        //迭代器遍历：
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
        System.out.println("--------------------------------------------------");
        //增强for循环
        for (String str : hashSet){
            if ("sunyk".equals(str)){
                System.out.println("this is a " + str);
            }
            System.out.println(str);
        }

        //元素删除
        hashSet.remove("sunyk");
        System.out.println("HashSet初始容量大小：" + hashSet.size());
        hashSet.clear();
        System.out.println("HashSet初始容量大小：" + hashSet.size());
        //集合判断
        boolean isEmpty = hashSet.isEmpty();
        System.out.println("HashSet是否为空：" + isEmpty);
        boolean isContains = hashSet.contains("hello");
        System.out.println("HashSet是否为空：" + isContains);
    }

}

