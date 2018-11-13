/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.sunyk.springbootcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author sunyang
 * @date 2018/11/12 17:43
 */
/**
 * 自定义线程池
 */
@EnableAsync
@Configuration
public class TheadPoolConfig {
        @Bean("taskExecutor")
        public Executor taskExecutor(){
            ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
            //核心线程数为10
            taskExecutor.setCorePoolSize(10);
            //最大线程数为20
            taskExecutor.setMaxPoolSize(20);
            //缓存队列大小200
            taskExecutor.setQueueCapacity(200);
            //允许线程池最大空闲60秒
            taskExecutor.setKeepAliveSeconds(60);
            //线程池对拒绝任务的处理策略：当线程池没有处理能力的时候，该策略会直接在execute方法的
            // 调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
            taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            //线程前缀
            taskExecutor.setThreadNamePrefix("taskExecutor-");
            return taskExecutor;
        }
}

