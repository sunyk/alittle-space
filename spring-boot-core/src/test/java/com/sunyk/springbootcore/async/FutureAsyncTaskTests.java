/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.sunyk.springbootcore.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * @author sunyang
 * @date 2018/11/5 18:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FutureAsyncTaskTests {

    @Autowired
    private FutureAsyncTask asyncTask;

    @Test
    public void test() throws Exception {
        System.out.println("start async.........");
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncTask.doTaskOne();
        Future<String> task2 = asyncTask.doTaskTwo();
        Future<String> task3 = asyncTask.doTaskThree();
        while (true){
            if (task1.isDone() && task2.isDone() && task3.isDone()){
                //等待三个任务都调用完成，退出循环
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end-start) + "ms");
    }
}

