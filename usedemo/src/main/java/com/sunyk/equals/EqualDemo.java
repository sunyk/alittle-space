/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.equals;

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
        model.setName("tuhu1");
        list.add(model);
        model.setId("1002");
        model.setName("tuhu4");
        list.add(model);
        model.setId("1005");
        model.setName("tuhu2");
        list.add(model);
        System.out.println(list);

        List<OverrideEqualsModel> list2 = new ArrayList<>();
        OverrideEqualsModel model2 = new OverrideEqualsModel();
        model2.setId("1003");
        model2.setName("tuhu3");
        list2.add(model2);
        model2.setId("1002");
        model2.setName("tuhu2");
        list2.add(model2);

        List result= list.stream().distinct().collect(Collectors.toList());

//        System.out.println(result);
//        List<OverrideEqualsModel> list = new ArrayList<>();
//        list.add(0, "");
    }

}

