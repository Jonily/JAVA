
public class Test {
    //t2是成员变量，t2这个引用就是在堆上
    Test t2 = new Test();

    //t3是静态变量在方法区中
    static Test t3 = new Test();
    public static void main(String[] args) {
        //t是局部变量，t这个引用就是在栈上
        Test t = new Test();
    }
}
