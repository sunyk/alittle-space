/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.November.singleton.valid;

/**
 * 解决上图双重检查机制出现的问题，可能返回一个未被完全初始化的类
 *
 * @author sunyang
 * @date 2018/11/12 20:24
 */
public class Singleton51 {

    private static volatile Singleton51 instance;

    private Singleton51(){}
    public static Singleton51 getInstance(){
        if (null==instance){
            synchronized (Singleton51.class){
                if (null == instance){
                    instance = new Singleton51();
                }
            }
        }
        return instance;
    }
}

