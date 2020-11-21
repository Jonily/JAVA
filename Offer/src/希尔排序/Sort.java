package 希尔排序;


import java.util.Arrays;

public class Sort {
    public static void shellSort(int[] array){
        int gap = array.length/2;
        while (gap > 1){
            insertShellSort(array,gap);
            gap = gap/2;
        }
        insertShellSort(array,1);
    }

    private static void insertShellSort(int[] array,int gap) {
        for (int bound = gap; bound < array.length ; bound++) {

            int tmp = array[bound];
            int cur = bound - gap;
            for (; cur >= 0 ; cur-=gap) {
                if(array[cur] > tmp){
                    array[cur+gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = tmp;

        }
    }

    public static void main(String[] args) {
        int[] a ={9,5,2,7,12,2};
        shellSort(a);
        System.out.print(Arrays.toString(a));
    }
}
