/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.demo;

import com.sun.deploy.util.StringUtils;

import java.util.Objects;

/**
 * @author sunyang
 * @date 2018/9/29 13:36
 */
public class ValuePass {

    public Integer changeValue(){
        Integer tid = 0;

        changeSwapValue(tid);
        System.out.println(tid);

        return tid;
    }

    private void changeSwapValue(Integer tid) {
        tid = 10;
        System.out.println(tid);
    }

    public Object changeObjectVal(){
        Object tid = new Object();
        changeSwapObjectVal(tid);
        System.out.println(Objects.hash(tid));
        return tid;
    }

    private void changeSwapObjectVal(Object tid) {
        tid = Integer.valueOf(10);
        System.out.println(tid);
    }
}

