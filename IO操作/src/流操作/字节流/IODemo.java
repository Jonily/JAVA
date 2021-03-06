package 流操作.字节流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) throws IOException {
        copyFile("D:\\test_dir\\p1.JPEG","D:\\test_dir\\1\\p2.JPEG");//拷贝路径和目标路径
        copyFile1("D:\\test_dir\\p1.JPEG","D:\\test_dir\\1\\p2.JPEG");//拷贝路径和目标路径


    }
    private static void copyFile(String srcPath,String destPath) throws IOException {//抛出异常，传入文件路径不存在
        FileInputStream fileInputStream = null;//打开要拷贝的文件,，可以传入字符地址，或者File对象
        FileOutputStream fileOutputStream = null;//要写入的文件
        try {
            //先打开文件，再进行读写（创建InputStream/OutputStream对象）
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);

            byte[] bytes = new byte[1024];//缓冲区
            //单词读取的内容是有上限的（缓冲区的长度）
            //返回值表示本次读取实际读取的字节，如果文件读完返回-1
            int len = -1;
            while ((len = fileInputStream.read(bytes)) != -1) {//1、读取srcPath文件内容
                //2、将读取到的内容写入destPath对应的文件中
                //读取,然后把读到的内容写入到另外一个文件中
                //因为len的值不一定和缓冲区长度相同
                fileOutputStream.write(bytes,0,len);//避免脏读
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   public static void copyFile1(String srcPath,String destPath) throws IOException {
        //不需要显式调用close方法
       //try语句会在代码执行完毕后，自动调用close方法（前提是这个类必须要实现Closeable接口）
       //标准库中的流的方法都已经自动实现了Closeable接口
        try( FileInputStream fileInputStream = new FileInputStream(srcPath);//打开要拷贝的文件,，可以传入字符地址，或者File对象
             FileOutputStream fileOutputStream = new FileOutputStream(destPath)){//要写入的文件)
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(bytes)) != -1) {//1、读取srcPath文件内容
                //2、将读取到的内容写入destPath对应的文件中
                //读取,然后把读到的内容写入到另外一个文件中
                //因为len的值不一定和缓冲区长度相同
                fileOutputStream.write(bytes,0,len);//避免脏读
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
}
}
