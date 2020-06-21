package 流操作.字符流;

import java.io.*;

public class IODemo {
    public static void main(String[] args) {
        copyFile2();

    }
    private static void copyFile() {//自己设置缓冲区
        //处理文本文件，需要使用字符流
        try(FileReader fileReader = new FileReader("D:\\test_dir\\char.txt");
            FileWriter fileWriter = new FileWriter("D:\\test_dir\\char2.txt")){
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = fileReader.read(buffer)) != -1){
                fileWriter.write(buffer,0,len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //使用内置buffer缓冲区
    private  static void copyFile1 () {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\test_dir\\char.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\test_dir\\char3.txt"))) {
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = bufferedReader.read(buffer)) != -1){
                bufferedWriter.write(buffer,0,len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //带缓冲区的字符流中有一种特殊的用法，按行读取
    private  static void copyFile2 () {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\test_dir\\char2.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\test_dir\\char4.txt"))) {
           String line = "";
           while ((line = bufferedReader.readLine()) !=  null) {
               System.out.println("line: " + line);
               bufferedWriter.write(line+"\n");
           }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
