/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.November.elegantcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author sunyang
 * @date 2018/11/26 11:31
 */
public class OptionalCollectionDemo {

    public static void main(String[] args) throws Exception {
        Map<String, Map<String, Object>> orFieldMap = new HashMap<>(16);
        Map<String, List<String>> inFieldMap =  new HashMap<>(16);


        Optional.ofNullable(orFieldMap).orElseThrow(()-> new Exception("last"));

//        Optional.of(inFieldMap).orElseThrow(()->new Exception("demo"));

//        Optional.ofNullable(inFieldMap).ifPresent(null);

        Optional<String> demo = Optional.of("xsd");
        System.out.println(demo);


     }
}

