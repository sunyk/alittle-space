/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * @author sunyang
 * @date 2019/3/11 17:25
 */
public class ImageIODemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://img1.tuhu.org/tech/pic/efcc/e5a6/698299b038d210b73c48974f_w400_h400.jpg");
//            File file = new File("d:/iotest/newpig/1.jpg");
//            BufferedImage image = ImageIO.read(new File("D:/iotest/1551955538809.jpg"));
            BufferedImage image = ImageIO.read(url);
            File newFile = new File("d:/iotest/newpig/3.jpg");
            if (!newFile.exists()){
                newFile.createNewFile();
            }
            ImageIO.write(image, "jpg", newFile);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }

    }
}

