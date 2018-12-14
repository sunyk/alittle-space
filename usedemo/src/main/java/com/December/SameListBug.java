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
 * List<map<String, Object>>下面添加新对象，需要新建一个拼装好的数据再去添加覆盖原来key对应的value
 * 直接add的话，如果List不同key下面有相同的值都会添加对应的追加值，导致重复数据
 *
 * @author sunyang
 * @date 2018/12/14 23:00
 */
public class SameListBug {

    public static void main(String[] args) {
        Map<String, Object> doc = new HashMap<>(16);
        doc.put("docId", "874");
        doc.put("title", "t1");
        List<Map<String, Object>> docs = new ArrayList<>();
        Map<String, List<Map<String, Object>>> doc11 = new HashMap<>();
        docs.add(doc);
        doc11.put("docs", docs);
        doc11.put("docs1", docs);
        System.out.println(doc11);
        for (int i = 0; i < 1; i++) {
            Map<String, Object> curr = docs.get(i);
            System.out.println(curr);
            Map<String, Object> newDoc = new HashMap<>(16);
            newDoc.put("docId", "875");
            newDoc.put("title", "t2");
//            newDoc.merge("docId", curr, );


        }
        System.out.println(doc11);
    }
}

