/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.December;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunyang
 * @date 2018/12/14 14:08
 */
public class LabelRangeDeo {

    public static void main(String[] args) {
        List<String> labelNameRange = Arrays.asList("消刹车灯", "消胎压灯", "消保养灯");
        String curr = "消刹车灯1";
        if (labelNameRange.contains(curr)){
            System.out.println("范围包含qq"+ curr);
        }
        if (curr.contains(labelNameRange.toString())){
            System.out.println("范围包含111"+ curr);
        }
    }
}

