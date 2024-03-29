/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.March.carfactory;

import com.March.dubbo.Wheel;

/**
 * @author sunyang
 * @date 2019/3/14 16:20
 */
public interface WheelMarker {

    /**
     * 制造轮子
     * @return
     */
    Wheel makeWheel();
}

