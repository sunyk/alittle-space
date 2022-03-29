/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.jdk8.stream4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 并行通过第二组数组，过滤第一组全部数组，得到一个新的数组
 *
 * @author sunyang
 * @date 2018/11/26 16:25
 */
public class StreamTest16 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("xby", "dby", "ew", "lsm", "rx", "ecc", "ys");
        List<String> list2 = Arrays.asList("xby","dby","scp");

        List<String> result = list1.parallelStream().flatMap(item->list2.parallelStream().filter(item2 -> item.equals(item2))).collect(Collectors.toList());
        System.out.println(result.toString());
        result.forEach(System.out::println);

    }
}

