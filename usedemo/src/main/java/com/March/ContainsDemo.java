/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunyang
 * @date 2019/3/13 10:49
 */
public class ContainsDemo {
    public static void main(String[] args) {
        String categoryNames = "Temporary;GCDSB1;BYAZ;QT;Sparkplug;OtherDevice;WCGLPJ;HHS;HHSTT;HHSTGCD;QMSGD;GYDHXYT;Emergencytool;MAINTCLEANERS;";
//        System.out.println(categoryNames.toCharArray());
        List<String> categoryList = new ArrayList<>();
        String[] a = categoryNames.split(";");
        for (String aa : a){
            categoryList.add(aa);
        }
        String category = "GYDHXYT";

        System.out.println(categoryList.contains(category));
    }
}

