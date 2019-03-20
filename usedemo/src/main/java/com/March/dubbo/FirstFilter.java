/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.dubbo;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

/**
 * @author sunyang
 * @date 2019/3/14 15:35
 */
//@Activate 无条件自动激活
public class FirstFilter extends Filter {
    @Override
    public void doFilter(HttpExchange httpExchange, Chain chain) throws IOException {

    }

    @Override
    public String description() {
        return null;
    }
}

