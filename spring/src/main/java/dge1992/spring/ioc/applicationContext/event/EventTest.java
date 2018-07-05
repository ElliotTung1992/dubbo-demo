package dge1992.spring.ioc.applicationContext.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/applicationContext/event/event.xml");
        MethodExeuctionEventPublisher evtPublisher = (MethodExeuctionEventPublisher) applicationContext.getBean("evtPublisher");
        evtPublisher.methodToMonitor();
    }
}
