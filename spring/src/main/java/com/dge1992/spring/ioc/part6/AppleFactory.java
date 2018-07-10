package com.dge1992.spring.ioc.part6;

/**
 * 苹果工厂
 */
public class AppleFactory {

    public static Apple getInstance(){
        return new Apple("青苹果");
    }
}
