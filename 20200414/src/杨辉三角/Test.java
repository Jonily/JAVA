package 杨辉三角;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/14 8:17
 */

public class Test {
    public static List<List<Integer>> gengerate(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0){
            return result;
        }
        //处理第一行，固定一个1
        ArrayList<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1){
            return result;
        }
        //处理第二行
        ArrayList<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2){
            return result;
        }
        //处理后面
        for(int row = 3; row <=numRows; row++){
            //构造第row行需要依赖前一行row-1为上一行再-1就变成上一行的第一个元素值下标
            List<Integer> prevLine = result.get(row -1 -1);
            //构建当前行
            List<Integer> curLine = new ArrayList<>();
            //当前行第一列，就是1
            curLine.add(1);
            for(int col  = 2 ; col <= row-1; col++){
                int tmp1 = prevLine.get(col-1-1);//上一行的第一个
                int tmp2 = prevLine.get(col-1);//上一行的第二个
                curLine.add(tmp1+tmp2);
            }
            //当前行最后一列，就是1
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("输入行数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> list = gengerate(n);
        System.out.println(list);
    }
}
