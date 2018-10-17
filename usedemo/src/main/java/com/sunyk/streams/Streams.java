/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.streams;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author sunyang
 * @date 2018/9/30 9:29
 */
public class Streams {

    public enum Status{
        OPEN,CLOSED
    }

    public static final class Task{
        public final Status status;
        public final Integer points;

        public Task(final Status status,final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }





}

