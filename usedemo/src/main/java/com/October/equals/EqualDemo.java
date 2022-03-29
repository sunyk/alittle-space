/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.equals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunyang
 * @date 2018/10/17 10:24
 */
public class EqualDemo {

    public static void main(String[] args) {
        List<OverrideEqualsModel> list = new ArrayList<>();
        OverrideEqualsModel model = new OverrideEqualsModel();
        model.setId("1001");
        model.setName("SunAd1");
        list.add(model);
        model.setId("1002");
        model.setName("SunAd4");
        list.add(model);
        model.setId("1005");
        model.setName("SunAd2");
        list.add(model);
        System.out.println(list);

        List<OverrideEqualsModel> list2 = new ArrayList<>();
        OverrideEqualsModel model2 = new OverrideEqualsModel();
        model2.setId("1003");
        model2.setName("SunAd3");
        list2.add(model2);
        model2.setId("1002");
        model2.setName("SunAd2");
        list2.add(model2);

        List result= list.stream().distinct().collect(Collectors.toList());

//        System.out.println(result);
//        List<OverrideEqualsModel> list = new ArrayList<>();
//        list.add(0, "");
    }

}

