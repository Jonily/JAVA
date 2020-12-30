package com.my.demo01;

public class Client {
    public static void main(String[] args) {
        //房东出租房子
        HouseMaster houseMaster = new HouseMaster();
        //中介代理 中介有附加的其他的附属操作
        Proxy proxy = new Proxy(houseMaster);
        //租户不用面对房东，直接找中介租房
        proxy.rent();
    }

}
