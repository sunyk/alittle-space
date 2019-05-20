/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April;

import java.util.*;

/**
 * @author sunyang
 * @date 2019/4/15 14:02
 */
public class ArrayListDeme {

    public static void main(String[] args) {
//        List list = new LinkedList();
//        Set list = new HashSet();
//        Vector list= new Vector();
//        ArrayList list = new ArrayList();
//        LinkedList list = new LinkedList();
//        LinkedHashSet list = new LinkedHashSet();
//        LinkedHashMap list = new LinkedHashMap();
        List list = Arrays.asList("11","22","aa");
        Collection collection = new HashSet();
        collection.add("1");
        collection.add("2");

//        list.replaceAll(collection);
        System.out.println(list.retainAll(collection));
//        Object object = null;
//        list.put("111", object);
//        list.put("aaa", object);
        /*list.add(object);
        list.add("aaa");*/
        System.out.println(list);
    }
}

