/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.November.failfastandsafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 为什么HashMap（快速失败）迭代器遍历时，修改集合就会抛异常？
 * 原因是迭代器再遍历时直接访问集合中的内容，并且在遍历过程
 * 中使用一个modCount变量。集合在被遍历期间如果内容发生变化，
 * 就会改变modCount的值。每当迭代器使用hashNext()或next()
 * 遍历下一个元素之前，都会检查modCount变量是否为expectedModCount值，
 * 是的话就返回遍历；否则抛出异常，终止遍历。
 *
 * @author sunyang
 * @date 2018/11/15 9:41
 */
public class FailFast {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("java-1", 1);
        hashMap.put("java-2", 2);
        hashMap.put("java-3", 3);

        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            hashMap.put("下次循环会抛异常", 4);
            System.out.println("此时 hashMap 的长度为"+ hashMap.size());
        }
        System.out.println("此 hashMap 为" + hashMap);
    }
}

