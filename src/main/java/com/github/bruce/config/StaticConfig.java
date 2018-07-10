package com.github.bruce.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class StaticConfig {

    public StaticConfig() {
        System.out.println("-----" + this);
    }

    @Value("${config.test}")
    private String testConfig;
}