package User;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:45
 */

abstract public  class User {
    public User(String name){
        this.name = name;
    }

    public String name;
    //如果没有这个方法，那么不可以通过user访问menu（）
    public abstract int menu();

}
