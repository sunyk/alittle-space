/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.springbootcore.annotation;

import java.lang.annotation.*;

/**
 * 日志切面注解
 *
 * @author sunyang
 * @date 2018/12/19 10:19
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.TYPE, ElementType.METHOD})
public @interface LogAspectAnnotation {
    //描述
    String desc() default "";
    //是否打印请求参数
    boolean isPrintPostData() default true;
    //是否打印异常
    boolean isPrintThrowing() default true;
    //是否打印耗时
    boolean isPrintSpendTime() default false;
    //默认值
    String value()default "";


}

