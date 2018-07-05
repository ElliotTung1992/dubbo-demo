package dge1992.spring.ioc.applicationContext.resourceLoaderAndResource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

public class ResourcePatternResolverTest {

    public static void main(String[] args) {
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = patternResolver.getResource("E:\\dataSource\\test.txt");
        System.out.println(resource instanceof ClassPathResource);
        System.out.println(resource.exists());

        PathMatchingResourcePatternResolver patternResolver1 = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
        Resource resource1 = patternResolver1.getResource("E:\\dataSource\\test.txt");
        System.out.println(resource1 instanceof FileSystemResource);
        System.out.println(resource1.exists());

        try {
            Resource[] resources = patternResolver1.getResources("E:\\dataSource\\*.txt");
            for (Resource resource0:resources) {
                System.out.println("=============");
                System.out.println(resource0.exists());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
