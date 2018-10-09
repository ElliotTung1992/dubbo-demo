package com.github.dge.mvc.service;

import com.github.dge.mvc.annotation.Autowired;
import com.github.dge.mvc.annotation.Service;
import com.github.dge.mvc.dao.TestMapper;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public String test1(){
        return testMapper.test1();
    }
}
