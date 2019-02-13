/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.January.factory;

/**
 * @author sunyang
 * @date 2019/1/30 12:32
 */
public class BizUserDemo {

    public static void main(String[] args) {
        long showNum = 1111;
        BizUser bizUser = new BizUser();
        String result = bizUser.getShowMoreNum(showNum);
        System.out.println("工厂模式实战后的结果 result：" + result);
    }
}

