import java. lang.reflect.*;
public class DumpMethods{
    public static void main(String[] args) {
        Integer i01=59;
        int i02=59;
        Integer i03=Integer .valueOf(59);
        Integer i04=new Integer(59);
        System.out.println(i03 == i04);
        System.out.println(i02 == i03);


    }
}
