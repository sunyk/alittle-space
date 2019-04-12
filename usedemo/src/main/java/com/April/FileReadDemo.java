/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author sunyang
 * @date 2019/4/8 15:10
 */
public class FileReadDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\git-alittle-space\\alittle-space\\usedemo\\src\\main\\java\\com\\April\\File\\File\\File\\Hello1.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("This \n is \n an \n example\n");
        writer.flush();
        writer.close();

        FileReader reader = new FileReader(file);
        char[] a =  new char[50];
        reader.read(a);
        for (char c:a){
            System.out.print(c);
        }
        reader.close();
    }
}

