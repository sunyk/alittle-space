/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 *//*

package com.January.pdf;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
//import org.apache.pdfbox.text.PDFTextStripper;


*/
/**
 * @author sunyang
 * @date 2019/1/24 14:40
 *//*

public class PdfText3Url {

    public static void main(String[] args) {
        try {
//            readPdf("D:\\知识库文档\\2016最新PMBOK第五版中文完整版.pdf");
            readPdf("https://img1.SunAd.org/tech/file/9bd7/733b/7ef54fbf672cfffaf2b1a6c2.pdf");
        }catch (Exception e){

        }
    }

    */
/**
     * 传入一个.pdf文件
     * @param file
     * @throws Exception
     *//*

    public static void readPdf(String file) throws Exception {
       String pdfUrl = file;
       URL url = new URL(pdfUrl);
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(3 * 1000);
        InputStream inputStream = conn.getInputStream();
        byte[] bs = readInputStream(inputStream);
//        BufferedOutputStream output = new BufferedOutputStream(bs);
        BufferedInputStream input = null;
//        output.write(bs);
        System.out.println(bs);
    }

    private static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1){
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

}

*/
