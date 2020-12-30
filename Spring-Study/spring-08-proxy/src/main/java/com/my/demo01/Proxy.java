package com.my.demo01;

public class Proxy implements Rent{
    private HouseMaster houseMaster;
    public Proxy() {
    }
    public Proxy(HouseMaster houseMaster) {
        this.houseMaster = houseMaster;
    }

    //出租房
    public void rent() {
        houseMaster.rent();
        check();
        getMoney();
        HeTong();
    }

    //看房
    public void check(){
        System.out.println("中介看房");
    }

    //收中介费
    public void getMoney(){
        System.out.println("中介收钱");
    }

    //签合同
    public void HeTong(){
        System.out.println("中介签合同");
    }
}
