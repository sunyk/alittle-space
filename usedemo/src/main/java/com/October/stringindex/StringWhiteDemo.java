/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.stringindex;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunyang
 * @date 2018/11/29 18:08
 */
public class StringWhiteDemo {

    public static void main(String[] args) {
        String tid = "tid";
        String brand = "brandName";
        String vehicle = "vehicle";

        List<String> fullTitleList = Arrays.asList(tid, brand, vehicle);

        List<String> fullTitleList2 = Arrays.asList(tid, " " + brand," " + vehicle);

        System.out.println(fullTitleList);
        System.out.println(fullTitleList2);
    }
}

