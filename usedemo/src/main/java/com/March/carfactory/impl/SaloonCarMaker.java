/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.carfactory.impl;

import com.March.carfactory.CarFactory;
import com.March.dubbo.Car;
import com.March.dubbo.CarModel;
import com.March.dubbo.Wheel;

/**
 * @author sunyang
 * @date 2019/3/14 17:41
 */
public class SaloonCarMaker implements CarFactory {

    SaloonCarWheel saloonCarWheel;
    SaloonCarModel saloonCarModel;

    public SaloonCarMaker(SaloonCarWheel saloonCarWheel, SaloonCarModel saloonCarModel) {
        this.saloonCarWheel = saloonCarWheel;
        this.saloonCarModel = saloonCarModel;
    }

    @Override
    public Car carMaker() {
        Wheel wheel = saloonCarWheel.makeWheel();
        CarModel carModel = saloonCarModel.makeCarModel();
        System.out.println("车已经制造完成。。。轮子："+ wheel.getWheelName() + ",车身："+ carModel.getCarModelName());
        return null;
    }
}

