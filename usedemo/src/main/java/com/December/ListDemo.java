/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunyang
 * @date 2018/12/16 16:23
 */
public class ListDemo {

    public static void main(String[] args) {
        String rangeLabel = "标签1";
        String rangeLabel2 = "标签2";
        List<MaybeList> result =  new ArrayList<>();
        List<String> labels = Arrays.asList("标签1","标签2","标签3","标签4","标签5");
        List<String> labelRange = Arrays.asList("标签1","标签2","标签3","标签4","标签5");
        for (int i = 0; i < 1; i++) {
            MaybeList curr =  new MaybeList();
            curr.setId(150);
            curr.setTitle("title"+i);
            labels.forEach(s -> {
                if (labelRange.contains(s)){
                    curr.setLabelName(s);
//            result.add(curr);错误用法，此处有坑
                }
            });
            result.add(curr);
        }
        System.out.println(result);
    }


    public static class MaybeList{
        private int id;
        private String title;
        private String labelName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLabelName() {
            return labelName;
        }

        public void setLabelName(String labelName) {
            this.labelName = labelName;
        }

        @Override
        public String toString() {
            return "MaybeList{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", labelName='" + labelName + '\'' +
                    '}';
        }
    }
}

