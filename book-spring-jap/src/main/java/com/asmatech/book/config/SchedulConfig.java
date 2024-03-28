package com.asmatech.book.config;

import java.util.concurrent.Executor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

//  https://www.linkedin.com/pulse/asynchronous-calls-spring-boot-using-async-annotation-omar-ismail/?trackingId=SOITOnZTd7lkqgCTxFvsBg%3D%3D

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
@EnableAsync  //for us Multi-Threading
public class SchedulConfig  implements AsyncConfigurer {

	//for method Level
	@Bean(name = "threadPoolTaskExecutor")
	public Executor asyncExecutor() {
	   ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	   executor.setCorePoolSize(4);
	   executor.setMaxPoolSize(4);
	   executor.setQueueCapacity(50);
	   executor.setThreadNamePrefix("AsynchThread::");
	   executor.initialize();
	   return executor;
	
	}
	
	//For Application Level
	@Override
	 public Executor getAsyncExecutor() {
	  ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
	  taskExecutor.setCorePoolSize(4);
	  taskExecutor.setMaxPoolSize(4);
	  taskExecutor.setQueueCapacity(50);
	  taskExecutor.initialize();
	  return taskExecutor;
	 }
	
}
