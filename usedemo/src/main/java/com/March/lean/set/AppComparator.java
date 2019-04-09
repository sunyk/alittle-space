/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.lean.set;

import java.util.Comparator;

/**
 * @author sunyang
 * @date 2019/3/20 20:38
 */
public class AppComparator implements Comparator<App2> {

    @Override
    public int compare(App2 app1, App2 app2) {
        int num = app1.getAge() - app2.getAge();
        //先比较年龄，年龄若相同在比较名字长度
        return num == 0 ? app1.getName().length() - app2.getName().length() : num;
    }
}

