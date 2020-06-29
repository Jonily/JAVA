package 记票统计;

/*import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            String[] name = new String[n];
            int[] sore = new int[n];
            for (int i = 0; i < n ; i++) {
                name[i] = in.next();
            }
            int s = in.nextInt();
            String[] str = new String[s];
            for (int j = 0; j < s ; j++) {
                str[j] = in.next();
            }
            for (int k = 0; k < n; k++) {
                int count = 0;
                for (int i = 0; i < str.length; i++) {
                    if(name[k].equals(str[i])){
                        count++;
                    }
                }
                sore[k] = count;
            }
            for (int m = 0; m < n; m++) {
                System.out.println(name[m] +" : "+sore[m]);
            }
            int sign = 0;
            for (int p = 0; p < n; p++ ){
                sign+=sore[p];
            }
            System.out.println("Invalid : "+(s-sign));

        }
    }
}*/


import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //统计人头
            int n = scan.nextInt();
            LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();
            String str = scan.nextLine();
            String[] array = str.split(" ");
            for(int i=0;i<array.length;i++){
                map.put(array[i],0);
            }
            map.put("Invalid",0);
            //投票计数
            int m = scan.nextInt();
            String strr = scan.nextLine();
            String[] arrays = strr.split(" ");
            for(String s :arrays){
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else{
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }
            Set<String> set = map.keySet();
            for(String s :set){
                System.out.println(s+" : "+map.get(s));

            }
        }
    }
}

