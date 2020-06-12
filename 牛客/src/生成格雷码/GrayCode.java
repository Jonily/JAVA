package 生成格雷码;

import java.util.*;
//当n=1时 0、1
//当n=2时 00、01、10、11
//当n=3时 000、001、010、011、100、101、110、111
public class GrayCode {
    public String[] getGray(int n) {
        String[] ma = null;//先定义一个数组
        if(n == 1){
            return ma = new String[]{"0", "1"};//当n=1时，数组里面为0、1
        }else {
            String[] str = getGray(n - 1);//如果不为1，开始递归
            ma = new String[2 * str.length];//让数组大小扩充为原来的2倍
            for(int i=0; i < str.length; i++){
                ma[i] = "0"+str[i];//先让每个码前面加一个0，然后放入数组
                ma[ma.length-1-i] = "1"+str[i];//之后倒序，在每个码前面加1放入数组
            }
        }
        return ma;
        }
    }
