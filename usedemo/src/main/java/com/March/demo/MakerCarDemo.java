/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.March.demo;

import com.March.carfactory.impl.RaceCarMaker;
import com.March.carfactory.impl.RaceCarModel;
import com.March.carfactory.impl.RaceCarWheel;

/**
 * @author sunyang
 * @date 2019/3/14 17:25
 */
public class MakerCarDemo {


    public static void main(String[] args) {

        RaceCarWheel raceCarWheel =  new RaceCarWheel();
        RaceCarModel raceCarModel = new RaceCarModel();
        new RaceCarMaker(raceCarWheel, raceCarModel).carMaker();
    }
}

