/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.internalobject;

import java.util.Date;

/**
 * @author sunyang
 * @date 2018/10/10 9:56
 */
public class TestModel {

    private Date createTime;

    public Date getCreateTime() {
        return (Date) createTime.clone();
    }

    public void setCreateTime(Date createTime) {
//        this.createTime = (Date) createTime.clone();
        this.createTime = (Date) createTime.clone();
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "createTime=" + createTime +
                '}';
    }
}

