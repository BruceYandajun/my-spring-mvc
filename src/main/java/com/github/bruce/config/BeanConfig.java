package com.github.bruce.config;

import com.github.bruce.model.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Autowired
    private StaticConfig staticConfig;

    @Bean
    public MyBean myBean() {
        System.out.println(staticConfig.getTestConfig());
        return new MyBean("default");
    }
}
