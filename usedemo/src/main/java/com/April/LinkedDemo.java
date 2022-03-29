/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.April;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunyang
 * @date 2019/4/15 17:18
 */
public class LinkedDemo {

    public static void main(String[] args) {
        List list = Arrays.asList("11","33","2","33","1","3");
        LinkedList linkedList = new LinkedList(list);
//        Object object = linkedList.pop();
//        System.out.println(object);
//        System.out.println(linkedList.pop());
//        linkedList.offerFirst("--");
//        linkedList.offerLast("--2");
//        System.out.println(linkedList);
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.poll());

        System.out.println(linkedList.clone());


    }
}

