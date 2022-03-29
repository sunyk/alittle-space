/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.singleton;

/**
 * 最常见的单例，有两个必不可少的东西
 * 1.私有化类的所有构造函数，以阻止其他代码在该类的外界去创建对象
 * 2.提供获取对象的静态方法，以返回类唯一的对象引用
 *
 * @author sunyang
 * @date 2018/11/6 18:44
 */
//单例1，通过类的静态变量来持有一个该类的对象的引用，同时使用final关键字来阻止被再次赋值
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    public Singleton1() {
    }

    public static Singleton1 getINSTANCE() {
        return INSTANCE;
    }
}

