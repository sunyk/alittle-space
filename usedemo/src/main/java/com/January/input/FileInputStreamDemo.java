/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.January.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author sunyang
 * @date 2019/1/24 17:09
 */
public class FileInputStreamDemo {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("D:\\知识库文档\\FpMJB6JocEn9NoTzJffQQTgqAgSQ.txt");
//        fis.read();
        System.out.println(fis.read());
        fis.close();

    }
}

