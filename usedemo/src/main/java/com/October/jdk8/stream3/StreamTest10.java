/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.October.jdk8.stream3;

import java.util.Arrays;
import java.util.List;

/**
 * 流的短路
 *
 * @author sunyang
 * @date 2018/11/22 20:07
 */
public class StreamTest10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","worlds","hello world","world hello");
        System.out.println(list);
        //打印长度为5的第一个单词
//        list.stream().mapToInt(String::length).filter(lenght-> lenght == 5).findFirst().ifPresent(System.out::println);
        //下面只会输入出hello和5，因为流针对每一个元素的统一应用所有操作，所以直接找到了第一个hello
        list.stream().mapToInt(item->{
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length->length == 5).findFirst().ifPresent(System.out::println);
    }
}

