package 提取字符串中连续最长数字;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String ret = "";
        int count = 0;
        char [] arr = s.toCharArray();
        for (int i= 0 ;i<arr.length;i++){
            if('0'<=arr[i] && '9'>= arr[i]){//当前的是数字
                count = 1;//初始化计数器
                int index = i;//在后面的循环存储截至索引
                for(int j=i+1;j<arr.length;j++){
                    if('0'<=arr[j] && '9'>= arr[j]){
                        count++;
                        index =j;
                    }else {
                        break;
                    }
                }if(count>ret.length()){
                    ret = s.substring(i,index+1);
                }
            }else {
                continue;
            }

        }
        System.out.println(ret);
    }
}