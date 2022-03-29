/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.jdk8.streams;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author sunyang
 * @date 2018/9/30 9:36
 */
public class StreamDemo {

   static final Collection<Streams.Task> tasks = Arrays.asList(
            new Streams.Task(Streams.Status.OPEN, 51),
            new Streams.Task(Streams.Status.CLOSED, 1),
            new Streams.Task(Streams.Status.OPEN, 1)

    );

    public static void main(String[] args) {

        final long tagTasks = tasks
                .stream()
                .filter(task -> task.getStatus() == Streams.Status.OPEN)
                .mapToInt(Streams.Task::getPoints)
                .sum();
        System.out.println(tagTasks);


    }
}

