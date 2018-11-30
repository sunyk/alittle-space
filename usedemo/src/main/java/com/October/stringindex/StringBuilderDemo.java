/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.October.stringindex;

/**
 * @author sunyang
 * @date 2018/11/28 12:16
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        String result = "";

        for (int i = 0; i < 10; i++) {
            StringBuilder tem = new StringBuilder();
            tem.append(result);
            tem.append(",som mor");
            result = tem.toString();
        }
        System.out.println(result);
    }
}

