/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.singleton.valid;

/**
 * 新写法：枚举类来实现一个单例，
 * 来测试破坏,是否会成功？
 *
 * @author sunyang
 * @date 2018/11/14 11:22
 */
public enum  Singleton8 {
    INSTANCE;

    public static Singleton8 getInstance(){
        return INSTANCE;
    }
}

