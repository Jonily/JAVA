/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/23 11:43
 */

class Swap {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
public class TestDemo {
    public static void swap(Swap swap1,Swap swap2) {
       int tmp = swap1.getA();
        swap1.setA(swap2.getA());
         swap2.setA(tmp);


    }
    public static void main(String[] args) {
        Swap swap1 = new Swap();
        swap1.setA(10);
        Swap swap2 = new Swap();
        swap2.setA(20);
        System.out.println(swap1.getA()+" "+swap2.getA());
        swap(swap1,swap2);
        System.out.println(swap1.getA()+" "+swap2.getA());
    }
}