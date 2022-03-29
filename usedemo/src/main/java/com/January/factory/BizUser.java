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
 * @date 2019/1/30 10:32
 */
public class BizUser {

    public String getShowMoreNum(Long showNumRedis) {
        /*String  result= String.valueOf(showNumRedis);
        if (showNumRedis >= 10 && showNumRedis <= 99){
            String code = String.valueOf(showNumRedis);
            String first = code.substring(0, 1);
            result = first + "0+";
        }else if (showNumRedis >= 100 && showNumRedis <=999){
            String code = String.valueOf(showNumRedis);
            String first = code.substring(0, 1);
            result = first + "00+";
        }else if (showNumRedis >= 1000 && showNumRedis <=9999){
            String code = String.valueOf(showNumRedis);
            String first = code.substring(0, 1);
            result = first + "000+";
        }else if (showNumRedis > 9999){
            result = "9999+";
        }else{
            result= String.valueOf(showNumRedis);
        }
        return result;*/
        ExecutorFactory executorFactory = new ExecutorFactory();
        AbstractBizUser2 bizUser2 = executorFactory.getExecutor(showNumRedis);
        return bizUser2.process(showNumRedis);
    }
}

