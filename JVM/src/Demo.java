
class AA{
    public AA() {
        System.out.println("AA的构造函数");
    }

    {
        System.out.println("AA的代码块");
    }
    static {
        System.out.println("AA的静态代码块");
    }

}
class BB extends AA{
    public BB() {
        System.out.println("BB的构造函数");
    }
    {
        System.out.println("BB的代码块");
    }
    static {
        System.out.println("BB的静态代码块");
    }
}

public class Demo {
    public static void main(String[] args) {
        System.out.println("开始");
        new BB();
        new BB();

        System.out.println("结束");
    }
}
