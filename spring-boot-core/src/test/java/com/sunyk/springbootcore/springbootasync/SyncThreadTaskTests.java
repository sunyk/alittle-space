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

import com.sunyk.springbootcore.async.SyncTask;

/**
 * @author sunyang
 * @date 2018/11/5 18:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SyncThreadTaskTests {

    @Autowired
    private TaskThread taskThread;

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 10; i++) {
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //------------------2
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //-------------3
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //-----------4
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //---------------5
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //--------------6
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //--------------7
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
            //--------------8
            taskThread.doTaskOne();
            taskThread.doTaskTwo();
            taskThread.doTaskThree();
        }
        Thread.currentThread().join();
    }
}

