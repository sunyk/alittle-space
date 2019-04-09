/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.lean.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * hashcode和equals测试
 * @author sunyang
 * @date 2019/3/20 16:05
 */
public class HashSet2Demo {

    public static void hashCodeAndEquals(){
        Set<String> set1 = new HashSet<>();
        String str1 = new String("str1");
        String str2  = new String("str2");
        set1.add(str1);
        set1.add(str2);
        set1.add(null);
        set1.add(str2);
        System.out.println("第一个Set集合 长度：" + set1.size() + ",内容为:" + set1);
    }

    public static void main(String[] args) {
//        hashCodeAndEquals();
        List<String> list = Arrays.asList("str1", "str2","str3", "str4", "str3","str4", "str3", "str3");
        Set<String> result = new HashSet<>(list);
        System.out.println(result);
    }
}

