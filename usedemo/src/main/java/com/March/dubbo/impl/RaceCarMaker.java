/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.dubbo.impl;

import com.March.dubbo.*;

/**
 * @author sunyang
 * @date 2019/3/14 11:43
 */
public class RaceCarMaker implements CarMaker{

    WheelMarker wheelMarker;
    CarModelMarker carModelMarker;

    public void setWheelMarker(WheelMarker wheelMarker) {
        this.wheelMarker = wheelMarker;
    }

    public void setCarModelMarker(CarModelMarker carModelMarker) {
        this.carModelMarker = carModelMarker;
    }

    //跑车制造
    @Override
    public Car makeCar(URL url) {
        //先造个轮子
        Wheel wheel = wheelMarker.makeWheel(url);
        CarModel carModel= carModelMarker.makeCarModel();
        return new RaceCar(wheel, carModel);
    }


}

