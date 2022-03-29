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
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sunyang
 * @date 2018/11/5 18:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SyncTaskTests {

    @Autowired
    private SyncTask syncTask;

    @Test
    public void test() throws Exception {
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }
}

