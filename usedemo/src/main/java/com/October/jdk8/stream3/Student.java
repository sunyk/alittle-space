/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.jdk8.stream3;

/**
 * @author sunyang
 * @date 2018/11/23 10:22
 */
public class Student {

    private String name;

    private Integer score;

    private Integer cource;

    public Student(String name, Integer score, Integer cource) {
        this.name = name;
        this.score = score;
        this.cource = cource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCource() {
        return cource;
    }

    public void setCource(Integer cource) {
        this.cource = cource;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", cource=" + cource +
                '}';
    }
}

