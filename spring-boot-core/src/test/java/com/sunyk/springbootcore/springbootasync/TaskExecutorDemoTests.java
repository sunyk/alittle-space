/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.springbootcore.springbootasync;

import com.sunyk.springbootcore.async.TaskExecutorDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sunyang
 * @date 2018/11/30 9:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskExecutorDemoTests {

    @Autowired
    private TaskExecutorDemo taskExecutorDemo;


    @Test
    public void test() throws Exception {
        for (int i = 0; i < 10; i++) {
            taskExecutorDemo.doTaskOne();

        }
    }
}

