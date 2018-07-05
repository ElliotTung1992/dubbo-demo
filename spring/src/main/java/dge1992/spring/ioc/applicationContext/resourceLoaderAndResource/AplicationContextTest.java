package dge1992.spring.ioc.applicationContext.resourceLoaderAndResource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class AplicationContextTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        Resource resource = applicationContext.getResource("E:\\dataSource\\text.txt");

        System.out.println(resource instanceof ClassPathResource);
        System.out.println(resource.exists());

        Resource resource1 = applicationContext.getResource("http:www.baidu.com");
        System.out.println(resource1 instanceof UrlResource);
    }
}
