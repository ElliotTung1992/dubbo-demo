package com.github.dge1992.dubboprovider.service;

import com.github.dge1992.dubboapi.service.ITestService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * 服务生产者测试服务
 */
@Component
@Service
public class TestService implements ITestService {

    @Override
    public String sayHello(String name) {
        System.out.println("TestService1");
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello  " + name;
    }
}
