package com.github.dge1992.dubboconsumer.localStub;

import com.github.dge1992.dubboapi.service.ITestService;
import org.apache.dubbo.common.utils.StringUtils;

public class TestServiceStub implements ITestService {

    private ITestService testService;

    public TestServiceStub(ITestService testService) {
        this.testService = testService;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("TestServiceStub...");
        System.out.println("TestServiceStub...");
        System.out.println("TestServiceStub...");
        System.out.println("TestServiceStub...");
        if(StringUtils.isNoneEmpty(name)){
            return testService.sayHello(name);
        }
        return null;
    }
}
