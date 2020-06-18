package 目录操作;

import java.io.File;
import java.util.Date;

public class IODemo1 {
    public static void main(String[] args) {
        //目录操作
        File file = new File("d:/test_dir");
        listAllFiles(file );
    }
    private static void listAllFiles(File f ) {
        if(f.isDirectory()){
            //如果是目录，罗列出目录中的文件
            File[] files = f.listFiles();
            for (File p: files
                 ) {
                listAllFiles(p);
            }
        }else {
            //把文件的路径打印
            System.out.println(f);
        }
    }

}
/*  //listFile 直接调用只能看到当前目录下的内容
        File[] files = file.listFiles();
        for (File f: files
             ) {
            System.out.println(f);
        }*/
/*System.out.println(file.exists());
 *//*System.out.println(file.getParent());//得到当前路径的父目录
        System.out.println(file.getParentFile());//获得父File对象*//*
        System.out.println(file.length());//获得文件大小（字节）
        System.out.println(new Date(file.lastModified()));//最后一次修改时间*/

