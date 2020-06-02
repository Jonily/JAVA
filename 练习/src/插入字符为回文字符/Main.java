package 插入字符为回文字符;
import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //System.out.print("请输入第一个字符串：");
        String s1 = sc.nextLine();
        //System.out.print("请输入第二个字符串：");
        String s2 = sc.nextLine();
        //获取第一行字符串的长度
        int length = s1.length();
        //计数
        int count=0;
        for(int i=0;i<=length;i++){
            StringBuffer sb = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            sb=sb.append(s1).insert(i,s2);
            sb2=sb2.append(s1).insert(i,s2).reverse();
            String s3=sb.toString();
            String s4=sb2.toString();
            //System.out.println(s3+"/"+s4+"/"+s3.equals(s4));
            if(s3.equals(s4)){
                count++;
            }
        }
        System.out.print(count);
    }
}
