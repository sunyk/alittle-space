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
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 结合FileInputStream 和 FileOutputStream
 *
 * @author sunyang
 * @date 2019/3/11 16:00
 */
public class IoDemo {

    public static void main(String[] args) {
        IoDemo a3 = new IoDemo();
        String filePathOld = "d:/iotest/timg.gif";
        String filePathNew = "d:/iotest/1551955538809.png";
        a3.copyFile(filePathOld, filePathNew);

    }

    /**
     * 文件复制
     */
    public void copyFile(String filePath_old, String filePath_new){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(filePath_old);
            int size = fis.available();
            byte[] array =  new byte[size];
            fis.read(array);
            fos = new FileOutputStream(filePath_new);
            fos.write(array);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

