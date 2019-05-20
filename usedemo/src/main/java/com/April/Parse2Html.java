/*
 * Copyright 2019 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.April;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunyang
 * @date 2019/4/19 10:45
 */
public class Parse2Html {
    public static void main(String[] args) {
        String html = "<div class='editorContent'><p>根据用户行为查询 根据用户行为查询根据用户行为查询根据用户行为查询根据用户行为查询根据用户行为查询根据用户行为查询根据用户行为查询根据用户行为查询根据用户行为查询根据用户行为查询根据用户行为查询根据用户行为查询&nbsp;</p></div><style>.editorContent {\\n              font-size:16px !important;\\n              font-family:\\\"Microsoft Yahei\\\",\\\"微软雅黑\\\";\\n            }.editorContent p,.editorContent div,.editorContent li,.editorContent ul,.editorContent span{\\n                font-size:16px !important;\\n                font-family:\\\"Microsoft Yahei\\\",\\\"微软雅黑\\\" !important;\\n            }</style>";
        String aa= delHTMLTag(html);
        System.out.println(parsingHTML(aa));
    }

    public static String parsingHTML(String str) {
        String htmlStr = str.replaceAll("</?[^>]+>", "")
                .replaceAll("<a>\\s*|\t|\r|\n</a>", "")
                .replaceAll("&nbsp;","")
                .replaceAll("\\s*", "")
                .replaceAll("\uFFFF","");
        return htmlStr;
    }

    public static String delHTMLTag(String htmlStr){
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        htmlStr=htmlStr.replace(" ","");
        htmlStr=htmlStr.replaceAll("\\s*|\t|\r|\n","");
        htmlStr=htmlStr.replace("“","");
        htmlStr=htmlStr.replace("”","");
        htmlStr=htmlStr.replaceAll("　","");

        return htmlStr.trim(); //返回文本字符串
    }
}

