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
 * stream是否存在某元素
 *
 * @author sunyang
 * @date 2018/12/7 14:08
 */
public class StreamFilterDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("消保养灯", "消刹车灯", "消胎压灯");
        List<String> fited = list.stream().filter(x -> (list.contains("消保养灯"))).collect(Collectors.toList());
        System.out.println(fited);
    }
}

