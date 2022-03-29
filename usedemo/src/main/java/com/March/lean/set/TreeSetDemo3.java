/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.March.lean.set;

import java.util.TreeSet;

/**
 * @author sunyang
 * @date 2019/3/20 20:17
 */
public class TreeSetDemo3 {

    public static void main(String[] args) {
        customSort();
    }

    //自定义排序顺序：升序 com.March.lean.set.App cannot be cast to java.lang.Comparable
    //App需要实现Comparable接口

    public static void customSort(){
        TreeSet<App> treeSet = new TreeSet<>();

        App app1 = new App("xiaoqiang", 20);
        App app2 = new App("xiaoming", 25);
        App app3 = new App("xiaohei", 26);
        App app33 = new App("xiaohei", 20);
        App app4 = new App("xiaohuang", 27);

        treeSet.add(app1);
        treeSet.add(app2);
        treeSet.add(app3);
        treeSet.add(app33);
        treeSet.add(app4);
        System.out.println("TreeSet集合顺序为：" + treeSet);
    }
}

