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

/**
 * flatMap去重
 *
 * @author sunyang
 * @date 2018/11/23 9:55
 */
public class StreamTest11 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "hello world", "world hello", "hello");
        //找出所有单词并去重
        list.stream().flatMap(item-> Arrays.stream(item.split(" "))).distinct().forEach(System.out::println);

    }
}

