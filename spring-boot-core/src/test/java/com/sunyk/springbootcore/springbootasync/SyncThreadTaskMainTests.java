/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.springbootcore.springbootasync;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author sunyang
 * @date 2018/11/5 18:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SyncThreadTaskMainTests {

    @Autowired
    private TaskThread taskThread;

    @Test
    public void test() throws Exception {
        CountDownLatch latch = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            latch.countDown();
        }
        latch.await(60, TimeUnit.SECONDS);
        System.out.println("执行完成");
//        Thread.currentThread().join();
//        System.out.println("执行完成");
    }
}

