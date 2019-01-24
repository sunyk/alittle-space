/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.January.out;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author sunyang
 * @date 2019/1/24 16:16
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("D:\\知识库文档\\FpMJB6JocEn9NoTzJffQQTgqAgSQ.txt");
        fos.write(56);
        byte[] abytes = new byte[36];
        fos.write(abytes,1, 10);
        fos.close();
    }
}

