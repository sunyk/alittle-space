/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.aop;

import com.sunyk.annotation.AbstractControllerLogAspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * aop处理对应controller 定义连接点
 * smile example:@Pointcut("execution(* com.tuhu.document.*.controller.*Controller.*(..))")
 *
 * @Aspect 切面
 * @Component 组件
 * @Configuration 配置
 *
 * @author sunyang
 * @date 2018/12/19 15:07
 */

@Aspect
@Component
@Configuration
public class ControllerLogAspect  extends AbstractControllerLogAspect{

    @Override
    @Pointcut("execution(* com.sunyk.*.controller.*Controller.*(..))")
    public void controllerLog() {
    }
}

