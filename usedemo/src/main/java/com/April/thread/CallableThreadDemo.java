/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April.thread;

import java.util.concurrent.*;

/**
 * @author sunyang
 * @date 2019/4/8 16:28
 */
public class CallableThreadDemo implements Callable<Integer>{

    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableThreadDemo ct = new CallableThreadDemo();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(ct);
        for (int i = 0; i < 50; i++) {
            System.out.println("main方法中，当前线程："+ Thread.currentThread().getName() + "的循环变量i的值" + i);
            if (i == 20){
                new Thread(futureTask, "有返回值的线程").start();
            }
        }
        System.out.println("子线程的返回值：" + futureTask.get());
    }*/

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        MyFutureTask myFutureTask = new MyFutureTask(""); //错误使用
//        MyFutureTask myFutureTask = new MyFutureTask();  正确使用
        FutureTask<String> futureTask = new FutureTask<String>(myFutureTask);
        for (int i = 0; i < 50; i++) {
            if (i == 49){
                new Thread(futureTask).start();
            }
        }
        try {
            System.out.println("Task任务找那个获取返回的值：" + futureTask.get(1000, TimeUnit.MILLISECONDS));
        }catch (Exception e){
            System.out.println("超时获取不到就忽略");
        }

    }


    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 10; i++) {
            System.out.println("当前线程：" + Thread.currentThread().getName() + "当前位置：" + i);
        }
        return i;
    }
}

