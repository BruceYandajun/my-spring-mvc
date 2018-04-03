package com.github.bruce.service;

import com.github.bruce.model.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeanService {

    @Autowired
    private MyBean myBean;


    @Override
    public String toString() {
        return myBean.toString();
    }

}
