import java.util.Arrays;

public class BubbleSort1 {
    public static void BubbleSort(int[] array){
        for(int bound = 0; bound < array.length; bound++){
            for(int cur = 0; cur < array.length - 1; cur++){
                if(array[cur] > array[cur + 1]){
                    swap(array,cur,cur + 1);
                }
            }
        }

    }
    private static void swap(int[] array,int i,int k){
        int tmp = array[i];
        array[i] = array[k];
        array[k] = tmp;
    }

    public static void main(String[] args) {
        int[] a ={9,5,2,7,4,3,8};
        BubbleSort(a);
        System.out.print(Arrays.toString(a));
    }

}
