/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.sunyk.springbootcore.logaspect;

import com.sunyk.springbootcore.logmethod.LogMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sunyang
 * @date 2018/12/19 11:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LogMethodTests {

    @Autowired
    private LogMethod logMethod;

    @Test
    public void test(){
        logMethod.doLog();
    }
}

