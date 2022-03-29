/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.January.input;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author sunyang
 * @date 2019/1/24 17:12
 */
public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream is = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0111;
            }
        };

        System.out.println(is.read());
        is.close();
    }
}

