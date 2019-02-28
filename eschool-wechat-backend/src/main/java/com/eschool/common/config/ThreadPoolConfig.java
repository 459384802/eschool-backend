package com.eschool.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 * Created by Garden on 2019/1/7.
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);    //核心线程数，初始化线程池时创建的线程数
        executor.setMaxPoolSize(20);     //最大线程数
        executor.setQueueCapacity(200);  //缓冲执行任务的队列
        executor.setKeepAliveSeconds(60);//空闲时间，但超过空闲时间仍未被使用则销毁
        executor.setThreadNamePrefix("taskExecutor-");//线程前缀，用于区分主线程
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//线程池对拒绝任务的处理策略
        executor.setWaitForTasksToCompleteOnShutdown(true);//设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        executor.setAwaitTerminationSeconds(60);//设置线程池中任务的等待时间
        return executor;
    }

}
