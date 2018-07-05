package dge1992.spring.ioc.applicationContext.resourceLoaderAndResource;

import org.springframework.core.io.*;

public class FileSystemResourceLoaderTest {

    public static void main(String[] args) {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource("E:\\dataSource\\test.txt");

        System.out.println(resource instanceof FileSystemResource);
        System.out.println(resource.exists());

        Resource resource1 = resourceLoader.getResource("file:E:\\dataSource\\test.txt");
        System.out.println(resource1 instanceof UrlResource);
    }
}
