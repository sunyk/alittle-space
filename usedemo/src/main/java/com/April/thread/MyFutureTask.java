/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.April.thread;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author sunyang
 * @date 2019/4/8 17:27
 */
public class MyFutureTask implements Callable<String> {
    private String taskNum;

    public MyFutureTask(String taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public String call() throws Exception {
        Date start =  new Date();
        Thread.sleep(1000);
        Date end =  new Date();

        return taskNum + "this is a callable time:"+ (start.getTime() - end.getTime());
    }
}

