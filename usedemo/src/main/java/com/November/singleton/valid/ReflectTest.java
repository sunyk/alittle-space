/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.November.singleton.valid;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author sunyang
 * @date 2018/11/13 20:31
 */
public class ReflectTest {

    /**
     * Singleton7
     * Singleton7
     * 反射获取构造器和直接获取构造器，比较是否同一个：false
     */

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Class<Singleton7> singleton7Class = Singleton7.class;
        Constructor<Singleton7> constructor = singleton7Class.getDeclaredConstructor();
        constructor.setAccessible(true);
        //反射获取构造函数
        Singleton7 singleton1 = constructor.newInstance();

        Singleton7 singleton2 = Singleton7.getInstance();

        System.out.println("反射获取构造器和直接获取构造器，比较是否同一个：" + (singleton1 == singleton2));

    }
}

