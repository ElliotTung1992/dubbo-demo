package com.github.dge1992.dubboconsumer.localStub;

import com.github.dge1992.dubboapi.service.ITestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试本地存根
 */
@RestController
public class LocalStubController {

    @Reference(stub = "com.github.dge1992.dubboconsumer.localStub.TestServiceStub")
    private ITestService testService;

    @RequestMapping("/testLocalStub")
    public String testLocalStub(@RequestParam("name") String name){
        return testService.sayHello(name);
    }
}
