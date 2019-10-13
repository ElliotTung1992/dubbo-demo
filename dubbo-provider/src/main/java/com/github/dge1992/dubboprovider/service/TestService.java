package com.github.dge1992.dubboprovider.service;

import com.github.dge1992.dubboapi.service.ITestService;
import lombok.extern.java.Log;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * 服务生产者测试服务
 */
@Log
@Component
@Service
public class TestService implements ITestService {

    @Override
    public String sayHello(String name) {
        log.warning("provider sayHello");
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello  " + name;
    }
}
