/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April;

import java.io.*;

/**
 * @author sunyang
 * @date 2019/4/8 13:59
 */
public class StreamDemo {

    public static void main(String[] args) throws Exception {
        File f = new File("d:\\file.txt");

        /*FileOutputStream fos = new FileOutputStream(f);
        OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
        writer.append("中文输入");
        writer.append("\r\n");
        writer.append("Intersing Ee");
        writer.close();
        fos.close();*/

        FileInputStream fis = new FileInputStream(f);
        InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()){
            sb.append((char) reader.read());
        }
        System.out.println(sb.toString());
        reader.close();
        fis.close();



    }
}

