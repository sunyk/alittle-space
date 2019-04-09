/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.lean.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author sunyang
 * @date 2019/3/21 11:47
 */
public class ListTest {
    private static final int COUNT = 1000;

    private static ArrayList arrayList = new ArrayList();
    private static LinkedList linkedList = new LinkedList();
    private static Vector vector = new Vector();

    public static void insetToList(List list){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            //可以实现list降序效果
            list.add(0,i);
            //可以实现升序效果
            list.add(i);
        }
        System.out.println(list.toString());
        long endTime = System.currentTimeMillis();
        System.out.println("插入 " + COUNT + "元素" + getName(list) + "花费：" + (endTime - startTime)+ "毫秒");
    }

    public static void deleteFromList(List list){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            list.remove(0);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("删除" + COUNT + "元素" + getName(list) + "花费" + (endTime - startTime) + "毫秒");
    }

    public static void readList(List list){
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            list.get(i);
        }
        System.out.println(list.toString());
        long endTime = System.currentTimeMillis();
        System.out.println("读取"+ COUNT + "元素" + getName(list) + "花费" + (endTime -startTime) + "毫秒");
    }

    private static String getName(List list){
        String name = "";
        if (list instanceof ArrayList){
            name = "ArrayList";
        }else if (list instanceof LinkedList){
            name = "LinkedList";
        }else if(list instanceof Vector){
            name = "Vector";
        }
        return name;
    }

    public static void main(String[] args) {
        insetToList(arrayList);
        insetToList(linkedList);
        insetToList(vector);

        System.out.println("-----------------------------------");
        readList(arrayList);
        readList(linkedList);
        readList(vector);
        System.out.println("------------------------------------");
        deleteFromList(arrayList);
        deleteFromList(linkedList);
        deleteFromList(vector);
    }
}

