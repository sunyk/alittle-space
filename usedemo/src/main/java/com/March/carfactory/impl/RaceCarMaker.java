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
 * @date 2019/3/14 17:36
 */
public class RaceCarMaker implements CarFactory {

    RaceCarWheel raceCarWheel;

    RaceCarModel raceCarModel;

    public RaceCarMaker() {
    }

    public RaceCarMaker(RaceCarWheel raceCarWheel, RaceCarModel raceCarModel) {
        this.raceCarWheel = raceCarWheel;
        this.raceCarModel = raceCarModel;
    }

    @Override
    public Car carMaker() {
        Wheel wheel = raceCarWheel.makeWheel();
        CarModel carModel = raceCarModel.makeCarModel();
        System.out.println("车已经制造完成。。。轮子："+ wheel.getWheelName() + ",车身："+ carModel.getCarModelName());
        return null;
    }
}

