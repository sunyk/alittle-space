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
 * @date 2018/11/12 20:42
 */
public class Singleton6 {
    private Singleton6(){}
    //静态内部类
    private static class SingletonHolder{
        private static Singleton6 INSTANCE = new Singleton6();
    }

    //通过静态嵌套类，便可以实现对饿汉式进行懒化的效果
    public static final Singleton6 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

