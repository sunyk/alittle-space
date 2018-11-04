/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.October.stringdemo;


import org.apache.commons.lang3.SystemUtils;
import sun.plugin2.util.SystemUtil;

/**
 * StringBuilder的demo
 *
 * @author sunyang
 * @date 2018/10/19 14:57
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("user.id = 1");
        builder.append(SystemUtils.JAVA_VM_VERSION);
        builder.append(SystemUtils.LINE_SEPARATOR);
        builder.append("user.name = mercyblitz");
        builder.append(SystemUtils.JAVA_VM_VERSION);
        builder.append(SystemUtils.LINE_SEPARATOR);
        builder.append(SystemUtils.getHostName());
        System.out.println(builder);
    }
}

