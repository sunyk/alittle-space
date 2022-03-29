/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.January.factory;

/**
 * 定义一个工厂来把需要处理逻辑给包起来
 *
 * @author sunyang
 * @date 2019/1/30 11:21
 */
public class ExecutorFactory {

    public AbstractBizUser2 getExecutor(Long showNumRedis){
        if (showNumRedis >= 10 && showNumRedis <= 99){
            return new ShowOneExecutor();
        }else if (showNumRedis >= 100 && showNumRedis <=999){
            return new ShowTwoExecutor();
        }else if (showNumRedis >= 1000 && showNumRedis <=9999){
            return new ShowThreeExecutor();
        }else if (showNumRedis > 9999){
            return new ShowFourExecutor();
        }else{
            return new ShowOtherExecutor();
        }
    }
}

