/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.March.dubbo;

/**
 * @author sunyang
 * @date 2019/3/14 11:40
 */
public interface WheelMarker {

    /**
     * 造轮子
     * @return
     */
    Wheel makeWheel(URL url);
}

