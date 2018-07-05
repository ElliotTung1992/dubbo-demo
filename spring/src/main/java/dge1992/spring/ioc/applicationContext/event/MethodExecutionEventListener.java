package dge1992.spring.ioc.applicationContext.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 自定义事件监听器
 */
public class MethodExecutionEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof MethodExecutionEvent){
            System.out.println("MethodExecutionEvent事件被监听");
        }
    }
}
