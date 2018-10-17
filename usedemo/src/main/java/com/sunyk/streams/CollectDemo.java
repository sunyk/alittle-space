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
 * @date 2018/10/15 18:45
 */
public class CollectDemo {
    public static void main(String[] args) {
        List list1 =  new ArrayList();
        list1.add(0,"1");
        list1.add(1,"11");
        list1.add(2,"111");
        list1.add(3,"1111");
        List list2 =  new ArrayList();
        list1.add(0,"type1");
        list1.add(1,"type11");
        list1.add(2,"type111");
        list1.add(3,"type1111");

        List newList = new ArrayList();
//         List result = list1.stream().collect(ArrayList::new, list1::add , list2::addAll);

    }
}

