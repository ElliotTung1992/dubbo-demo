package dge1992.spring.ioc.applicationContext.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义事件发布者
 */
public class MethodExeuctionEventPublisher implements ApplicationEventPublisherAware{

    private ApplicationEventPublisher eventPublisher;

    public void methodToMonitor()
    {
        MethodExecutionEvent beginEvt = new
        MethodExecutionEvent(this,"aaa",MethodExecutionStatus.BEGIN);
        this.eventPublisher.publishEvent(beginEvt);
        // 执行实际方法逻辑
        // ...
        MethodExecutionEvent endEvt = new
        MethodExecutionEvent(this,"aaa",MethodExecutionStatus.END);
        this.eventPublisher.publishEvent(endEvt);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public void aaa(){

    }
}
