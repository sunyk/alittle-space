/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.lean.set;

/**
 * @author sunyang
 * @date 2019/3/20 20:15
 */
public class App implements Comparable<App>{

    private String name;

    private Integer age;

    public App() {
    }

    public App(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(App app) {
        //比较name的长度
        int num = this.name.length() - app.name.length();
        //如果name长度一样，则比较年龄的大小
        return num == 0 ? this.age - app.age : num;
    }

    @Override
    public String toString() {
        return "App{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

