/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.singleton;

/**
 * 单例2，是使用静态变量维护该类的引用，但是要将对象创建放在静态代码块中
 *
 * @author sunyang
 * @date 2018/11/6 18:49
 */
public class Singleton2 {
    private static final Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    public Singleton2() {
    }

    public static Singleton2 getInstance(){
        return INSTANCE;
    }


}

