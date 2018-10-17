/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyang
 * @date 2018/10/15 19:17
 */
public class MegreSetDemo {
    public static void main(String[] args) {
        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();
        //差集List
        List<String> defectList = new ArrayList<>();
        //交集List
        List<String> collectList = new ArrayList<>();
        //去重并集List
        List<String> unionList = new ArrayList<>();


        firstList.add("aa");
        firstList.add("bb");
        firstList.add("cc");

        secondList.add("bb");
        secondList.add("cc");
        secondList.add("ddd");

        AbstraProcessList processList = new ReceiveCollectionList();
        List resultList = processList.processList(firstList, secondList);
        System.out.println(resultList);
        AbstraProcessList processList2 = new ReceiveDefectList();
        List resultList2 = processList2.processList(firstList, secondList);
        System.out.println(resultList2);
        AbstraProcessList processList3 = new ReceiveUnionList();
        List resultList3 = processList3.processList(firstList, secondList);
        System.out.println(resultList3);
    }
}

