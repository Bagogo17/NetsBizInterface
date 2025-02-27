package com.nets.netsbiz.qri.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class ThreadPoolConfig implements SchedulingConfigurer {

    @Value("${thread.pool}")
    private int numberOfPool;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(taskScheduler());
    }

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
     ThreadPoolTaskScheduler threadPoolTaskExecutor = new ThreadPoolTaskScheduler();
     threadPoolTaskExecutor.setThreadNamePrefix("netsbiz-qr-thread-");
     threadPoolTaskExecutor.setPoolSize(4);
     threadPoolTaskExecutor.initialize();
     return  threadPoolTaskExecutor;
    }

//    @Bean
//    public TaskScheduler taskScheduler(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
//        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
//        scheduler.setPoolSize(numberOfPool);
//        scheduler.setThreadNamePrefix("netsbizqr-thread-");
//        scheduler.setThreadFactory(threadPoolTaskExecutor);
//        scheduler.initialize();
//        return scheduler;
//    }
}
