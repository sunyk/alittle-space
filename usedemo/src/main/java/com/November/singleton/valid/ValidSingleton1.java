/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.singleton.valid;

import javax.jws.soap.SOAPBinding;

/**
 * 如果验证？
 * 根据类的五个生命周期阶段，我们只需要验证在创建对象之前的
 * 那些操作能够触发类的初始化就行。
 *
 * @author sunyang
 * @date 2018/11/8 11:13
 */
public class ValidSingleton1 {
    /**
     * 首先在构造方法里添加打印语句，打印"init"
     * 再添加静态方法和一个静态变量
     *
     */
    private static final ValidSingleton1 INSTANCE = new ValidSingleton1();

    //打印init
    public ValidSingleton1() {
        System.out.println("init");
    }

    public static ValidSingleton1 getINSTANCE() {
        return INSTANCE;
    }
    //静态方法
    public static final void otherMethod(){

    }
    //静态变量
    public static final int staticField = 0;
}

