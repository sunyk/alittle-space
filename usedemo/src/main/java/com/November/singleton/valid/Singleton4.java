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
 * @date 2018/11/8 12:18
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4(){

    }
    //需要加上synchronized 同步
    public static synchronized Singleton4 getInstance(){
        if (instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}

