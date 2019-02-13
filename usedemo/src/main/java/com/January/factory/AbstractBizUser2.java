/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.January.factory;

/**
 * 工厂模式
 * 从代码看的出来，不同的条件下，执行的逻辑是不同的，那么可以把这种执行逻辑抽象出来
 * 用多态的概念来定义不同的执行方式
 *
 * @author sunyang
 * @date 2019/1/30 10:51
 */
public abstract class AbstractBizUser2 {

    /**
     * 处理展示
     * @param showNumRedis 展示数量
     * @return
     */
    public abstract String process(Long showNumRedis);

}

