/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.jdk8.streams;

import java.util.HashMap;
import java.util.function.BiFunction;

/**
 * @author sunyang
 * @date 2018/10/15 18:59
 */
public class MapsDemo {
    public static void main(String[] args) {
        /*HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>() {{add(5);}};

        Collections.addAll(set1, 2, 4, 6, 7);
        System.out.println(set1);

        set1.addAll(set2);
        System.out.println(set1);*/

        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>(){{put(1, 5);}};
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>(){{put(3, 4);}};

        map1.putAll(map2);
        BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFuncton;

        map1.merge(1,88, (k,y) -> y);
        System.out.println(map1);


    }
}

