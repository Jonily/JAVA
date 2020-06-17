package 基础操作;

import java.io.File;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) {
        File file = new File("D:\\hhh.txt");

        System.out.println("文件是否存在："+ file.exists());
        System.out.println("文件是否是目录："+file.isDirectory());
        System.out.println("文件是否是文件："+file.isFile());
        //删除文件
        file.delete();
        System.out.println("文件是否存在："+ file.exists());
        //创建文件
        String pathname = "D:\\demo.txt";
        File file1 = new File(pathname);
        if(!file1.exists()){
            try {
                file1.createNewFile();
            } catch (IOException e) {
                System.out.println("文件"+pathname+"创建失败");
                //e.printStackTrace();
            }
        }else {
            System.out.println("文件"+pathname+"已存在不需要创建");
        }
    }
}
