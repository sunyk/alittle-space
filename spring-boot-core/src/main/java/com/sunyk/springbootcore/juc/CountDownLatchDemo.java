/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.sunyk.springbootcore.juc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.DefaultManagedAwareThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * countDownLatch 并发测试
 *
 * @author sunyang
 * @date 2018/11/16 20:18
 */
public class CountDownLatchDemo {

    @Autowired
    private Executor executor;

    public void countDownDemo() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
//        Executor executor = Executors.newFixedThreadPool(5);
        BlockingQueue blockingQueue = new LinkedBlockingQueue(1000);
        ExecutorService executor = new ThreadPoolExecutor(5, 500,1000, TimeUnit.MINUTES, blockingQueue);
        executor.execute(() -> {
            System.out.println("执行第一个execute:" + Thread.currentThread().getName());
            countDownLatch.countDown();
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行第二个execute:" + Thread.currentThread().getName());
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();

        System.out.println("主线程执行：" + Thread.currentThread().getName());


    }
}

