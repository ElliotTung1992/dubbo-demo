package com.github.dge1992.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.dge1992.dubboapi.service.ITestService;

@Service
public class TestService implements ITestService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
