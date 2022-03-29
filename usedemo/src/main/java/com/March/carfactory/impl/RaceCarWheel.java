/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.March.carfactory.impl;

import com.March.carfactory.WheelMarker;
import com.March.dubbo.Wheel;

/**
 * @author sunyang
 * @date 2019/3/14 17:07
 */
public class RaceCarWheel implements WheelMarker {
    @Override
    public Wheel makeWheel() {
        Wheel wheel = new Wheel();
        wheel.setWheelName("跑车轮胎");
        return wheel;
    }
}

