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

/**
 * foeach 退出操作
 *
 * @author sunyang
 * @date 2018/12/6 15:33
 */
public class StreamReturnDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("11","22","333","444","555","666");

        list.forEach(s -> {

            if (s.length() >= 3){
                return;

            }
            System.out.println(s);
        });
    }
}

