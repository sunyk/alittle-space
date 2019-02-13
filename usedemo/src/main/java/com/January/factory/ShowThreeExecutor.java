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
 * @date 2019/1/30 11:09
 */
public class ShowThreeExecutor extends AbstractBizUser2 {
    @Override
    public String process(Long showNumRedis) {
        String result;
        String code = String.valueOf(showNumRedis);
        String first = code.substring(0, 1);
        result = first + "000+";
        return result;
    }
}

