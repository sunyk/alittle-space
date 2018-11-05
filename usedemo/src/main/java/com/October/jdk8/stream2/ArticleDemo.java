/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.October.jdk8.stream2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sunyang
 * @date 2018/10/16 13:45
 */
public class ArticleDemo {

    private static List<Article> articles = new ArrayList<>();

    static {
        Article a1 = new Article("Hello wrold","sunyk", Arrays.asList("Hello","World","sunyk"),"CN","GD");
        Article a2 = new Article("Thank you teacher", "Bruce", Arrays.asList("Thank", "you", "teacher", "Bruce"), "CN",
                "GX");
        Article a3 = new Article("Work is amazing", "Tom", Arrays.asList("Work", "amazing", "Tom"), "CN", "GD");
        Article a4 = new Article("New City", "Lucy", Arrays.asList("New", "City", "Lucy", "Good"), "US", "OT");
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        articles.add(a4);
    }

    //使用普通的分组方式进行分组：
    /**
     * 通过for循环逻辑，编程上会麻烦点，但是效率上高很多
     */
    private static void groupByCountryAndProvince_byNormal() {
        Map<String, Map<String, List<Article>>> result = new HashMap<String, Map<String, List<Article>>>();
        for (Article article : articles) {
            Map<String, List<Article>> pMap = result.get(article.getCountryCode());
            if(pMap==null) {
                pMap = new HashMap<String, List<Article>>();
                result.put(article.getCountryCode(), pMap);
            }
            List<Article> list = pMap.get(article.getProvince());
            if(list==null) {
                list = new ArrayList<Article>();
                pMap.put(article.getProvince(), list);
            }
            list.add(article);
        }
        result.forEach((cc, map) -> {
            System.out.println("Country Code is:" + cc);
            map.forEach((pc, list) -> {
                System.out.println("    Province Code is:" + pc);
                list.forEach((article) -> {
                    System.out.println("        Article titile is:" + article.getTitle() + ",author is:"
                            + article.getAuthor());
                });
            });
        });
    }

    //使用串行流的方式进行分组：
    /**
     * 以串行流的方式，通过Collectors做多维度的分组，非常方便，但是性能上很差
     */
    private static void groupByCountryAndProvince() {
        Map<String, Map<String, List<Article>>> result = articles.stream()
                .collect(Collectors.groupingBy(Article::getCountryCode,
                        Collectors.groupingBy(Article::getProvince)));
        result.forEach((cc, map) -> {
            System.out.println("Country Code is:" + cc);
            map.forEach((pc, list) -> {
                System.out.println("    Province Code is:" + pc);
                list.forEach((article) -> {
                    System.out.println("        Article titile is:" + article.getTitle() + ",author is:"
                            + article.getAuthor());
                });
            });
        });
    }

    //使用并行流的方式进行分组：
    /**
     * 以并行流的方式，通过Collectors做多维度的分组，性能上比串行流的效率就高很多了
     * 实现方式也很简单，只需要将stream()修改为parallelStream()实现。
     */
    private static void groupByCountryAndProvinceParallel() {
        Map<String, Map<String, List<Article>>> result = articles.parallelStream()
                .collect(Collectors.groupingBy(Article::getCountryCode,
                        Collectors.groupingBy(Article::getProvince)));
        result.forEach((cc, map) -> {
            System.out.println("Country Code is:" + cc);
            map.forEach((pc, list) -> {
                System.out.println("    Province Code is:" + pc);
                list.forEach((article) -> {
                    System.out.println("        Article titile is:" + article.getTitle() + ",author is:"
                            + article.getAuthor());
                });
            });
        });
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        groupByCountryAndProvince();
        long end = System.currentTimeMillis();
        System.out.println("串行流分组使用时长（毫秒）:" + (end - start)+"\n");

        start = System.currentTimeMillis();
        groupByCountryAndProvinceParallel();
        end = System.currentTimeMillis();
        System.out.println("并行流分组使用时长（毫秒）:" + (end - start)+"\n");

        start = System.currentTimeMillis();
        groupByCountryAndProvince_byNormal();
        end = System.currentTimeMillis();
        System.out.println("普通分组使用时长（毫秒）:" + (end - start));
    }


}

