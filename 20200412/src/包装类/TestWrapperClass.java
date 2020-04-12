package 包装类;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/12 10:17
 */

public class TestWrapperClass {
    public static void main(String[] args) {
      /*  //List<Integer> list = new ArrayList();
        //内置类型=》包装类（装箱）
        Integer i = Integer.valueOf(10);
        Integer j  = new Integer(10);


        //包装类=》内置类型 （拆箱）
        int k = j.intValue();*/

      Integer i = 10; //自动装箱
      int j = i;//自动拆箱

    }



}
