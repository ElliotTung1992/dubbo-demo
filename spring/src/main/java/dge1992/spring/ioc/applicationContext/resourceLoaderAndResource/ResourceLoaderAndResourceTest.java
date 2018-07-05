package dge1992.spring.ioc.applicationContext.resourceLoaderAndResource;

import org.springframework.core.io.*;

public class ResourceLoaderAndResourceTest {

    public static void main(String[] args) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("E:\\dataSource\\test.txt");

        System.out.println(resource instanceof ClassPathResource);
        System.out.println(resource.exists());

        Resource resource1 = resourceLoader.getResource("file:E:\\dataSource\\test.txt");
        System.out.println(resource1 instanceof UrlResource);

        Resource resource2 = resourceLoader.getResource("http://www.baidu.com");
        System.out.println(resource2 instanceof UrlResource);
    }
}
