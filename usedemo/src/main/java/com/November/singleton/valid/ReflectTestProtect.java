/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.November.singleton.valid;

import java.lang.reflect.Constructor;

/**
 * 保护单例模式测试demo
 *
 * @author sunyang
 * @date 2018/11/14 10:32
 */
public class ReflectTestProtect {
    public static void main(String[] args) {
        try {
            Class<Singleton7Protect> clazz = Singleton7Protect.class;
            Constructor<Singleton7Protect> constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Singleton7Protect singleton1 = constructor.newInstance();
            Singleton7Protect singleton2 = Singleton7Protect.getInstance();
            System.out.println("保护单例模式："+ (singleton1 == singleton2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

