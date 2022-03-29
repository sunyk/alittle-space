/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.forkjoin;

import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author sunyang
 * @date 2018/10/9 9:27
 */
public class ParealleStream {

    public static void main(String[] args) {
        ArrayList<Integer> lists = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lists.add(i);
        }

        LongAdder sum = new LongAdder();
        lists.parallelStream().forEach(integer -> {
            System.out.println("[当前线程：]  " +  Thread.currentThread().getName());
            sum.add(integer);
        });
        System.out.println("this is " + sum);
    }
}

