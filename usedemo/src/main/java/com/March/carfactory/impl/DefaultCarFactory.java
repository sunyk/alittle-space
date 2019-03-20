/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.carfactory.impl;

import com.March.carfactory.CarFactory;
import com.March.carfactory.CarModelMarker;
import com.March.carfactory.WheelMarker;
import com.March.dubbo.Car;
import com.March.dubbo.CarModel;
import com.March.dubbo.RaceCar;
import com.March.dubbo.Wheel;

/**
 * @author sunyang
 * @date 2019/3/14 16:16
 */
public class DefaultCarFactory implements CarFactory {

    WheelMarker wheelMarker;
    CarModelMarker carModelMarker;

    public void setWheelMarker(WheelMarker wheelMarker) {
        this.wheelMarker = wheelMarker;
    }

    public void setCarModelMarker(CarModelMarker carModelMarker) {
        this.carModelMarker = carModelMarker;
    }

    @Override
    public Car carMaker() {
        Wheel wheel = wheelMarker.makeWheel();
        CarModel carModel = carModelMarker.makeCarModel();
        System.out.println("车已经制造完成。。。轮子："+ wheel.getWheelName() + ",车身："+ carModel.getCarModelName());
        return null;
    }
}

