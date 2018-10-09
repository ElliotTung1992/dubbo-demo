package com.github.dge.mvc.dao;

import com.github.dge.mvc.annotation.Mapper;

@Mapper("/testMapper")
public class TestMapper {

    public String test1() {
        return "testSpringMVC";
    }
}
