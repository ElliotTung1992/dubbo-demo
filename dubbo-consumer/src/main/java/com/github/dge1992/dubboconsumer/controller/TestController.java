package com.github.dge1992.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.dge1992.dubboapi.service.ITestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 小眼睛带鱼
 * @Date: 2019/10/1 21:47
 * @Description: 服务消费这测试用例
 */
@RestController
public class TestController {

    @Reference
    private ITestService testService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return testService.sayHello(name);
    }
}