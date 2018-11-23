/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.October.jdk8.stream3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 串行流和并行流的比较compare
 *
 * @author sunyang
 * @date 2018/11/22 14:06
 */
public class StreamTest9 {

    public static void main(String[] args) {
        //准备500W个uuid来用不同的流进行排序
        List<String> list = new ArrayList<>(5000000);

        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("开始排序----------串行流-------------");
        long startTime = System.nanoTime();
        list.stream().sorted().count();
        long endTime = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("串行流排序耗时：" +  millis);

        System.out.println("开始排序------------并行流--------------");
        startTime = System.nanoTime();
        list.parallelStream().sorted().count();
        endTime = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("并行流排序耗时：" + millis);
    }
}

