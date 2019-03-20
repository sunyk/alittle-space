/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.dubbo;

import com.sun.corba.se.spi.activation.Server;

import java.rmi.RemoteException;

/**
 * @author sunyang
 * @date 2019/3/14 15:24
 */
public interface Transporter {
    @Adaptive({"server", "transport"})
    Server bind(URL url, ChannelHandler handler) throws RemoteException;

    @Adaptive({"client","transport"})
    Client connect(URL url, ChannelHandler handler) throws RemoteException;
}

