/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.io;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author sunyang
 * @date 2019/3/11 16:52
 */
public class BufferedImageDemo {

    public static void main(String[] args) {
        File image = new File("d:/iotest/1551955538809.png");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(image);
            File newFile = new File("d:/iotest/newpig/1.gif");
            if (!newFile.exists()){
                newFile.createNewFile();
            }
            fos = new FileOutputStream(newFile);
            int n = 0;
            int size = fis.available();
            System.out.println("--------------------size:"+ size);
            byte[] array = new byte[size];
            while ((n = fis.read(array)) != -1){
                fos.write(array, 0 , n);
            }
//            BufferedImage bi = ImageIO.read(image);
//            Iterator writers = ImageIO.getImageWritersByFormatName("png");
//            ImageWriter writer = (ImageWriter) writers.next();
//            ImageOutputStream ios =  ImageIO.createImageOutputStream(image);
//            writer.setOutput(ios);
//            ImageIO.write(reader, "png", image);

        } catch (IOException e) {
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

