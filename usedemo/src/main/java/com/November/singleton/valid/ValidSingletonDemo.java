/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.November.singleton.valid;

/**
 * @author sunyang
 * @date 2018/11/8 11:26
 */
public class ValidSingletonDemo {

    public static void main(String[] args) {
        System.out.println("---------------------start");
        /*1.验证单例1,只声明，不会触发类的初始化阶段
        ValidSingleton1 validSingleton1 = null;
        if (null == validSingleton1){
            System.out.println("singleton1 is null");
        }*/
        /*//2.调用类的静态变量
        System.out.println(ValidSingleton1.staticField);*/

        //3.调用类的静态方法
//        ValidSingleton1.otherMethod();
        //4.初始化两次
        ValidSingleton1 validSingleton1 = new ValidSingleton1();
        //5.直接调用
//        ValidSingleton1.getINSTANCE();
        System.out.println("---------------------end");

        /**
         * -------start-------
         * singleton1 is null
         * -------end---------
         *
         * ---------------------start
         *  0
         *   ---------------------end
         *
         *   ---------------------start
         *  init
         *  ---------------------end
         *
         *  ---------------------start
         *  init
         *  init
         *  ---------------------end
         *
         *
         *  ---------------------start
         * init
         * ---------------------end
         */
    }
}

