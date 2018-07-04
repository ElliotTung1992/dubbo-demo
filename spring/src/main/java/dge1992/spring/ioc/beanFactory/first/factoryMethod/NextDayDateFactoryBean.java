package dge1992.spring.ioc.beanFactory.first.factoryMethod;

import org.springframework.beans.factory.FactoryBean;

import java.time.LocalDate;

public class NextDayDateFactoryBean implements FactoryBean{

    @Override
    public Object getObject() throws Exception {
        return LocalDate.now().plusDays(1);
    }

    @Override
    public Class<?> getObjectType() {
        return LocalDate.now().getClass();
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
