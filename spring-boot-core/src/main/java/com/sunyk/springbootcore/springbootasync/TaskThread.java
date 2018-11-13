/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.springbootcore.springbootasync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author sunyang
 * @date 2018/11/12 10:56
 */
@Component
public class TaskThread {

    private final static Logger log = LoggerFactory.getLogger(TaskThread.class);

    public static Random random = new Random();

    @Async("taskExecutor")
    public void doTaskOne() throws Exception{
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "ms");
    }

    @Async("taskExecutor")
    public void doTaskTwo() throws Exception{
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "ms");
    }

    @Async("taskExecutor")
    public void doTaskThree() throws Exception{
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end =  System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end -start) + "ms");

    }

}

