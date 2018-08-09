package com.dge1992.spring.aop.part5;

/**
 * 代理模式
 */
public class ProxyPattern {

    public static void main(String[] args) {
        //资源
        SubjectImpl subject = new SubjectImpl();
        //资源代理
        SubjectProxy subjectProxy = new SubjectProxy();
        subjectProxy.setSubject(subject);
        subjectProxy.request();
    }
}

/**
 * 公共接口
 */
interface ISubject{
    void request();
}

/**
 * 资源实现类
 */
class SubjectImpl implements ISubject{

    @Override
    public void request() {
        System.out.println("SubjectImpl lol");
    }
}

/**
 * 资源代理
 */
class SubjectProxy implements ISubject{

    private ISubject subject;

    @Override
    public void request() {
        System.out.println("SubjectProxy hehe");
        subject.request();
        System.out.println("SubjectProxy haha");
    }

    public ISubject getSubject() {
        return subject;
    }

    public void setSubject(ISubject subject) {
        this.subject = subject;
    }
}


