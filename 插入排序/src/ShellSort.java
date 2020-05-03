import java.util.Arrays;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/5/3 23:26
 */

public class ShellSort {
    public static void shellSort(int[] array){
       //size/2,size/4.....
        int gap = array.length/2;
        while (gap > 1){
            insertSortGap(array,gap);
            gap = gap/2;
        }
        //当gap为1，再来一次最终插排
        insertSortGap(array,1);
    }
    private static void insertSortGap(int[] array,int gap){
        for(int bound = gap;bound < array.length; bound++){
            int tmp = array[bound];
            //同组相邻元素下标差gap，bound位置中相邻的前一个元素下标
            int cur = bound - gap;
            for(;cur >= 0;cur -= gap){
                if(array[cur] > tmp){
                    //进行搬运，把cur位置元素放到cur+gap位置
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur +gap] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a ={9,5,2,7,12,2};
        shellSort(a);
        System.out.print(Arrays.toString(a));
    }
}
