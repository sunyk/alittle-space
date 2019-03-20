/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.carfactory.impl;

import com.March.carfactory.CarModelMarker;
import com.March.dubbo.CarModel;

/**
 * @author sunyang
 * @date 2019/3/14 17:11
 */
public class SaloonCarModel implements CarModelMarker {
    @Override
    public CarModel makeCarModel() {
        CarModel carModel = new CarModel();
        carModel.setCarModelName("小轿车车身");
        return carModel;
    }
}

