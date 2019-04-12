/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author sunyang
 * @date 2019/4/8 17:54
 */
public class ExecutionDemo  {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Callable c = new MyFutureTask(i + " ");
            Future future = pool.submit(c);
            list.add(future);
        }
        pool.shutdown();

        for (Future future: list) {
            System.out.println("获取结果Task:" + future.get().toString());
        }
    }
}

