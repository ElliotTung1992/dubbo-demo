package com.dge1992.spring.aop.part5;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态字节码生成
 */
public class CGLIBTest {

    public static void main(String[] args) {
        RequestTableCallBack requestTableCallBack = new RequestTableCallBack(new RequestTable());
        RequestTable requestTableProxy = (RequestTable) requestTableCallBack.getRequestTableProxy();
        requestTableProxy.request();
    }
}

//目标对象
class RequestTable{

    public void request(){
        System.out.println("RequestTable lol");
    }
}

class RequestTableCallBack implements MethodInterceptor{

    //目标对象
    private Object target;

    //构造方法
    public RequestTableCallBack(Object target){
        this.target = target;
    }

    //获取代理对象
    public Object getRequestTableProxy(){
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        return enhancer.create();
    }

    //拦截
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("hehe");
        Object result = method.invoke(target, args);
        System.out.println("haha");
        return result;
    }
}


