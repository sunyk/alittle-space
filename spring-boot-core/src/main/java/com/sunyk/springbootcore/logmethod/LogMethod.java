/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.springbootcore.logmethod;

import com.sunyk.springbootcore.annotation.LogAspectAnnotation;

/**
 * @author sunyang
 * @date 2018/12/19 11:20
 */
public class LogMethod {

    @LogAspectAnnotation(desc = "测试日志方法---", isPrintPostData = true)
    public void doLog(){
        System.out.println("开始执行日志操作方法-----");

    }
}

