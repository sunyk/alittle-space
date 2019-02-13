/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.January.factory;

/**
 * 继续用if-else, 只代码剥离
 *
 * @author sunyang
 * @date 2019/1/30 10:41
 */
public class BizUser1 {

    private String getShowMoreNum(Long showNumRedis) {
        String  result= String.valueOf(showNumRedis);
        AbstractBizUser2 executor;
        if (showNumRedis >= 10 && showNumRedis <= 99){
//            result = processOneShow(showNumRedis);
            //工厂模式
            executor = new ShowOneExecutor();
        }else if (showNumRedis >= 100 && showNumRedis <=999){
//            result = processTwoShow(showNumRedis);
            executor = new ShowTwoExecutor();
        }else if (showNumRedis >= 1000 && showNumRedis <=9999){
//            result = processThreeShow(showNumRedis);
            executor = new ShowThreeExecutor();
        }else if (showNumRedis > 9999){
//            result = processFourShow();
            executor = new ShowFourExecutor();
        }else{
//            result = processOtherShow(showNumRedis);
            executor = new ShowOtherExecutor();
        }
        return executor.process(showNumRedis);
//        return result;
    }

    private String processOtherShow(Long showNumRedis) {
        String result;
        result= String.valueOf(showNumRedis);
        return result;
    }

    private String processFourShow() {
        String result;
        result = "9999+";
        return result;
    }

    private String processThreeShow(Long showNumRedis) {
        String result;
        String code = String.valueOf(showNumRedis);
        String first = code.substring(0, 1);
        result = first + "000+";
        return result;
    }

    private String processTwoShow(Long showNumRedis) {
        String result;
        String code = String.valueOf(showNumRedis);
        String first = code.substring(0, 1);
        result = first + "00+";
        return result;
    }

    private String processOneShow(Long showNumRedis) {
        String result;
        String code = String.valueOf(showNumRedis);
        String first = code.substring(0, 1);
        result = first + "0+";
        return result;
    }
}

