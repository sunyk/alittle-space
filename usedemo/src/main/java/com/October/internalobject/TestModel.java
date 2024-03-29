/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.internalobject;

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

