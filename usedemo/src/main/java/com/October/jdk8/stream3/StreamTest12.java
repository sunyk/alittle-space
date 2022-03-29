/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.jdk8.stream3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 两组列表组装
 *
 * @author sunyang
 * @date 2018/11/23 10:10
 */
public class StreamTest12 {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("sun", "star", "slena");

        List<String> result = list1.stream().flatMap(item->list2.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        result.forEach(System.out::println);

    }
}

