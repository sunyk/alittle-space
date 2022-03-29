/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.splitListDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyang
 * @date 2018/11/29 18:31
 */
public class SplitList {

    private List<List<String>> splitList(List<String> list , int groupSize){
        int length = list.size();
        // 计算可以分成多少组
        int num = ( length + groupSize - 1 )/groupSize ; // TODO
        List<List<String>> newList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            // 开始位置
            int fromIndex = i * groupSize;
            // 结束位置
            int toIndex = (i+1) * groupSize < length ? ( i+1 ) * groupSize : length ;
            newList.add(list.subList(fromIndex,toIndex)) ;
        }
        return  newList ;
    }

    /*private List<List<String>> splitList(List<String> list , int groupSize){
        return  Lists.partition(list, groupSize); // 使用guava
    }*/


}

