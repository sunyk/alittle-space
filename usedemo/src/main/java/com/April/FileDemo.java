/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April;

import java.io.File;

/**
 * @author sunyang
 * @date 2019/4/8 14:42
 */
public class FileDemo {

    public static void main(String[] args) {
        String dirname = "D:\\git-alittle-space\\alittle-space\\usedemo\\src\\main\\java\\com\\April\\File\\File";
        File d = new File(dirname);
//        Boolean s = d.mkdirs();
        if (d.isDirectory()){
            System.out.println("Dir" + dirname);
            String[] s = d.list();
            for (int i= 0;i < s.length;i++){
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()){
                    System.out.println(s[i] + "is a directory");
                }else{
                    System.out.println(s[i] + "is a file");
                }
            }
        }else{
            System.out.println(dirname + "is not a directory");
        }



    }
}

