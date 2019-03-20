/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.March;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author sunyang
 * @date 2019/3/13 15:07
 */
public class URLDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String detailUrl = "测试122";
        String s = URLEncoder.encode(detailUrl, "utf-8");
        System.out.println("tuhu:///webView?url=https://kb.tuhu.work/customer-service/#/content/?docId=855&title="+s);

        System.out.println("".substring(0,0));
    }
}

