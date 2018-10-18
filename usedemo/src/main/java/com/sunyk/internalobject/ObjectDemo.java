/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.internalobject;

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
