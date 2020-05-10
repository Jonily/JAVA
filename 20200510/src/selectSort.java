public class selectSort {
    public static void selectSort(int[] array){
        for(int bound = 0; bound < array.length; bound++){
            for(int cur = bound; cur <array.length;cur++){
                if(array[cur] < array[bound]){
                    swap(array,cur,bound);
                }
            }
        }
    }
    private static void swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
