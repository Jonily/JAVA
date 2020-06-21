package 流操作.字节流;

import java.io.*;

public class IODemo3 {
    public static void main(String[] args) throws IOException {

        //不使用和使用缓冲区的区别，在比较大的文件会体现得比较明显
        teatNoBUffer("D:\\test_dir\\p1.JPEG","D:\\test_dir\\1\\p2.JPEG");
        teatBuffer("D:\\test_dir\\p1.JPEG","D:\\test_dir\\1\\p2.JPEG");
    }
    private static void teatNoBUffer(String srcPath,String destPath){
        //读的时候就是一个字节，一个字节读，不使用缓存区
        long beg = System.currentTimeMillis();
        try(FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath)){
            int ch = -1;
            while ((ch = fileInputStream.read())!= -1) {
            //啥都不干
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("no buffer "+(end - beg)+"ms");
    }
    private static void teatBuffer(String srcPath,String destPath) throws IOException {
        long beg = System.currentTimeMillis();
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcPath));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPath))){
            int ch = -1;
            while ((ch = bufferedInputStream.read())!= -1){


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("have buffer "+(end - beg)+"ms");


    }
}
