package 插入排序;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/30 20:35
 */

public class Sort {
    //升序排序为例
    public static void insertSort(int[] array) {
        for(int bound = 1; bound < array.length;bound++){
            //处理bound位置的元素如何向前插入
            int tmp = array[bound];
            int cur = bound - 1;
            for(; cur >= 0; cur--){
                if(array[cur] > tmp){
                    //tmp元素向前比较，同时将cur位置元素后移
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }
}
