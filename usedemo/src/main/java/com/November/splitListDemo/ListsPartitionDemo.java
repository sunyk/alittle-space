/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.November.splitListDemo;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * 高效的，按固定size大小分割List
 *
 * @author sunyang
 * @date 2018/11/29 19:17
 */
public class ListsPartitionDemo {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("1","2","3","4","5","6","7","8","9","1","2","4","5","6","7","7","6","6","6","6","6","66");
        List<List<String>> result = Lists.partition(ls, 5);
        System.out.println(result);
        System.out.println(ls.size());
        System.out.println(ls.size() / 10);
        //( length + groupSize - 1 ) / groupSize
        System.out.println((ls.size() + 10 - 1) / 10);
    }
}

