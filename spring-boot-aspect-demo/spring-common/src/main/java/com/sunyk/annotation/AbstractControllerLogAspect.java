/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象类 日志切面
 *
 * @author sunyang
 * @date 2018/12/19 14:30
 */
public abstract class AbstractControllerLogAspect {

    private static final Logger log = LoggerFactory.getLogger(AbstractControllerLogAspect.class);

    public AbstractControllerLogAspect() {
    }

    //定义个抽象的方法
    public abstract void controllerLog();

    //操作之前的逻辑处理
    @Before("controllerLog() && @annotation(controllerLogAspectAnnotation)")
    public void doBefore(JoinPoint joinPoint, ControllerLogAspectAnnotation controllerLogAspectAnnotation) throws Throwable{
        if (controllerLogAspectAnnotation.isPrintPostData()){
            log.info(controllerLogAspectAnnotation.description() + "开始调用：" + "requestData = {}", joinPoint.getArgs());
        }

    }
}

