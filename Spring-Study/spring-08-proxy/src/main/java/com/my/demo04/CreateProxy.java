package com.my.demo04;

import com.my.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//使用这个类自动生成代理类
public class CreateProxy implements InvocationHandler {
    //被代理的接口
    private Object target;
    public void setTarget(Object target){
        this.target = target;
    }

    //得到代理类
    public Object GetProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this );
    }

    //处理代理实例并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的本质就是使用反射机制
        Object result = method.invoke(target,args);
        return result;
    }

}
