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
 * @date 2019/1/30 11:10
 */
public class ShowOtherExecutor extends AbstractBizUser2 {
    @Override
    public String process(Long showNumRedis) {
        String result;
        result= String.valueOf(showNumRedis);
        return result;
    }
}

