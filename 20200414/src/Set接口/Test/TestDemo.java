package Set接口.Test;
import java.io.*;
import java.util.HashMap;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/14 16:25
 */

public class TestDemo {
    public static void main(String[] args) {
     /*   HashMap map = new HashMap();
        map.put("001","张三");
        map.put("002","李四");
        map.put("003","王五");
        System.out.println(map.get("001"));*/
     try {
         FileInputStream fis = new FileInputStream("d:\\java编程");
     }catch (FileNotFoundException e){
         e.printStackTrace();
     }
    }
}
