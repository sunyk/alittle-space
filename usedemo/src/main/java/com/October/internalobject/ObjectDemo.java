/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.internalobject;

import java.util.Calendar;
import java.util.Date;

/**
 * @author sunyang
 * @date 2018/10/10 9:56
 */
public class ObjectDemo {
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "createTime=" + createTime +
                '}';
    }
}

