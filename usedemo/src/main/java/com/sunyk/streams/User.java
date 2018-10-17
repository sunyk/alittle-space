/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.streams;

import java.util.List;

/**
 * @author sunyang
 * @date 2018/10/12 10:14
 */
public class User {
    private Integer id;
    private String type;
    private String name;
    private boolean selected;

    public User(){}
    public User(Integer id,String type,String name){
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public List<User> initWithAllData() {
        return null;
    }

    public List<User> initWithSmallData() {
        return null;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }
}

