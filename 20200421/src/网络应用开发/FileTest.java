package 网络应用开发;

import java.io.File;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/21 17:18
 */

public class FileTest {
    public static void main(String[] args){
        File file = new File("d:\\java");
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println("包含的子目录");


    }
}
