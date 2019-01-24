/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.January.out;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author sunyang
 * @date 2019/1/24 16:14
 */
public class OutputStreamDemo {

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[36];

        OutputStream ops = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                System.out.println(b);
            }
        };
        ops.write(bytes);
        ops.write(36);

    }
}

