/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.January;

/**
 * @author sunyang
 * @date 2019/1/4 14:32
 */
public class Lottery {

    public static void main(String[] args) {
        String hex = "110";
        String hex1 = "10";
        Integer x = Integer.parseInt(hex,2);
        Integer y = Integer.parseInt(hex1,2);
        System.out.println(x);
        System.out.println(y);
    }
}

