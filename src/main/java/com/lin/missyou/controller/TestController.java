package com.lin.missyou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mrguo
 * @create 2021-06-15 16:15
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "hell word";
    }
}
