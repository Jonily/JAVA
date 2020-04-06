package User;

import Book.BookList;
import Operation.IOperation;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:45
 */

abstract public  class User {
    public String name;
    public IOperation[] Operations;//数组当中保存每个对象的操作
    public User(String name){
        this.name = name;
    }


    //如果没有这个方法，那么不可以通过user访问menu（）
    public abstract int menu();

    public void doOperation(int choice,BookList bookList){
        //Operation[choice]===>拿到的时候数组当中元素的对象
        //Operation[choice].work(bookList) 通过.号调用对应的操作方法
        Operations[choice].work(bookList);
    }

}
