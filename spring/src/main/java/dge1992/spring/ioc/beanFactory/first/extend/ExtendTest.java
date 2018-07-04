package dge1992.spring.ioc.beanFactory.first.extend;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 继承
 */
public class ExtendTest {

    public static void main(String[] args) {
        //继承
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("ioc/beanFactory/first/extend/extend.xml"));
        RedCat redCat = (RedCat) beanFactory.getBean("redCat");
        System.out.println(redCat);

        BlackCat blackCat = (BlackCat) beanFactory.getBean("blackCat");
        System.out.println(blackCat);
    }
}
