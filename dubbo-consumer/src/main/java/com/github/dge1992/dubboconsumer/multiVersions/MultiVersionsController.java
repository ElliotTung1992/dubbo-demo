package com.github.dge1992.dubboconsumer.multiVersions;

import com.github.dge1992.dubboapi.multiVersions.IMultiVersionsService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试dubbo的多版本，用于灰度测试
 */
@RestController
public class MultiVersionsController {

    @Reference(version = "*")
    private IMultiVersionsService multiVersionsService;

    @RequestMapping("/testMultiVersions")
    public String testMultiVersions(){
        multiVersionsService.printVersion();
        return "调用成功！";
    }

}
