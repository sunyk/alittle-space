
package com.April.thread;

/**
 * @author sunyang
 * @date 2019/4/8 15:58
 */
public class MyThread extends Thread {
    private static volatile  int num = 0;

    public synchronized void myThread(){
        ++num;
    }

    @Override
    public void run() {
        myThread();
        System.out.println("线程名称:"+ Thread.currentThread().getName() +"主动创建的第"+ num + "个线程");
    }
}

