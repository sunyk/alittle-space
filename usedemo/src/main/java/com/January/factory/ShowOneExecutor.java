/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.January.factory;

/**
 * @author sunyang
 * @date 2019/1/30 10:57
 */
public class ShowOneExecutor extends AbstractBizUser2{

    @Override
    public String process(Long showNumRedis) {
        String result;
        String code = String.valueOf(showNumRedis);
        String first = code.substring(0, 1);
        result = first + "0+";
        return result;
    }
}

