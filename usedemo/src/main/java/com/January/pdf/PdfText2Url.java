/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.January.pdf;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


/**
 * @author sunyang
 * @date 2019/1/24 14:40
 */
public class PdfText2Url {

    public static void main(String[] args) {
        try {
//            readPdf("D:\\知识库文档\\2016最新PMBOK第五版中文完整版.pdf");
            readPdf("https://img1.tuhu.org/tech/file/9bd7/733b/7ef54fbf672cfffaf2b1a6c2.pdf");
        }catch (Exception e){

        }
    }

    /**
     * 传入一个.pdf文件
     * @param file
     * @throws Exception
     */
    public static void readPdf(String file) throws Exception {
        // 是否排序
        boolean sort = false;
        // pdf文件名
        String pdfFile = file;
        // 输入文本文件名称
        String textFile = null;
        // 编码方式
        String encoding = "UTF-8";
        // 开始提取页数
        int startPage = 1;
        // 结束提取页数
//        int endPage = Integer.MAX_VALUE;
        // 内存中存储的PDF Document
        PDDocument pdDocument = null;
        //输入流
        InputStream inputStream = null;
        try {
            try {
                // 首先当作一个URL来装载文件，如果得到异常再从本地文件系统//去装载文件
                URL url = new URL(pdfFile);
                URLConnection con = url.openConnection();
                con.setConnectTimeout(3 * 1000);
                inputStream = con.getInputStream();
                pdDocument = PDDocument.load(inputStream);

            } catch (MalformedURLException e) {

            }

            // 获取页码
            int endPage = pdDocument.getNumberOfPages();
            PDFTextStripper stripper = null;
            stripper = new PDFTextStripper();
            // 设置是否排序
            stripper.setSortByPosition(sort);
            // 设置起始页
            stripper.setStartPage(startPage);
            // 设置结束页
            stripper.setEndPage(endPage);
            System.out.println(stripper.getText(pdDocument));
            System.out.println(textFile + " 输出成功！");
        } finally {
            if (inputStream != null) {
                // 关闭输出流
                inputStream.close();
            }
            if (pdDocument != null) {
                // 关闭PDF Document
                pdDocument.close();
            }
        }
    }

}

