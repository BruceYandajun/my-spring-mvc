package com.github.bruce.controller;

import com.github.bruce.model.MyBean;
import com.github.bruce.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @GetMapping("/go")
    public String go(User user) {
        return user.getId() + " : " + user.getName();
    }

    @PostMapping("/come")
    public String come(@RequestBody MyBean myBean) {
        return myBean.getName();
    }

}
