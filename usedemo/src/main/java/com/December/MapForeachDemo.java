/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.December;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java8 lambda Map循环
 * java8 lambda List循环
 *
 * @author sunyang
 * @date 2018/12/17 9:53
 */
public class MapForeachDemo {

    public static void main(String[] args) {
        Map<String, Integer> imap = new HashMap<>();
        imap.put("A", 10);
        imap.put("B", 20);
        imap.put("C", 30);
        imap.put("D", 40);
        imap.put("E", 50);
        imap.put("F", 60);
        imap.forEach((k,v)->System.out.println("Item : " + k + "Count : " + v));
        imap.forEach((k,v) ->{
            System.out.println("map:" + k + "Count:" + v);
            if ("E".equals(k)){
                System.out.println("Hello E");
            }
        });

        //-------------------------List foreach lambda

        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");
        items.add("F");

        items.forEach(item-> System.out.println(item));

        items.forEach(item->{
            if ("C".equals(item)){
                System.out.println(item);
            }
        });
    }
}

