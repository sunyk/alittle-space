/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.dubbo;

/**
 * @author sunyang
 * @date 2019/3/14 11:37
 */
public interface CarMaker {
    /**
     * 造车接口
     * 加入扩展点
     * @return
     */
    Car makeCar(URL url);
//    Car makeCar();
}

