



public class Demo3 {
    public static void main(String[] args) {
        //StringBuffer 是线程安全的方法中加了Sychronized关键字  StringBuilder是线程不安全
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("wade");
        stringBuffer.append("wade");
        stringBuffer.append("wade");
        stringBuffer.append("wade");
        //像这样的代码,每次执行都会涉及加锁和解锁操作.JVM判断后直接把锁消除
        //事实上,当前的StringBuffer只是在一 个线程中使用,不涉及线程安全问题.
        System.out.println(stringBuffer);
    }
}
