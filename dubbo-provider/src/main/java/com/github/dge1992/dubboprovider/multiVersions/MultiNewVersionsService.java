package com.github.dge1992.dubboprovider.multiVersions;

import com.github.dge1992.dubboapi.multiVersions.IMultiVersionsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.2")
public class MultiNewVersionsService implements IMultiVersionsService {

    @Override
    public void printVersion() {
        System.out.println("new");
    }
}
