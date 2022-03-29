/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.stringindex;

import org.apache.commons.lang3.StringUtils;

/**
 * @author sunyang
 * @date 2018/11/28 14:06
 */
public class StringDelmitDemo {

    public static void main(String[] args) {
        String name = "B - 别克";
        String name1 = StringUtils.deleteWhitespace(name);
        System.out.println(name1.substring(name1.indexOf("-") + 1));
    }
}

