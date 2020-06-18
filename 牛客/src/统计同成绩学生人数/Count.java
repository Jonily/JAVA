package 统计同成绩学生人数;

import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String pNum = in.nextLine();
            if(pNum.equals("0")){
                System.out.println();
                break;
            }
            String n = in.nextLine();
            String []per = n.split(" ");


            String b = in.nextLine();
            int count = 0;
            for (int i = 0; i < per.length ; i++) {
                if(b.equals(per[i])){
                    count++;
                }
            }
            System.out.println(count);
        }


    }
}
