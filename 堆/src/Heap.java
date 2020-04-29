/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/29 17:50
 */

public class Heap {

    public void shiftDown(int[]array,int size,int index){
        int parent = index;
        int child = 2*parent+1;
        while (child < size){
            if(child+1 < size && array[child+1] > array[child]){
                child = child + 1;
            }
            if(array[parent] < array[child]){
            int tmp = array[child];
            array[child] = array[parent];
            array[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = 2*parent+1;
        }
    }

    public void createHeap(int[]array,int size){
        for(int i = (size-1-1)/2; i >= 0; i--){
            shiftDown(array,size,i);
        }

    }
}
