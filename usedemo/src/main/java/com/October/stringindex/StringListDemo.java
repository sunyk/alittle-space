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
 * jdk8 list用逗号分隔
 *
 * @author sunyang
 * @date 2018/11/28 12:19
 */
public class StringListDemo {

    public static void main(String[] args) {
        List<String> lists = Arrays.asList("shanghai", "beijing", "san");
        String commaSeparted = String.join(",", lists);
        System.out.println(commaSeparted);
    }
}

