package com.dge1992.spring.ioc.part6;

/**
 * 苹果工厂
 */
public class Apple2Factory {

    public static Apple getInstance(String appleName){
        return new Apple(appleName);
    }
}
