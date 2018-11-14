/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.November.singleton.valid;

/**
 * 实现线程内的单例
 * 思路：
 * 利用一个map<Long,Singleton9>来存储对象。
 * @param key：可以为线程ID
 * @param value:为每个线程下独有的对象
 * 可以用ThreadLocal来做线程的变量隔离
 *
 * @author sunyang
 * @date 2018/11/14 12:17
 */
public class Singleton9 {
    private Singleton9(){

    }

    private static final ThreadLocal<Singleton9> THREAD_HOLDER = new ThreadLocal<Singleton9>(){
        @Override
        protected Singleton9 initialValue() {
            return new Singleton9();
//            return super.initialValue();
        }
    };

    public static final Singleton9 getInstance(){
        return THREAD_HOLDER.get();
    }
}

