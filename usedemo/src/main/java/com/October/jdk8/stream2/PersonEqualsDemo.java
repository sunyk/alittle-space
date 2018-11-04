/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.October.jdk8.stream2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunyang
 * @date 2018/10/17 11:41
 */
public class PersonEqualsDemo {

    public static void main(String[] args) {
        Person p1 = new Person(1L, "tuhu1001");
        Person p2 = new Person(2L, "tuhu1002");
        Person p3 = new Person(3L, "tuhu1003");
        Person p4 = new Person(4L, "tuhu1004");
        Person p5 = new Person(5L, "tuhu1005");

        List<Person> persons = Arrays.asList(p1,p1,p1,p2,p3,p4,p5,p5);

        /*List<Person> resultList = new ArrayList<>();

        System.out.println(persons);
        persons.stream().forEach(person -> {
            if (!resultList.contains(person)){
                resultList.add(person);
            }
        });
        System.out.println(resultList);*/


        List<Person> result = RemoveStringListDupli.removeDupliById(persons);
        System.out.println(result);

    }
}

