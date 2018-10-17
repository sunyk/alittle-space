/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.jdk8.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyang
 * @date 2018/10/16 9:59
 */
public class ListUserDemo {

    public static void main(String[] args) {
        User user = new User();
        List<User> allList = user.initWithAllData();
        List<User> smallList = user.initWithSmallData();
        transform(allList, smallList);
    }


    /**
     * 方法描述：将数组中的数据进行匹配，然后重新发给前端展示
     * @param allList
     * @param smallList
     * @return
     * @return List<User>
     *
     */
    public static List<User> transform(List<User> allList,List<User> smallList){

        List<User> tempList = new ArrayList<>();
        //1.先将小数组的数据取出来
        for (int i = 0; i < smallList.size(); i++) {
            User user = smallList.get(i);
            user.setSelected(true);
            tempList.add(user);
        }
        //2.再将大数组的数据取出来
        for (int i = 0; i < allList.size(); i++) {
            User bingUser = allList.get(i);
            bingUser.setSelected(false);
            Boolean isContain = false;
            for (int j = 0; j < smallList.size(); j++) {
                User user = smallList.get(j);
                if (user.getName().equals(bingUser.getName())) {
                    isContain = true;
                }
            }
            if (!isContain) {
                tempList.add(bingUser);
            }
        }
        //3.打印数据
        for (int i = 0; i < tempList.size(); i++) {
            User user = tempList.get(i);
            System.out.println(user);
        }

        return allList;
    }

}

