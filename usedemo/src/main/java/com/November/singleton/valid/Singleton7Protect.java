/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.singleton.valid;

/**
 * 如何保护单例
 *
 * @author sunyang
 * @date 2018/11/14 10:07
 */
public class Singleton7Protect {
    private static boolean flag = false;

    private Singleton7Protect(){
        synchronized (Singleton7Protect.class){
            if (flag == false){
                flag = !flag;
            }else{
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }

    private static class SingletonHolder{
        private static final Singleton7Protect INSTANCE = new Singleton7Protect();
    }
    public static Singleton7Protect getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

