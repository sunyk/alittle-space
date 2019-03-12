/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March.pdffrom;

import com.google.common.collect.Lists;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * @author sunyang
 * @date 2019/3/11 19:38
 */
public class ImageDemo {

    public static void main(String[] args) throws Exception{
        URL url = new URL("https://img1.tuhu.org/tech/file/823b/1ff3/74f06f087a20414ea254805a.pdf");
        URLConnection con = url.openConnection();
        con.setConnectTimeout(3 * 1000);
        InputStream inputStream = con.getInputStream();
        PDDocument pdDocument = PDDocument.load(inputStream);

        PDFRenderer pdfRenderer = new PDFRenderer(pdDocument);
        List<BufferedImage> picList = Lists.newArrayList();
        int pageNum = pdDocument.getNumberOfPages();
        for (int i = 0; i < pageNum; i++) {
            picList.add(pdfRenderer.renderImageWithDPI(i,200f, ImageType.ARGB));
        }
        for (BufferedImage bufferedImage : picList){
            File file = new File("d:/iotest/img/"+System.currentTimeMillis()+".png" );
            ImageIO.write(bufferedImage, "png", file );
        }
        pdDocument.close();
    }
}

