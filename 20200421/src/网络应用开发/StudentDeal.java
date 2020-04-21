package 网络应用开发;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/21 16:10
 */

import java.io.*;
import java.util.*;
/**
 * 学生数据操作类
 * @author lenovo
 *
 */
public class StudentDeal
{
    public class Student
    {
        public String num;
        public String name;
        public String sex;
        public Student(String num,String name,String sex)
        {
            this.num=num;
            this.name=name;
            this.sex=sex;
        }
    }
    public String findNameByNum(String num)//通过学号来查询姓名
    {
        String name="查无此人";//定义一个变量来保存查询的结果
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
                if(infos[0].equals(num))//判断第一个元素是否等于所给的学号参数
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

    //定义一个通过姓名查找学号的方法
    public String[] findNumsByName(String name)
    {
        ArrayList<String> result=new ArrayList<String>();
        //定义一个容器对象来保存结果
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

        return(String[])result.toArray(new String[result.size()]);
        //将容器对象强制转换为字符串数组
    }

    //通过学号来查找学生对象
    public Student findStuByNum(String num)
    {
        Student student=null;
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
                if(infos[0].equals(num))//判断第一个元素是否等于所给的学号参数
                {
                    student=new Student(infos[0],infos[1],infos[2]);
                    //通过切割得到的数组元素来实例化一个学生对象
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
        return student;
    }

    //通过学生姓名来查找学生对象
    public Student[] findStusByName(String name)
    {
        ArrayList<Student> result=new ArrayList<Student>();
        //定义一个容器对象来保存结果
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
                    result.add(new Student(infos[0],infos[1],infos[2]));
                    //根据找到的三个元素来创建一个匿名对象，并添加到容器中
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

        return(Student[])result.toArray(new Student[result.size()]);
    }

    //获取所有的学生信息
    public Student[] getAllStu()
    {
        ArrayList<Student> result=new ArrayList<Student>();
        //定义一个容器对象来保存结果
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
                result.add(new Student(infos[0],infos[1],infos[2]));
                //根据找到的三个元素来创建一个匿名对象，并添加到容器中
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
        return(Student[])result.toArray(new Student[result.size()]);
    }

    //根据姓来查找学生信息
    public Student[] findStusByLastName(String lastName)
    {
        ArrayList<Student> result=new ArrayList<Student>();
        //定义一个容器对象来保存结果
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
                if(infos[1].startsWith(lastName))//判断表示姓名的元素是否是以参数作为开头
                {
                    result.add(new Student(infos[0],infos[1],infos[2]));
                    //根据找到的三个元素来创建一个匿名对象，并添加到容器中
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

        return(Student[])result.toArray(new Student[result.size()]);
    }

    //查询姓名中包含有某个字或某个词的学生信息
    public Student[] findStusContainsWords(String words)
    {
        ArrayList<Student> result=new ArrayList<Student>();
        //定义一个容器对象来保存结果
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
                if(infos[1].contains(words))//判断表示姓名的元素是否是以参数作为开头
                {
                    result.add(new Student(infos[0],infos[1],infos[2]));
                    //根据找到的三个元素来创建一个匿名对象，并添加到容器中
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

        return(Student[])result.toArray(new Student[result.size()]);
    }

    //往学生记录文件中插入一条学生记录
    public void addNewStudent(Student stu)
    {
        if(stu!=null)//首先判断插入对象不为空
        {
            if(!checkNumIsExist(stu.num))//判断学号是否已经存在
            {
                try
                {
                    FileWriter fw=new FileWriter("d:\\student.txt",true);
                    //表示在写文件的时候是追加而不是覆盖
                    BufferedWriter bw=new BufferedWriter(fw);
                    //通过文件字符输出流对象来创建缓冲的字符输出流对象
                    StringBuffer str=new StringBuffer();
                    str.append(stu.num+",");
                    str.append(stu.name+",");
                    str.append(stu.sex);
                    bw.newLine();//写入之前先换行
                    bw.write(str.toString());
                    bw.close();
                    fw.close();
                }
                catch (FileNotFoundException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    //判断学号是否已经在学生记录文件中存在
    private boolean checkNumIsExist(String num)
    {
        boolean result=false;
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
                if(infos[0].equals(num))//判断第一个元素是否等于所给的学号参数
                {
                    result=true;
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
        return result;//返回结果
    }


    public ArrayList<Student> getAllStudents()
    {
        ArrayList<Student> result=new ArrayList<Student>();
        //定义一个容器对象来保存结果
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
                result.add(new Student(infos[0],infos[1],infos[2]));
                //根据找到的三个元素来创建一个匿名对象，并添加到容器中
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
        return result;
    }

    //删除多条学生记录的方法
    public void delStudents(String[] nums)
    {
        if(nums!=null)
        {
            if(nums.length>0)
            {
                for(String temp:nums)
                {
                    delStudent(temp);
                }
            }
        }
    }

    //通过所给的学号来删除学生记录
    public void delStudent(String num)
    {
        ArrayList<Student> students=getAllStudents();
        //将文件中的所有的学生记录读取到容器对象中
        for(Student temp:students)//用foreach循环来遍历查找所有的学生对象
        {
            if(temp.num.equals(num))//判断某一个学生对象的学号是否和所给的参数学号是相等的
            {
                students.remove(temp);//将对应的学生对象移除出容器
                break;//退出循环，因为学号是唯一的
            }
        }
        ///以下操作为将容器对象中的学生记录覆盖式写入到学生记录文件中
        try
        {
            FileWriter fw=new FileWriter("d:\\student.txt");
            //创建文件字符输出流的时候，应该采用的是覆盖式的写入
            BufferedWriter bw=new BufferedWriter(fw);
            //创建一个缓冲的字符输出流对象
            for(Student temp:students)//用foreach循环来遍历查找所有的学生对象
            {
                //将某个学生对象转换为标准的字符串
                StringBuffer str=new StringBuffer();
                str.append(temp.num+",");
                str.append(temp.name+",");
                str.append(temp.sex);
                //将转换完的字符串写入到学生记录文件
                bw.write(str.toString());
                bw.newLine();//创建新的一行
            }
            bw.close();
            fw.close();//关闭两个输出流
        }
        catch(FileNotFoundException ex)
        {

        }
        catch(IOException ex)
        {

        }
    }
    //修改多条学生记录的方法
    public void updateStudents(Student[] stus)
    {
        if(stus!=null)
        {
            if(stus.length>0)
            {
                for(Student temp:stus)
                {
                    updateStudent(temp);
                }
            }
        }
    }

    //修改学生记录的方法
    public void updateStudent(Student student)
    {
        ArrayList<Student> students=getAllStudents();
        //将文件中的所有的学生记录读取到容器对象中
        for(Student temp:students)//用foreach循环来遍历查找所有的学生对象
        {
            if(temp.num.equals(student.num))//判断某一个学生对象的学号是否和所给的学生的学号是相等的
            {
                students.remove(temp);//将对应的学生对象移除出容器
                students.add(student);//将修改过的学生对象添加到容器中
                break;//退出循环，因为学号是唯一的
            }
        }
        ///以下操作为将容器对象中的学生记录覆盖式写入到学生记录文件中
        try
        {
            FileWriter fw=new FileWriter("d:\\student.txt");
            //创建文件字符输出流的时候，应该采用的是覆盖式的写入
            BufferedWriter bw=new BufferedWriter(fw);
            //创建一个缓冲的字符输出流对象
            for(Student temp:students)//用foreach循环来遍历查找所有的学生对象
            {
                //将某个学生对象转换为标准的字符串
                StringBuffer str=new StringBuffer();
                str.append(temp.num+",");
                str.append(temp.name+",");
                str.append(temp.sex);
                //将转换完的字符串写入到学生记录文件
                bw.write(str.toString());
                bw.newLine();//创建新的一行
            }
            bw.close();
            fw.close();//关闭两个输出流
        }
        catch(FileNotFoundException ex)
        {

        }
        catch(IOException ex)
        {

        }
    }

}