/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.singleton.valid;

/**
 * @author sunyang
 * @date 2018/11/12 19:07
 */
public class Singleton41 {
    private static Singleton41 instance;

    private Singleton41(){}

    private static synchronized void doGetInstance(){
        if (null == instance){
            instance = new Singleton41();
        }
    }

    public static synchronized Singleton41 getInstance(){
        if (null == instance){
            doGetInstance();
        }
        return instance;
    }
}

