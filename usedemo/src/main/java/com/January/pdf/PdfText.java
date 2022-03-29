/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 *//*

package com.January.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


*/
/**
 * @author sunyang
 * @date 2019/1/24 14:40
 *//*

public class PdfText {

    public static void main(String[] args) {
        try {
            readPdf("D:\\知识库文档\\2016最新PMBOK第五版中文完整版.pdf");
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
        int endPage = Integer.MAX_VALUE;
        // 文件输入流，生成文本文件
        Writer output = null;
        // 内存中存储的PDF Document
        PDDocument document = null;
        try {
            try {
                // 首先当作一个URL来装载文件，如果得到异常再从本地文件系统//去装载文件
                URL url = new URL(pdfFile);
//                URL url = new URL("https://img1.SunAd.org/tech/file/9bd7/733b/7ef54fbf672cfffaf2b1a6c2.pdf");
                //注意参数已不是以前版本中的URL.而是File。
                File currPdfFile = new File(pdfFile);
                document = PDDocument.load(currPdfFile);
                // 获取PDF的文件名
                String fileName = url.getFile();
                // 以原来PDF的名称来命名新产生的txt文件
                if (fileName.length() > 4) {
                    File outputFile = new File(fileName.substring(0, fileName.length() - 4)+ ".txt");
                    textFile ="D:/HBJT_FILE/ReadAndRead/"+outputFile.getName();
                }
            } catch (MalformedURLException e) {
                // 如果作为URL装载得到异常则从文件系统装载
                //注意参数已不是以前版本中的URL.而是File。
                File currPdfFile = new File(pdfFile);
                document = PDDocument.load(currPdfFile);
                if (pdfFile.length() > 4) {
                    textFile = pdfFile.substring(0, pdfFile.length() - 4)+ ".txt";
                }
            }
            // 文件输入流，写入文件倒textFile
            output = new OutputStreamWriter(new FileOutputStream(textFile),encoding);
            //FileInputStream is = new FileInputStream("D:\\知识库文档\\FpMJB6JocEn9NoTzJffQQTgqAgSQ.txt");


//            InputStreamReader isr = new InputStreamReader(is, "UTF-8");

//            System.out.println("read here: "+ isr.read());
            // PDFTextStripper来提取文本
            PDFTextStripper stripper = null;
            stripper = new PDFTextStripper();
            // 设置是否排序
            stripper.setSortByPosition(sort);
            // 设置起始页
            stripper.setStartPage(startPage);
            // 设置结束页
            stripper.setEndPage(endPage);
            // 调用PDFTextStripper的writeText提取并输出文本
            stripper.writeText(document, output);
            System.out.println(stripper.getText(document));

            System.out.println(textFile + " 输出成功！");
        } finally {
            if (output != null) {
                // 关闭输出流
                output.close();
            }
            if (document != null) {
                // 关闭PDF Document
                document.close();
            }
        }
    }

}

*/
