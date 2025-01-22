package com.java.bms.Misc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutor;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Configuration
public class ThreadPoolConfig {

    @Bean
    public ExecutorService asyncExecutorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        return new DelegatingSecurityContextExecutorService(executorService);
    }
}