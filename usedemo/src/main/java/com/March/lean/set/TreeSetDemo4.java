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
public class TreeSetDemo4 {

    public static void main(String[] args) {
        customSort();
    }

    //自定义排序顺序：升序 com.March.lean.set.App cannot be cast to java.lang.Comparable
    //App需要实现自定义比较器类

    public static void customSort(){
        TreeSet<App2> treeSet = new TreeSet<App2>(new AppComparator());

        App2 app1 = new App2("xiaoqiang", 20);
        App2 app2 = new App2("xiaoming", 25);
        App2 app3 = new App2("xiaohei", 26);
        App2 app33 = new App2("xiaohei", 20);
        App2 app4 = new App2("xiaohuang", 27);
        App2 app44 = new App2("xiaohuang2", 27);

        treeSet.add(app1);
        treeSet.add(app2);
        treeSet.add(app3);
        treeSet.add(app33);
        treeSet.add(app4);
        treeSet.add(app44);
        System.out.println("TreeSet集合顺序为：" + treeSet);
        /**
         * TreeSet集合顺序为：[App{name='xiaohei', age=20}, App{name='xiaoqiang', age=20}, App{name='xiaoming', age=25}, App{name='xiaohei', age=26}, App{name='xiaohuang', age=27}, App{name='xiaohuang2', age=27}]
         */
    }


}

