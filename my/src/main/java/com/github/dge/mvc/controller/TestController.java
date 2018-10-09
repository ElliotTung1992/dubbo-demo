package com.github.dge.mvc.controller;

import com.github.dge.mvc.annotation.Autowired;
import com.github.dge.mvc.annotation.Controller;
import com.github.dge.mvc.annotation.RequestMapping;
import com.github.dge.mvc.annotation.ResponseBody;
import com.github.dge.mvc.service.TestService;

@Controller(value = "/testController")
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test1")
    @ResponseBody
    public Object test1(String name, Integer age, Boolean sex){
        return testService.test1();
    }

    @RequestMapping("/test2")
    public String test2(){
        return testService.test1();
    }

}
