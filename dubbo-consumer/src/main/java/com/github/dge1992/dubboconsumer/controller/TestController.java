package com.github.dge1992.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.dge1992.dubboapi.service.ITestService;
import org.apache.dubbo.config.annotation.Method;
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

    //设置单个接口超时,以及对接口的重试次数，默认是2
    //接口重试涉及到接口的幂等性(幂等[删，改，查][可以重试]和非幂等[增][不应该重试])
    @Reference(timeout = 2000, retries = 3)
    private ITestService testService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return testService.sayHello(name);
    }
}