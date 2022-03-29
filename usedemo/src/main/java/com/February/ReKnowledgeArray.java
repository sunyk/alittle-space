/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.February;

/**
 * 重新认识Java数组
 *
 * @author sunyang
 * @date 2019/2/14 11:50
 */
public class ReKnowledgeArray {

    public static void main(String[] args) {
        //首选
        double[] myList;
        //效果相同，风格来自C/C++语言
        double myList2[];

        int size = 10;

        myList = new double[size];
        myList[0] = 6.66;
        myList[1] = 66.66;
        myList[2] = 666.66;
        myList[3] = 6666.66;
        myList[4] = 6666.66;
        myList[5] = 6.66;
        myList[6] = 66.66;
        myList[7] = 666.66;
        myList[8] = 6666.66;
        myList[9] = 6.666;
        //计算所有元素的总和
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += myList[i];
        }
        System.out.println("Total:" + total);



    }
}

