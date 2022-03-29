/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.stringbuilder;

/**
 * @author sunyang
 * @date 2018/11/12 14:16
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        String titlePic = "https://img1.SunAd.org/tech/pic/FtweBUuoxz_y9FUshc0cRxxIPsSR_w750_h320.png";
        titlePic = imageSizeReducer(titlePic);
        /*StringBuilder stringBuilder = new StringBuilder(titlePic);
        stringBuilder.append("@80w_99q.png");*/
        System.out.println(titlePic);
    }

    public static String imageSizeReducer(String image) {

            StringBuilder titlePic = new StringBuilder(image);
            titlePic.append("@80w_99q.png");
            return titlePic.toString();

    }

}

