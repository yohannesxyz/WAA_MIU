package com.miu.waaLab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/ab")
public class PostController {
    @GetMapping("/")
    public String testing(){
        return "working...";
    }
}
