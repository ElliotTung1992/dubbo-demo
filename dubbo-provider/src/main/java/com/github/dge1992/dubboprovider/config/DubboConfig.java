package com.github.dge1992.dubboprovider.config;

import com.github.dge1992.dubboapi.service.ITestService;
import org.apache.dubbo.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class DubboConfig {

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-provider111");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("39.105.12.20:8999");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    @Bean
    public ServiceConfig<ITestService> serviceConfig(ITestService testService){
        ServiceConfig<ITestService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(ITestService.class);
        serviceConfig.setRef(testService);
        serviceConfig.setVersion("1.0.0");

        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("sayHello");
        methodConfig.setRetries(-1);

        List<MethodConfig> list = new ArrayList<>();
        list.add(methodConfig);

        serviceConfig.setMethods(list);
        return serviceConfig;
    }

}
