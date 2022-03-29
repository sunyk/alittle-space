/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.sunyk.springbootcore.juc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author sunyang
 * @date 2018/12/2 21:12
 */
@Component
public class ExecutorsDemo {

    @Autowired
    private Executor executor;

    public void executeTask() throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(2);
        try {
            List<Integer> list = new ArrayList<>(2000);
            for (int i = 1; i <= 2000; i++) {
                list.add(i);
            }
            System.out.println("List: " + list.size());
            int latchNum = list.size() / 500;
            CountDownLatch countDownLatch = new CountDownLatch(latchNum);
            for (int i = 0; i < latchNum; i++) {
                executor.execute(()->{
                    System.out.println("Thread :" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                });
            }

        /*for (int i = 0; i < 2; i++) {
            executor.execute(()->{
                System.out.println("Thread :" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }*/
            countDownLatch.await(20, TimeUnit.SECONDS);
            System.out.println("结束执行");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /*if (executor instanceof ExecutorService){
                ((ExecutorService) executor).shutdown();
            }*/
        }

    }
}

