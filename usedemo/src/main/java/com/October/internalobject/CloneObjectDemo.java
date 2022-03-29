/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.internalobject;

import java.util.Calendar;
import java.util.Date;

/**
 * @author sunyang
 * @date 2018/10/10 9:56
 */
public class CloneObjectDemo {
    /*public static void main(String[] args) {
        TestModel obj = new TestModel();
        Date now = new Date();
        obj.setCreateTime(now);
        System.out.println(obj.getCreateTime().toString());
        now.setYear(5);
        System.out.println(obj.getCreateTime().toString());
    }*/

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo();
        Calendar calendar = Calendar.getInstance();
        System.out.println("1."+ calendar.getTime().toString());
        obj.setCreateTime(calendar.getTime());
        System.out.println("2."+obj.getCreateTime().toString());
        calendar.set(Calendar.YEAR, 4900+1000);
        System.out.println("3."+calendar.getTime().toString());
        System.out.println("4."+obj.getCreateTime().toString());

    }
}

