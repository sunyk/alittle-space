/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author sunyang
 * @date 2019/3/11 15:47
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {
        FileInputStreamDemo fileInputStreamDemo = new FileInputStreamDemo();
        String  result = fileInputStreamDemo.readFile("D:/iotest/abc.txt");
        System.out.printf(result);
    }

    public String readFile(String filePath){
        FileInputStream fis = null;
        String result = "";

        try {
            fis = new FileInputStream(filePath);
            int size = fis.available();
            byte[] array = new byte[size];
            fis.read(array);
            result = new String(array);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}

