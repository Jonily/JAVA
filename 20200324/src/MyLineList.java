/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/24 23:38
 */
class Node{
    private int data;
    private Node next; //利用引用类型储存地址，因为已经定义Node所以可以直接引用

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
public class MyLineList {
}
