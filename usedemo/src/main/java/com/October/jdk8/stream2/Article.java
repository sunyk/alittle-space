/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.jdk8.stream2;

import java.util.List;

/**
 * @author sunyang
 * @date 2018/10/16 13:42
 */
public class Article {

    private String title;

    private String author;

    private List<String> tags;

    private String countryCode;

    private String province;

    public Article(String title, String author, List<String> tags, String countryCode, String province) {
        this.title = title;
        this.author = author;
        this.tags = tags;
        this.countryCode = countryCode;
        this.province = province;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}

