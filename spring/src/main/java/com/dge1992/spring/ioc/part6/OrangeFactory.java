package com.dge1992.spring.ioc.part6;

/**
 * 橙子工厂
 */
public class OrangeFactory {

    public Orange getInstance(){
        return new Orange("新鲜橙子");
    }
}
