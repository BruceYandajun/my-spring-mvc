package com.github.bruce.controller;

import com.github.bruce.model.MyBean;
import com.github.bruce.service.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BeanController {

    /**
     * why using require = false property, because when this controller is initialized, myBean is not instanced by Java Config yet
     */
    @Autowired(required = false)
    private MyBean myBean;

    @Autowired
    private BeanService myService;

    @GetMapping("/myBean")
    public String myBean() {
        return myBean.getName();
    }

    @GetMapping("/myService")
    public String myService() {
        return myService.toString();
    }
}
