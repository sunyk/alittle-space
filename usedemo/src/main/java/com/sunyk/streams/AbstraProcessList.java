/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.streams;

import java.util.List;

/**
 * @author sunyang
 * @date 2018/10/15 19:23
 */
public abstract class AbstraProcessList {
    abstract List processList(List<String> firstArray, List<String> secondList);
}

