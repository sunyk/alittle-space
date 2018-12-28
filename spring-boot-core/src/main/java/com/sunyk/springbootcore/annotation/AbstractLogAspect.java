/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.springbootcore.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志切面抽象类
 *
 * @author sunyang
 * @date 2018/12/19 10:28
 */
public abstract class AbstractLogAspect {
    private static final Logger log = LoggerFactory.getLogger(AbstractLogAspect.class);

    public AbstractLogAspect(){}

    public abstract void controllerLog();

    //操作之前的逻辑
    @Before("controllerLog() && @annotation(logAnnotation)")
    public void doBefore(JoinPoint joinPoint, LogAspectAnnotation logAspectAnnotation) throws Throwable{
        if (logAspectAnnotation.isPrintPostData()){
            log.info(logAspectAnnotation.desc() + "开始调用：" + "requestData = {}", joinPoint.getArgs());
        }
    }

}

