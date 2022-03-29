/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.December;

/**
 * @author sunyang
 * @date 2018/12/11 20:28
 */
public class GenericCodeUtils {

    public static void main(String[] args) {
        long num = 1111;
        String code = String.valueOf(num);
        String result = String.format("%0" + code.length() + "d", Integer.parseInt(code));
        String result1 = String.format("%0" + (code.length()-1) + "d", Integer.parseInt(code));
        System.out.println(result);
        System.out.println(result1);
        System.out.printf("最牛的编号是：%n%03d", 7);

        System.out.printf("整数分组的效果是：%,d%n", 9989997);
//        System.out.println( String.format("%,f", 9999));
        System.out.print(String.format("%-10s", "11111"));

        int number = 111;
        System.out.println(String.format("%06d", number));
    }
}

