/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March;

/**
 * @author sunyang
 * @date 2019/3/5 9:57
 */
public class SynchronizedTest {

    /**
     * 同步方法：在这看不出来，需要看JVM底层实现，依靠的是方法修饰符上的ACC_SYNCHRONIZED 实现。
     * 同步方法：synchronized方法则会被翻译成普通的方法调用和返回指令如：invokevirtual、areturn指令，在JVM字节码层面
     * 并没有任何特别的指令来实现被synchronized修饰的方法，而是Class文件的方法表中将该方法的access_flags字段中
     * synchronized标志位置设置为1,表示该方法是同步方法，并使用调用该方法的对象或该方法所属的Class在JVM的内部对象表示
     * Klass作为锁对象。
     */
    public synchronized void test1(){

    }

    public void test2(){
        /**
         * 同步代码块 monitorenter 和 monitorexit 指令实现的。
         * 同步代码块：monitorenter 指令出入到同步代码块的开始位置，moitorexit与之相对于。任何对象都有一个与Monitor与之相关联，
         * 当且一个Monitor被持有之后，他将处于锁定状态。线程执行到monitorenter指令时，将会尝试获取对象所对应的Monitor所有权，
         * 即尝试获取对象的锁。
         */
        synchronized (this){

        }
    }
}

