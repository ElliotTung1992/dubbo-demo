package com.dge1992.spring.aop.part5;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class DynamicProxy {

    public static void main(String[] args) {

        //资源对象
        ThemeImpl themeImpl = new ThemeImpl();
        //设置需要代理的资对象
        ThemeDynamicProxy handler = new ThemeDynamicProxy(themeImpl);
        //创建代理对象
        ITheme theme = (ITheme) Proxy.newProxyInstance(handler.getClass().getClassLoader(), themeImpl.getClass().getInterfaces(), handler);
        theme.request();

        SubjectImpl subjectImpl = new SubjectImpl();
        handler.setSubject(subjectImpl);
        ISubject subject = (ISubject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), subjectImpl.getClass().getInterfaces(), handler);
        subject.request();
    }
}

/**
 * 资源
 */
interface ITheme{
    void request();
}

/**
 * 资源实现
 */
class ThemeImpl implements ITheme{

    @Override
    public void request() {
        System.out.println("ThemeImpl lol");
    }
}

/**
 * 动态代理类
 */
class ThemeDynamicProxy implements InvocationHandler {

    private Object subject;

    public ThemeDynamicProxy(Object subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        method.invoke(subject, args);
        System.out.println("end");
        return null;
    }

    public Object getSubject() {
        return subject;
    }

    public void setSubject(Object subject) {
        this.subject = subject;
    }
}




