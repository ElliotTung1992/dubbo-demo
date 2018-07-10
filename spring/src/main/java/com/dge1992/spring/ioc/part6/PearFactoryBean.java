package com.dge1992.spring.ioc.part6;

import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义FactoryBean
 */
public class PearFactoryBean implements FactoryBean<Pear>{
    @Override
    public Pear getObject() throws Exception {
        return new Pear("香梨");
    }

    @Override
    public Class<?> getObjectType() {
        return Pear.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
