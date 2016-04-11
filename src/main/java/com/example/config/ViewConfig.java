package com.example.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wutthinan on 4/11/2016 AD.
 */
@Controller
public class ViewConfig {
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
