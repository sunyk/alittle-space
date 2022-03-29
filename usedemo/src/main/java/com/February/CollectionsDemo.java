/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.February;

import java.util.*;

/**
 * @author sunyang
 * @date 2019/2/20 15:35
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("1");
        stack.add("2");
        stack.add("3");
        stack.add("4");
        System.out.println(stack.pop());
        /*Map<String, String> map = new HashMap<>();
        map.put("null","11");
        map.put("null","222");
        System.out.println(map);*/

        Set<String> set = new HashSet<>();
        set.add("null");
        set.add("null1");
        System.out.println(set);

        //遍历 ArrayList
        List<String> list= Arrays.asList("Hello", "world", "I'm sunyk");
        //第一种遍历，把链表变为数组相关的内容进行遍历
        String[] strArray = new String[list.size()];
        list.toArray(strArray); //把链表转成数组
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }

        //第三种遍历 使用迭代器进行相关遍历
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //-------------------------------------------------------------------------------------------------
        //遍历Map
        Map<String, String> map = new HashMap<>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        /**
         * [1, 2, 3]
         * [value1, value2, value3]
         * [1=value1, 2=value2, 3=value3]
         */
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());

        //第一种：普通使用，二次取值
        for (String key : map.keySet()){
            System.out.println("key:"+ key + "and value=" + map.get(key));
        }

        //第二种：通过map.entrySet 使用iteratror遍历key和value
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            System.out.println("key:"+ entry.getKey() + " value:" + entry.getValue());
        }

        //第三这个：推荐，尤其是容量大时
        //通过Map.entrySet遍历key和value
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("key="+ entry.getKey() + ", value = "+ entry.getValue());
        }

        //第四种，通过Map.values() 遍历所有的value,但不能遍历key
        for (String v : map.values()){
            System.out.println("value:"+ v);
        }




    }
}

