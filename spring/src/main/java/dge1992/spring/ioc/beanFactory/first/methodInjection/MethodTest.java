package dge1992.spring.ioc.beanFactory.first.methodInjection;

import dge1992.spring.ioc.beanFactory.first.factoryMethod.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 偷梁换柱
 */
public class MethodTest {

    public static void main(String[] args) {
        //问题 person依赖对象cat的作用域为prototype,但是两次获取Person的依赖cat对象是同一个对象
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("ioc/beanFactory/first/methodInjection/method.xml"));
        Person person = (Person) beanFactory.getBean("person5");
        Person person_2 = (Person) beanFactory.getBean("person5");
        System.out.println(person);
        System.out.println(person_2);

        //方法注入
        Person person6 = (Person) beanFactory.getBean("person6");
        Person person6_2 = (Person) beanFactory.getBean("person6");
        System.out.println(person6.getCat());
        System.out.println(person6_2.getCat());

        //殊途同归
        dge1992.spring.ioc.beanFactory.first.methodInjection.Person person7 = (dge1992.spring.ioc.beanFactory.first.methodInjection.Person) beanFactory.getBean("person7");
        dge1992.spring.ioc.beanFactory.first.methodInjection.Person person7_2 = (dge1992.spring.ioc.beanFactory.first.methodInjection.Person) beanFactory.getBean("person7");
        System.out.println(person7.getCat());
        System.out.println(person7_2.getCat());

        //方式二
        People people1 = (People) beanFactory.getBean("people");
        People people2 = (People) beanFactory.getBean("people");
        System.out.println(people1.getDog());
        System.out.println(people2.getDog());
    }
}
