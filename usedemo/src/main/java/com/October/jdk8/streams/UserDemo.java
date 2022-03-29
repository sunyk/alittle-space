/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.jdk8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sunyang
 * @date 2018/10/12 10:14
 */
public class UserDemo {
    public static void main(String[] args){
        List<User> list = getUserList();

        Map<String,List<User>> userGroupMap = list.stream().collect(Collectors.groupingBy(User::getType));
        System.out.println(userGroupMap);
        List<User> userList = userGroupMap.get("小学");

    }


    public static List<User> getUserList(){
        User user1 = new User(1,"小学","张三");
        User user2 = new User(2,"小学","李四");
        User user3 = new User(3,"初中","王五");
        User user4 = new User(4,"高中","马六");

        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        return list;
    }
}

