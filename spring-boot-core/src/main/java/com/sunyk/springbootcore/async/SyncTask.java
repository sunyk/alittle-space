/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.springbootcore.async;

import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.Random;

/**
 * @author sunyang
 * @date 2018/11/5 18:19
 */
@Component
public class SyncTask {

    public static Random random = new Random();

    public void doTaskOne()throws Exception{
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end -start) + "ns");
    }

    public void doTaskTwo() throws InterruptedException {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        System.out.println("完成任务二，耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

    public void doTaskThree() throws InterruptedException {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        System.out.println("完成任务三，耗时："+ (System.currentTimeMillis() - start) + "ms");
    }
}

