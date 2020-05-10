import java.util.Arrays;

public class bubbleSort {
    public static void bubbleSort(int[] array){
        for(int bound = 0; bound < array.length; bound++){
            for(int cue = array.length - 1; cue > bound;cue--){
                if(array[cue - 1] > array[cue]){
                    swap(array,cue,cue-1);
                }
            }
        }
    }
    private static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void main(String[] args) {
        int[] a ={9,5,2,7,4,3,8};
        bubbleSort(a);
        System.out.print(Arrays.toString(a));
    }
}
