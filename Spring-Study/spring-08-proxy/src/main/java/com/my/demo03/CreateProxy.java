package com.my.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//使用这个类自动生成代理类
public class CreateProxy implements InvocationHandler {
    //被代理的接口
    private Rent rent;
    public void setRent(Rent rent){
        this.rent = rent;
    }

  /*创建模式：
  Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
            new Class<?>[] { Foo.class },
            handler);*/
    //得到代理类
    public Object GetProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                rent.getClass().getInterfaces(),this );
    }

    //处理代理实例并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        see();
        //动态代理的本质就是使用反射机制
        Object result = method.invoke(rent,args);
        getMoney();
        return result;
    }

    public void see(){
        System.out.println("中介看房子");
    }
    public void getMoney(){
        System.out.println("中介收钱");
    }

}
