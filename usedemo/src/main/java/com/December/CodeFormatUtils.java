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
 * @date 2018/12/11 20:51
 */
public class CodeFormatUtils {

    public static void main(String[] args) {
        long num  = 987;
        String code = String.valueOf(num);
        String first = code.substring(0, 1);
        String result = first + "000+";
        System.out.println(first);
        System.out.println(result);
    }
}

