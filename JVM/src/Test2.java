


public class Test2 {
    //递归求阶乘

    public static void main(String[] args) {
        int ret = fun(5);
        System.out.println(ret);
    }
    private static int fun(int i) {
        if(i == 1){
            return 1;
        }else {
            return i*fun(i-1);
        }
    }
}
