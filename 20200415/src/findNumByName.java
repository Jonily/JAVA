

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/16 10:29
 */

public class findNumByName {
    /*public String findNumByName(String name)//通过姓名来查询学号
    {
        String flag="查无此人";//定义一个变量来保存查询的结果
        //从学生文件中一次读取一行数据（用BufferedReader对象来实现一次读取一行数据的功能）
        //将一行数据用切割函数切割成一个字符串数组，然后比对
        //怎么来判断到达了文件的尾部(通过判空来判断是否到文件的尾部)
        try
        {
            FileReader fr=new FileReader("d:\\student.txt");
            BufferedReader br=new BufferedReader(fr);
            //以文件字符输入流对象为参数来创建一个缓冲的字符输入流对象
            String temp=br.readLine();//先从文件中读取第一行数据
            while(temp!=null)
            {
                String[] infos=temp.split(",");
                //使用切割行数将读取到的一行数据分割成一个字符串数组
                if(infos[0].equals(name))//判断第一个元素是否等于所给的学号参数
                {
                    name=infos[1];
                    break;
                }
                temp=br.readLine();//再次读取一行数据
            }
            br.close();
            fr.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return name;//返回结果
    }
*/
    //通过姓名来查询学号
    public String[] findNumByName(String name){
        ArrayList<String> result = new ArrayList<>();

        try
        {
            FileReader fr=new FileReader("d:\\student.txt");
            BufferedReader br=new BufferedReader(fr);
            //以文件字符输入流对象为参数来创建一个缓冲的字符输入流对象
            String temp=br.readLine();//先从文件中读取第一行数据
            while(temp!=null)
            {
                String[] infos=temp.split(",");
                //使用切割行数将读取到的一行数据分割成一个字符串数组
                if(infos[1].equals(name))//判断第一个元素是否等于所给的学号参数
                {
                    result.add(infos[0]);
                }
                temp=br.readLine();//再次读取一行数据
            }
            br.close();
            fr.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return (String[]) result.toArray(new String[result.size()]);
        //将容器对象强制转换为字符串数组
    }

    public static void main(String[] args) {
        findNumByName findNumByName = new findNumByName();
        String[] num = findNumByName.findNumByName("1232");

    }
}
