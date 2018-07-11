package com.dge1992.spring.ioc.part15;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * 资源加载策略测试
 */
public class ResourceLoaderTest {

    public static void main(String[] args) throws IOException {
        //DefaultResourceLoader测试
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:ioc/part15/resource1.xml");
        System.out.println(resource instanceof ClassPathResource);

        Resource resource1 = resourceLoader.getResource("http://www.baidu.com");
        System.out.println(resource1 instanceof UrlResource);

        Resource resource2 = resourceLoader.getResource("file:ioc/part15/resource1.xml");
        System.out.println(resource2 instanceof UrlResource);

        //FileSystemResourceLoader测试
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        Resource resource3 = fileSystemResourceLoader.getResource("ioc/part15/resource1.xml");
        System.out.println(resource3 instanceof FileSystemResource);

        //PathMatchingResourcePatternResolver测试
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        Resource resource4 = resourceResolver.getResource("ioc/part15/resource1.xml");
        System.out.println(resource4 instanceof FileSystemResource);

        Resource[] resources = resourceResolver.getResources("ioc/part15/*.xml");
        for (Resource resource5:resources) {
            System.out.println(resource5.getFilename());
        }

        resourceResolver =  new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
        Resource resource6 = resourceResolver.getResource("ioc/part15/resource1.xml");
        System.out.println(resource6 instanceof FileSystemResource);

        //Application扮演ResourceLoader
        ResourceLoader resourceLoader1 = new ClassPathXmlApplicationContext("ioc/part15/resource1.xml");
        Resource resource7 = resourceLoader1.getResource("classpath:ioc/part15/source1.xml");
        System.out.println(resource7 instanceof ClassPathResource);

        Resource resource8 = resourceLoader1.getResource("http://www.baidu.com");
        System.out.println(resource8 instanceof UrlResource);


    }
}
