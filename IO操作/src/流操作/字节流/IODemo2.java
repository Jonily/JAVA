package 流操作.字节流;

import java.io.*;

public class IODemo2 {
    public static void main(String[] args) throws IOException {
        copyFile("D:\\test_dir\\p1.JPEG","D:\\test_dir\\1\\p2.JPEG");//拷贝路径和目标路径
        copyFile2("D:\\test_dir\\p1.JPEG","D:\\test_dir\\1\\p2.JPEG");//拷贝路径和目标路径


    }
    private static void copyFile(String srcPath,String destPath) throws IOException {
        //先创建File的实例
        //需要创建实例BufferedInputStream和 BufferedOutputStream方法内部特有了缓冲区对象
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = bufferedInputStream.read(buffer))!= -1 ) {
            bufferedOutputStream.write(buffer,0,length);
        }
        //四个流对象关闭
        //调用bufferedInputStream.close时，会自动关闭内部的，FileInputStream和FileOutputStream
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
    private static void copyFile2(String srcPath,String destPath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        try ( BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
              BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)){
                  int len = -1;
                  byte[] buffer = new byte[1024];
                  while(true){
                      len = bufferedInputStream.read(buffer);
                      if(len == -1){
                          break;
                      }else {
                          bufferedOutputStream.write(buffer,0,len);

                      }
                  }

              }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
