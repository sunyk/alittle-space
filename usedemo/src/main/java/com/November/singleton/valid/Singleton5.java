/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.November.singleton.valid;

/**
 * @author sunyang
 * @date 2018/11/12 19:13
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5(){}

    //如果多个线程同时通过第一次检查，并且其中一个线程
    // 首先通过了第二次检查并实例化了对象，那么剩余通过了
    //第一次检查的线程就不会再去实例化对象。提升了效率
    public static Singleton5 getInstance(){
        if (null == instance){
            synchronized (Singleton5.class){
                if (null == instance){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

