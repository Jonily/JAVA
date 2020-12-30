package com.my.demo03;

public class Client {
    public static void main(String[] args) {
       //真实角色，被代理的
        HouseMaster master = new HouseMaster();
        //代理角色 现在还没创建
        CreateProxy createProxy = new CreateProxy();
        //通过调用程序处理角色来处理要调用的接口对象
        createProxy.setRent(master);

        Rent proxy = (Rent) createProxy.GetProxy();//动态生成的代理
        proxy.rent();

    }
}
