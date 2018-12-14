/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 求差集
 * @author sunyang
 * @date 2018/12/13 18:47
 */
public class CompareTwoList {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(3);
        list2.add(4);
        list2.add(5);



        List<Integer> result = list1.stream().filter(t->!list2.contains(t)).collect(Collectors.toList());
        System.out.println(result);

    }
}

