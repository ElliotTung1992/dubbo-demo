package com.github.dge1992.dubboconsumer.config;

import com.github.dge1992.dubboapi.service.ITestService;
import com.github.dge1992.dubboconsumer.localStub.TestServiceStub;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DubboConfig {

    @Bean
    public ServiceConfig<TestServiceStub> serviceConfig(){
        ServiceConfig<TestServiceStub> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(ITestService.class);
        serviceConfig.setStub(true);
        return serviceConfig;
    }
}
