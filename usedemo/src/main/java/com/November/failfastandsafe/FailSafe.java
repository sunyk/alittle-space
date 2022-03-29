/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.failfastandsafe;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 为什么ConcurrentHashMap（安全失败）在集合遍历的时候没有抛出异常？
 * 原因：采用安全失败机制的集合容器，在遍历时不是直接在集合内容上访问，
 * 而是先复制原有集合内容，在拷贝的集合上进行遍历。
 * 由于迭代时是对原集合的拷贝进行遍历，所以在遍历过程中对原集合所作的修改
 * 并不能被迭代器检测到，所以不会抛异常
 *
 * @author sunyang
 * @date 2018/11/15 9:57
 */
public class FailSafe {

    public static void main(String[] args) {
        Map safeMap = new ConcurrentHashMap();
        safeMap.put("java-1", 1);
        safeMap.put("java-2", 2);
        safeMap.put("java-3", 3);

        Set set = safeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            safeMap.put("下次循环不会抛出异常", 4);
            System.out.println("此 safeMap 的长度为" + safeMap.size());
        }

        System.out.println("此 safeMap 为" + safeMap);
    }
}

