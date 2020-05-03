import java.util.Arrays;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/5/3 18:18
 */

public class insertSort {
    //升序排序
    public static void insertSort(int[] array){
        for(int bound = 1; bound < array.length; bound++){
            //有序区间[0,bound)
            //无序区间[bound,size)
            int tmp = array[bound];
            //从后往前，寻找合适的位置进行插入
            int cur = bound - 1;
            for( ;cur >= 0; cur--){
                if(array[cur] > tmp){
                    //tmp元素，从后往前遍历，同时把cur位置的元素往后搬运
                    array[cur+1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] a ={9,5,2,7,12,2};
        insertSort(a);
        System.out.print(Arrays.toString(a));
    }
}
