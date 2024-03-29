/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.March.carfactory.impl;

import com.March.carfactory.CarFactory;
import com.March.dubbo.Car;
import com.March.dubbo.CarModel;
import com.March.dubbo.Wheel;

/**
 * @author sunyang
 * @date 2019/3/14 17:43
 */
public class SuvCarMaker implements CarFactory {

    SuvCarWheel suvCarWheel;
    SuvCarModel suvCarModel;

    public SuvCarMaker(SuvCarWheel suvCarWheel, SuvCarModel suvCarModel) {
        this.suvCarWheel = suvCarWheel;
        this.suvCarModel = suvCarModel;
    }

    @Override
    public Car carMaker() {
        Wheel wheel = suvCarWheel.makeWheel();
        CarModel carModel = suvCarModel.makeCarModel();
        System.out.println("车已经制造完成。。。轮子："+ wheel.getWheelName() + ",车身："+ carModel.getCarModelName());
        return null;
    }
}

