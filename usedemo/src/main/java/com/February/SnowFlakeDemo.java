/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.February;

/**
 * @author sunyang
 * @date 2019/2/22 10:02
 */
public class SnowFlakeDemo {

    public static void main(String[] args) {
        /**
         * 41为时间戳部分，可以使用69年
         */
       Long val1 = 1L << 41;
       Long val2 = 1000L * 60 * 60 * 24 * 365;
       System.out.println("分子：" + val1);
       System.out.println("分母：" + val2);
       System.out.println("年：" + (val1/val2) );

        System.out.println(val1 | val2 );

        SnowFlake snowFlake = new SnowFlake(2,3);
        for (int i = 0; i < 10; i++) {
            long orderId = snowFlake.nextId();
            System.out.println("orderId : " + orderId);
        }

    }

}

