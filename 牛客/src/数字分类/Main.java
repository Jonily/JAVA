package 数字分类;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.nextLine();
            String[] a = s.split(" ");
            int [] n = new int[Integer.parseInt(a[0])];
            String []num = new String[5];

            for (int i = 0; i < a.length -1 ; i++) {
               n[i] = Integer.parseInt(a[i+1]);
            }
            int count = 0;
            int count1 = 0;
            int count2 = 0;
            int flag = 0;
            int sign = 0;
            double count3 = 0.0;
            int count4 = 0;
            for (int k = 0; k < n.length ; k++) {
                if(n[k]%5 == 0){
                    if(n[k]%2 ==0){
                        count += n[k];
                    }
                }
                if(n[k]%5 ==1 ){
                    sign++;
                    if( sign%2 == 0){
                        count1-= n[k];
                    }else  {
                        count1+=n[k];
                    }
                }
                if(n[k]%5 == 2){
                    count2++;
                }
                if(n[k]%5 == 3){
                    flag++;
                    count3+=n[k];
                }
                if(n[k]%5 == 4){
                    if(n[k] > count4){
                        count4 = n[k];
                    }
                }
            }
            if(flag == 0){
                num[3]="0";
            }else {
                double avg = count3/flag;
                num[3] = String .format("%.1f",avg);
            }

            num[0] = String.valueOf(count);
            num[1]= String.valueOf(count1);
            num[2]= String.valueOf(count2);
            num[4] = String.valueOf(count4);
            String str = "";
            for (int p = 0; p < num.length ; p++) {
                if("0".equals(num[p])  ){
                    num[p] = "N";
                }
            }
            for (int q = 0; q < num.length - 1 ; q++) {
                str+=num[q]+" ";
            }
            str+=num[4];
            System.out.println(str);

        }
    }
}
