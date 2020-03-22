/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/22 23:02
 */

public class MyArrayList {
    private int[] array;
    private int useSize;//单链表中已经被占用的数据个数
    public static final int SIZE = 10; //定义单链表默认的容量
public MyArrayList(){
    this.array = new int[SIZE];
    this.useSize = 0;

}
}
 class Test{
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
    }
}


