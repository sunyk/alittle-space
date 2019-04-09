/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.lean.set;

import java.util.TreeSet;

/**
 * @author sunyang
 * @date 2019/3/20 20:01
 */
public class TreeSetDemo2 {

    public static void main(String[] args) {
        naturalSort();
    }

    //自然排序顺序：升序
    public static void naturalSort(){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("a");
        treeSet.add("z");
        treeSet.add("2");
        treeSet.add("2.2");
        treeSet.add("1.0");
        treeSet.add("1.01");
        treeSet.add("2.01");
        treeSet.add("2.002");
        treeSet.add("1.001");
        treeSet.add("1.1");
        System.out.println("版本：" + treeSet.toString());
        System.out.println("字母顺序：" + treeSet.toString());
        /**
         * 字母顺序：[1, 11, 2, 22, a, z]
         */

        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(11);
        integerTreeSet.add(1);
        integerTreeSet.add(3);
        integerTreeSet.add(4);
        integerTreeSet.add(6);
        System.out.println("数字顺序：" + integerTreeSet.toString());
        /**
         * 数字顺序：[1, 3, 4, 6, 11]
         */
    }
}

