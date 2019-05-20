/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunyang
 * @date 2019/4/17 13:47
 */
public class Stream8Demo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("BR-BO-Safety|114","BR-BO-Safety|115","BR-BO-Safety|114");
        System.out.println(list.stream().distinct().count());
    }
}

