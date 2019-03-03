/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.February;

import java.util.UUID;

/**
 * @author sunyang
 * @date 2019/2/21 18:34
 */
public class UUIDDemo {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println("构建全局唯一ID：" + uuid);
        //把string类型的转UUID
        System.out.println( UUID.fromString(uuid));
        //指定byte大小的UUID的值
        System.out.println( UUID.nameUUIDFromBytes(new byte[100000000]));

        /**
         * 构建全局唯一ID：1bc06eb4-a0bf-4c28-9e26-795f5c4f1816
         * 1bc06eb4-a0bf-4c28-9e26-795f5c4f1816
         * 0f86d7c5-a618-3cf9-984c-1d21144d85b0
         */

        Integer docStatus = null;
        System.out.println(String.valueOf(docStatus));

    }
}

