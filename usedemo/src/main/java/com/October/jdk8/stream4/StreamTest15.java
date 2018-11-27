/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.October.jdk8.stream4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunyang
 * @date 2018/11/26 16:17
 */
public class StreamTest15 {

    public static void main(String[] args) {
        List<String> fixLabels = Arrays.asList("xby","dby","scp");
        System.out.println(fixLabels.stream().collect(Collectors.groupingBy(String::getBytes)));

    }
}

