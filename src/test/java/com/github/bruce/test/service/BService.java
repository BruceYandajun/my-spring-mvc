package com.github.bruce.test.service;

import org.springframework.stereotype.Component;

@Component
public class BService {

    private AService aService;

    public BService(AService aService) {
        this.aService = aService;
    }
}
