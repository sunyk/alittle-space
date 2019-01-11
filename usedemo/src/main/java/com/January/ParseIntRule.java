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
 * @date 2019/1/4 15:25
 */
public class ParseIntRule {

    public static void main(String[] args) {
   /*     String hex = "100";
        Integer x = Integer.parseInt(hex, 16);
        System.out.println(x);*/

       String beef = "41";
       String chicken = "12";

       double x = Integer.parseInt(beef, 16);
       double y = Integer.parseInt(chicken, 8);
       double discount = x/y;
       /* System.out.println(x);
        System.out.println(y);
        System.out.println(discount);*/


        byte binary=(byte)0b11_101_001;
        System.out.println(binary);

        Byte b = new Byte(String.valueOf(0b11_101_001));
        System.out.println(b);
    }
}

