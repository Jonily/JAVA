package 教师文本操作;
import java.io.*;
import java.util.*;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/24 10:38
 */

public class TeacherDeal {
   //构建教师对象
    class Teacher{
        public String num;
        public String name;
        public String sex;
        public String course;
        public String jobNum;

        public Teacher( String num, String name, String sex, String course,String jobNum) {
            this.num = num;
            this.name = name;
            this.sex = sex;
            this.course = course;
            this.jobNum = jobNum;
        }

       @Override
       public String toString() {
           return '\n' +
                   "num='" + num + '\'' +
                   ", name='" + name + '\'' +
                   ", sex='" + sex + '\'' +
                   ", course='" + course + '\'' +
                   ", jobNum='" + jobNum ;
       }
   }

    //获取所有教师信息
       public ArrayList<Teacher> getAllTea(){
           ArrayList<Teacher> result = new ArrayList<>();
           //定义一个容器存放数据
           try{
               //文件字符输入流对象
               FileReader fr = new FileReader("d:\\teacher.txt");
               //以文件字符输入流对象为参数创建一个缓冲字符输入流对象
               BufferedReader br = new BufferedReader(fr);
               String tmp = br.readLine();//c=从文件中读取第一行
               while (tmp != null){
                   //将读取到的一行数据放到一个字符串数组再使用切割行数“，”分割成几部分
                   String[] infos = tmp.split(",");
                   //根据找到的四个元素创建一个匿名对象，并添加到容器中
                   result.add(new Teacher(infos[0],infos[1],infos[2],infos[3],infos[4]));
                   //再次读取一行数据
                   tmp = br.readLine();
               }
               br.close();
               fr.close();
           } catch (FileNotFoundException e) {//子类在前
               e.printStackTrace();
           } catch (IOException e) {//父类在后
               e.printStackTrace();
           }
           return result;
       }
       //通过工号查询姓名
    public String findNameByJobNum(String jobNum){
        String name = "查无此人！";//初始定义，如果没有找到则返回name初始值
        try{
            //文件字符输入流对象
            FileReader fr = new FileReader("d:\\teacher.txt");
            //创建一个缓冲字符输入流以文件字符输入流为对象
            BufferedReader br = new BufferedReader(fr);
            String tmp = br.readLine(); //每次读取一行每一行的数据存储到tmp中
            while (tmp != null){
                String [] infos = tmp.split(",");//创建数组存放每一行被“，”分割的每一个元素
                if(infos[4].equals(jobNum)){
                    name = infos[1];
                    break;
                }
                tmp = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
    /*//定义一个通过姓名查找学号的方法
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
    }*/

    //通过姓名查询顺序号
    public ArrayList<String> findNumByName(String name){
        //定义一个容器用来保存结果
        ArrayList<String> result = new ArrayList<>();
        try{
            //文件字符输入流对象
            FileReader fr = new FileReader("d:\\teacher.txt");
            //以文件字符输入流对象为参数创建一个缓冲字符输入流对象
            BufferedReader br = new BufferedReader(fr);
            String tmp = br.readLine();//c=从文件中读取第一行
            while (tmp != null){
                //将读取到的一行数据放到一个字符串数组再使用切割行数“，”分割成几部分
                String[] infos = tmp.split(",");
                //根据找到的元素比较，并添加到容器中
                if(infos[1].equals(name)){
                    result.add(infos[0]);
                }
                //再次读取一行数据
                 tmp = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {//子类在前
            e.printStackTrace();
        } catch (IOException e) {//父类在后
            e.printStackTrace();
        }
        return result;
    }
    //通过工号查找教师对象
    public Teacher findTeaByJobNum(String jobNum){
        Teacher teacher = null;
        try{
            //文件字符输入流对象
            FileReader fr = new FileReader("d:\\teacher.txt");
            //以文件字符输入流对象为参数创建一个缓冲字符输入流对象
            BufferedReader br = new BufferedReader(fr);
            String tmp = br.readLine();//c=从文件中读取第一行
            while (tmp != null){
                //将读取到的一行数据放到一个字符串数组再使用切割行数“，”分割成几部分
                String[] infos = tmp.split(",");
                //根据传入的号码和第5个元素比较
                if(infos[4].equals(jobNum)){
                    teacher = new Teacher(infos[0],infos[1],infos[2],infos[3],infos[4]);
                    break;
                }
                //再次读取一行数据
                tmp = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {//子类在前
            e.printStackTrace();
        } catch (IOException e) {//父类在后
            e.printStackTrace();
        }
        return teacher;
    }
    //通过教师姓名查找教师对象
    public Teacher findTeaByName(String name){
        Teacher teacher = null;
        try{
            //文件字符输入流对象
            FileReader fr = new FileReader("d:\\teacher.txt");
            //以文件字符输入流对象为参数创建一个缓冲字符输入流对象
            BufferedReader br = new BufferedReader(fr);
            String tmp = br.readLine();//c=从文件中读取第一行
            while (tmp != null){
                //将读取到的一行数据放到一个字符串数组再使用切割行数“，”分割成几部分
                String[] infos = tmp.split(",");
                //根据传入的号码和第2个元素比较
                if(infos[1].equals(name)){
                    teacher = new Teacher(infos[0],infos[1],infos[2],infos[3],infos[4]);
                    break;
                }
                //再次读取一行数据
                tmp = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {//子类在前
            e.printStackTrace();
        } catch (IOException e) {//父类在后
            e.printStackTrace();
        }
        return teacher;
    }
    //根据姓来查找教师信息
    public ArrayList<Teacher> findTeaByLastName(String LastName){
        ArrayList<Teacher> result = new ArrayList<>();
        try{
            //文件字符输入流对象
            FileReader fr = new FileReader("d:\\teacher.txt");
            //以文件字符输入流对象为参数创建一个缓冲字符输入流对象
            BufferedReader br = new BufferedReader(fr);
            String tmp = br.readLine();//c=从文件中读取第一行
            while (tmp != null){
                //将读取到的一行数据放到一个字符串数组再使用切割行数“，”分割成几部分
                String[] infos = tmp.split(",");
                if(infos[1].startsWith(LastName)){//判断表示姓名的元素是否是以参数作为开头
                    result.add(new Teacher(infos[0],infos[1],infos[2],infos[3],infos[4]));
                    //根据找到的三个元素来创建一个匿名对象，并添加到容器中
                }
                //再次读取一行数据
                tmp = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {//子类在前
            e.printStackTrace();
        } catch (IOException e) {//父类在后
            e.printStackTrace();
        }
        return result;
    }
    //查询姓名中包含有某个子或者某个词的教师信息
    public ArrayList<Teacher> findTeaContainsWords(String words){
        ArrayList<Teacher> result = new ArrayList<>();
        try{
            //文件字符输入流对象
            FileReader fr = new FileReader("d:\\teacher.txt");
            //以文件字符输入流对象为参数创建一个缓冲字符输入流对象
            BufferedReader br = new BufferedReader(fr);
            String tmp = br.readLine();//c=从文件中读取第一行
            while (tmp != null){
                //将读取到的一行数据放到一个字符串数组再使用切割行数“，”分割成几部分
                String[] infos = tmp.split(",");
                if(infos[1].contains(words)){//判断表示姓名的元素是否是以参数作为开头
                    result.add(new Teacher(infos[0],infos[1],infos[2],infos[3],infos[4]));
                    //根据找到的三个元素来创建一个匿名对象，并添加到容器中
                }
                //再次读取一行数据
                tmp = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {//子类在前
            e.printStackTrace();
        } catch (IOException e) {//父类在后
            e.printStackTrace();
        }
        return result;
    }
    //判断学号是否在学生记录文件中
    private boolean checkNumIsExist(String num){
        boolean result = false;
        try{
            //文件字符输入流对象
            FileReader fr = new FileReader("d:\\teacher.txt");
            //以文件字符输入流对象为参数创建一个缓冲字符输入流对象
            BufferedReader br = new BufferedReader(fr);
            String tmp = br.readLine();//c=从文件中读取第一行
            while (tmp != null){
                //将读取到的一行数据放到一个字符串数组再使用切割行数“，”分割成几部分
                String[] infos = tmp.split(",");
                if(infos[4].equals(num)){//判断表示姓名的元素是否是以参数作为开头
                    result = true;
                    break;
                }
                //再次读取一行数据
                tmp = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {//子类在前
            e.printStackTrace();
        } catch (IOException e) {//父类在后
            e.printStackTrace();
        }
        return result;

    }
    //往教师记录文件中插入一条教师记录
    public  void addNewTea(Teacher Tea){
        if(Tea != null){
            if(!checkNumIsExist(Tea.jobNum)){
                try{
                    FileWriter fr = new FileWriter("d:\\teacher.txt",true);
                    //表示在写文件的时候是追加不是覆盖
                    BufferedWriter bw = new BufferedWriter(fr);
                    //通过文件字符输出流对象来创建缓冲的字符输出流对象
                    StringBuffer str = new StringBuffer();
                    str.append(Tea.num+",");
                    str.append(Tea.name+",");
                    str.append(Tea.sex+",");
                    str.append(Tea.course+",");
                    str.append(Tea.jobNum);
                    bw.newLine();
                    bw.write(str.toString());
                    bw.close();
                    fr.close();
                } catch (FileNotFoundException e) {//子类在前
                    e.printStackTrace();
                } catch (IOException e) {//父类在后
                    e.printStackTrace();
                }
            }
        }
    }
    //修改教师记录的方法
    public void updateTeacher(Teacher Tea){
        ArrayList<Teacher> teachers = getAllTea();
        //将所有的教师全部放到已读取容器中
        for(Teacher tmp : teachers){//遍历
            if(tmp.num.equals(Tea.num) ){//判断一个教师对象学号是否与所给的学号相等
                teachers.remove(tmp);//将对应的教师对象移除
                teachers.add(Tea);//将修改过的教师加进去
                break;
            }
        }
        ///以下操作为将容器对象中的教师记录覆盖式写入到教师记录文件中
        try
        {
            FileWriter fw = new FileWriter("d:\\teacher.txt");
            //创建文件字符输出流的时候，采用的是覆盖式的写入
            BufferedWriter bw = new BufferedWriter(fw);
            //创建一个缓冲的字符输出流对象
            for(Teacher tmp : teachers)//用foreach循环来遍历查找所有的学生对象
            {
                //将某个教师对象转换为标准的字符串
                StringBuffer str = new StringBuffer();
                str.append(tmp.num+",");
                str.append(tmp.name+",");
                str.append(tmp.sex+",");
                str.append(tmp.course+",");
                str.append(tmp.jobNum);
                //将转换完的字符串写入到教师记录文件
                bw.write(str.toString());
                bw.newLine();//创建新的一行
            }
            bw.close();
            fw.close();//关闭两个输出流
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    //修改多条教师记录的方法
    public void updateTeachers(Teacher[] tea)
    {
        if(tea!=null)
        {
            if(tea.length>0)
            {
                for(Teacher temp:tea)
                {
                    updateTeacher(temp);
                }
            }
        }
    }
    //删除多条教师记录的方法
    public void delTeachers(String[] nums)
    {
        if(nums!=null)
        {
            if(nums.length>0)
            {
                for(String temp:nums)
                {
                    delTeacher(temp);
                }
            }
        }
    }

    //通过所给的顺序号来删除教师记录
    public void delTeacher(String num)
    {
        ArrayList<Teacher> tea =getAllTea();
        //将文件中的所有的教师记录读取到容器对象中
        for(Teacher temp : tea)//用foreach循环来遍历查找所有的教师对象
        {
            if(temp.num.equals(num))//判断某一个教师对象的学号是否和所给的参数顺序号是相等的
            {
                tea.remove(temp);//将对应的教师对象移除出容器
                break;//退出循环，因为顺序是唯一的
            }
        }
        ///以下操作为将容器对象中的教师记录覆盖式写入到教师记录文件中
        try
        {
            FileWriter fw=new FileWriter("d:\\teacher.txt");
            //创建文件字符输出流的时候，应该采用的是覆盖式的写入
            BufferedWriter bw=new BufferedWriter(fw);
            //创建一个缓冲的字符输出流对象
            for(Teacher tmp:tea)//用foreach循环来遍历查找所有的教师对象
            {
                //将某个教师对象转换为标准的字符串
                StringBuffer str=new StringBuffer();
                str.append(tmp.num+",");
                str.append(tmp.name+",");
                str.append(tmp.sex+",");
                str.append(tmp.course+",");
                str.append(tmp.jobNum);
                //将转换完的字符串写入到教师记录文件
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
    public static void main(String[] args) {
        File file = new File("d:\\teacher.txt");
        TeacherDeal teacherDeal = new TeacherDeal();
        System.out.println("输出所有信息：");
        System.out.println(teacherDeal.getAllTea());
        System.out.println("=====================");
        System.out.println("通过工号查询姓名：");
        System.out.println(teacherDeal.findNameByJobNum("19820317"));
        System.out.println("=====================");
        System.out.println("通过姓名查询顺序号：");
        System.out.println(teacherDeal.findNumByName("张三"));
        System.out.println("=====================");
        System.out.print("通过工号查找教师对象：");
        System.out.println(teacherDeal.findTeaByJobNum("19820317"));
        System.out.println("=====================");
        System.out.print("通过教师姓名查找教师对象：");
        System.out.println(teacherDeal.findTeaByName("李四"));
        System.out.println("=====================");
        System.out.print("根据姓来查找教师信息：");
        System.out.println(teacherDeal.findTeaByLastName("李"));
        System.out.println("=====================");
        System.out.print("查询姓名中包含有某个子或者某个词的教师信息：");
        System.out.println(teacherDeal.findTeaContainsWords("三"));
        System.out.println("=====================");
        System.out.print("往教师记录文件中插入教师记录：");
        TeacherDeal.Teacher teacher = teacherDeal.new Teacher("t03","赵碗","女","物联网工程","19820456");
        teacherDeal.addNewTea(teacher);
        TeacherDeal.Teacher teacher1 = teacherDeal.new Teacher("t04","王哥","男","应用化学","19820778");
        teacherDeal.addNewTea(teacher1);
        System.out.println(teacherDeal.getAllTea());
        System.out.println("=====================");
        System.out.print("修改教师记录的方法：");
        TeacherDeal.Teacher teacher2 = teacherDeal.new Teacher("t01","张露","女","经济学","19820887");
        teacherDeal.updateTeacher(teacher2);
        System.out.println(teacherDeal.getAllTea());
        System.out.println("=====================");
        System.out.print("通过所给的顺序号来删除教师记录：");
        teacherDeal.delTeacher("t02");
        System.out.println(teacherDeal.getAllTea());

    }

}
