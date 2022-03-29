/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.sunyk.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 抽象类 日志切面
 *
 * @author sunyang
 * @date 2018/12/19 14:30
 */
public abstract class AbstractControllerLogAspect {

    private static final Logger log = LoggerFactory.getLogger(AbstractControllerLogAspect.class);
    protected static Set<Integer> unNoticeExceptionCodes = new HashSet();
    private ThreadLocal<Long> threadLocal = new ThreadLocal();

    public AbstractControllerLogAspect() {
    }

    public abstract void controllerLog();

    @Before("controllerLog()&& @annotation(logAnnotation)")
    public void doBefore(JoinPoint joinPoint, ControllerLogAspectAnnotation logAnnotation) throws Throwable {
        if (logAnnotation.isPrintPostData()) {
            log.info(logAnnotation.description() + "开始调用：" + "requestData={}", joinPoint.getArgs());
        }

        if (logAnnotation.isPrintSpendTime()) {
            this.threadLocal.set(System.currentTimeMillis());
        }

    }

    @After("controllerLog()&& @annotation(logAnnotation)")
    public void doAfter(JoinPoint joinPoint, ControllerLogAspectAnnotation logAnnotation) throws Throwable {
    }

    @AfterReturning(
            returning = "result",
            value = "controllerLog()&& @annotation(logAnnotation)"
    )
    public void doAfterReturning(JoinPoint joinPoint, Object result, ControllerLogAspectAnnotation logAnnotation) throws Throwable {
        if (logAnnotation.isPrintResultData()) {
            log.info(logAnnotation.description() + "结束调用：" + "result={}", result);
        }

        if (logAnnotation.isPrintSpendTime()) {
            log.info(logAnnotation.description() + "总用时：" + (System.currentTimeMillis() - ((Long)this.threadLocal.get()).longValue()) + "毫秒");
            this.threadLocal.remove();
        }

    }


}

