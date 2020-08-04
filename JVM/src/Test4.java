



class A{
    public int num =0;

}
class B{
    public int count =0;
    public A a;

}
public class Test4 {
    public static void main(String[] args) {
        //先构造一个对象
        B b = new B();
        b.count = 10;
        b.a = new A();
        b.a.num = 100;

        //针对b进行拷贝
        //copy1 直接返回了b，意味着b和b2指向的是同一个对象
        //其实没有发生拷贝
       /* B b2 = cpoy1(b);
        System.out.println(b2.count);
        System.out.println("=================");*/

        //copy2 b3指向的是一个新的B对象，此时发生了浅拷贝
        //B b3 = cpoy2(b);
        B b4 = copy3(b);
        System.out.println(b4.count);
        System.out.println(b4.a.num);
        System.out.println("修改内容");
        b.count = 20;
        b.a.num = 200;//b和b3持有的是同一个a对象
        System.out.println(b4.count);
        System.out.println(b4.a.num);

    }

    private static B copy3(B b) {
        B ret = new B();
        ret.count = b.count;
        ret.a = new A();
        ret.a.num = b.a.num;
        return ret;
    }

    private static B cpoy2(B b) {
        B ret = new B();
        ret.count = b.count;
        ret.a = b.a;
        return ret;
    }

    private static B cpoy1(B b) {
        return b;
    }

}
