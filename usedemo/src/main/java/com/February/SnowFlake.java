/*
 * Copyright 2019 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.February;

/**
 * twitter的snowFlake算法
 *
 * @author sunyang
 * @date 2019/2/22 13:07
 */
public class SnowFlake {

    /**
     * 起初的时间戳
     */

    private static final long START_STMP = 1550812123L;

    /**
     * 每一部分占用的位数
     * 序列号占用位数
     * 机器标识占用位数
     * 数据中心占用位数
     */
    private static final long SEQUENCE_BIT = 12;
    private static final long MACHINE_BIT = 5;
    private static final long DATACENTER_BIT = 5;

    /**
     * 每一部分的最大值
     */
    private static final long MAX_SEQUENCE_NUM = -1L ^ (-1L << SEQUENCE_BIT);
    private static final long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private static final long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);

    /**
     * 每一部分向左的位移
     */
    private static final long MACHINE_LEFT = SEQUENCE_BIT;
    private static final long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private static final long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    //数据中心
    private long datacenterId;
    //机器标识
    private long machineId;
    //序列号
    private long sequence = 0L;
    //上一次时间戳
    private long lastStmp = -1L;

    public SnowFlake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0){
            throw new IllegalArgumentException("传入数据中心参数有误");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0){
            throw new IllegalArgumentException("传入机器标识参数有误");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 生产下一个ID
     */
    public synchronized long nextId(){
        //获取新的时间戳
        long currStmp = getNewstmp();
        if (currStmp < lastStmp){
            throw new RuntimeException("不允许向后生成ID");
        }
        if (currStmp == lastStmp){
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE_NUM;
            if (sequence == 0L){
                //同一毫秒的序列数已经达到最大,获得下一个时间戳
                currStmp = getNextMill();
            }
        }else{
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }
        lastStmp = currStmp;
        /**
         * 时间戳部分
         * 数据中心部分
         * 机器标识部分
         * 序列号部分
         */
        return (currStmp - START_STMP) << TIMESTMP_LEFT
                | datacenterId << DATACENTER_LEFT
                | machineId << MACHINE_LEFT
                | sequence;
    }

    private long getNextMill() {
        //获得新的时间戳
        long mill = getNewstmp();
        while (mill <= lastStmp){
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

}

