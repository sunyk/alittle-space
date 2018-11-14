/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.November.singleton.valid;

/**
 * 如果破坏单例模式
 *
 * @author sunyang
 * @date 2018/11/13 20:14
 */
public class Singleton7 {
    private Singleton7(){
        System.out.println("Singleton7");
    }

    private static final class SingletonHolder{
        SingletonHolder(){
            System.out.println("SingletonHolder");
        }
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

