/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.demo;

/**
 * @author sunyang
 * @date 2018/9/29 13:34
 */
public class ValuePassDemo {
    public static void main(String[] args) {
        ValuePass valuePass = new ValuePass();
//        Integer tid = valuePass.changeValue();
        Object tid = valuePass.changeObjectVal();
        System.out.println(tid);
    }
}

