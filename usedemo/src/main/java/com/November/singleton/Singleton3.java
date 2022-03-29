/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.singleton;

/**
 * 单例3，使用静态变量维持类的对象引用，在获取对象的方法中对象进行判断和创建
 *
 * @author sunyang
 * @date 2018/11/6 18:59
 */
public class Singleton3 {
    public static Singleton3 instance;

    private Singleton3(){

    }

    private static Singleton3 getInstance(){
        if (instance == null){
            instance = new Singleton3();
        }
        return instance;
    }

}

