/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/1 10:14
 */

import static java.lang.Math.*;
class TestDemo {
    public static void main(String[] args) {
        double x = 20;
        double y = 30;
        double result = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        // 静态导入的方式写起来更方便一些.
        double result1 = sqrt(pow(x, 2) + pow(y, 2));
        System.out.println(result);
        System.out.println(result1);
    }
}
