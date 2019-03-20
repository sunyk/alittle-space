/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.carfactory;

import com.March.dubbo.Car;

/**
 * 车工厂
 * @author sunyang
 * @date 2019/3/14 15:41
 */
public interface CarFactory {

    /**
     * 造车
     * @return
     */
    Car carMaker();



}

