/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.March.io;

import com.January.out.FileOutputStreamDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sunyang
 * @date 2019/3/11 16:17
 */
public class FileOutStreamDemo {

    public static void main(String[] args) {
        FileOutStreamDemo fileOutputStreamDemo = new FileOutStreamDemo();
        String filePath = "d:/iotest/abc.txt";
        String content = "我是新加入的testcontent";
        fileOutputStreamDemo.writeFile(filePath, content);
    }

    public void writeFile(String filePath, String content){

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(filePath);
            byte[] array = content.getBytes();
            fos.write(array);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

