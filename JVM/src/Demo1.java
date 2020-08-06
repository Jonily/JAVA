import sun.net.spi.nameservice.dns.DNSNameService;

public class Demo1 {
    public static void main(String[] args) {
        //应用程序自己写的类
        ClassLoader classLoader = Demo1.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println();
        // 加载标准库中的类
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

        System.out.println();

        //加载一个特殊目录中的类
        ClassLoader classLoader2 = DNSNameService.class.getClassLoader();
        System.out.println(classLoader2);


    }
}
