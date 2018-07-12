package com.github.bruce.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AService {

    private BService bService;

    @Autowired
    @Lazy
    public AService(BService bService) {
        this.bService = bService;
    }
}
