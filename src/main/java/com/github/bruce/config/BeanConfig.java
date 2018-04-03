package com.github.bruce.config;

import com.github.bruce.model.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean("default");
    }
}
