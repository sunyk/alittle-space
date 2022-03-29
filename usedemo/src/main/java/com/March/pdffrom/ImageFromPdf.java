/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.March.pdffrom;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

/**
 * @author sunyang
 * @date 2019/3/11 18:30
 */
public class ImageFromPdf {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://img1.SunAd.org/tech/file/823b/1ff3/74f06f087a20414ea254805a.pdf");
        URLConnection con = url.openConnection();
        con.setConnectTimeout(3 * 1000);
        InputStream inputStream = con.getInputStream();
        PDDocument pdDocument = PDDocument.load(inputStream);

        int pageSize = pdDocument.getNumberOfPages();
        System.out.println("page---------" + pageSize);
        int count = 0;
        for (int i = 0; i < pageSize; i++) {
            PDPage page = pdDocument.getPage(i);
            if (null != page){
                PDResources resources = page.getResources();
                Iterable xObjectNames = resources.getXObjectNames();
                if (xObjectNames != null){
                    Iterator imageIter = xObjectNames.iterator();
                    while (imageIter.hasNext()){
                        COSName key = (COSName) imageIter.next();
                        if (resources.isImageXObject(key)){
                            FileOutputStream fos = null;
                            InputStream input = null;
                            try {
                               PDImageXObject image  =  (PDImageXObject) resources.getXObject(key);
                                System.out.println(image);
                                //Thumbnails.of(image.getImage()).scale(0.9).toFile(new File("D:\\pdf\\"+System.currentTimeMillis()+".jpg"));
                                File file = new File("d:/iotest/img/"+System.currentTimeMillis()+".jpg" );
                                fos = new FileOutputStream(file);
                                input = image.createInputStream();
                               byte[] array = new byte[input.available()];
                               int byteCount = 0;
                               while ((byteCount = input.read(array)) != -1){
                                   fos.write(array, 0 , byteCount);
                               }
                            }catch (Exception e){

                            }finally {
                                fos.close();
                                input.close();
                            }
                        }
                        count++;
                    }
                }
            }
        }


    }

}

