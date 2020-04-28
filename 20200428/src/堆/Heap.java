package 堆;

import java.util.Arrays;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/28 19:30
 */

public class Heap {



    public static void shiftDown(int[] array, int size,int index){
        int parent = index;
        //根据父节点下标，先找到左子树下标
        int child = 2*parent+1;

        while (child < size){
            //再去找下右子树对应的节点
            if(child + 1 < size && array[child + 1] > array[child]){//child合法并且如果右子树大于根
                child = child + 1;
            }
            //child经过上面的条件，指向左右子树中较大的一个
            //拿刚刚child位置的元素和parent位置进行对比，看是否符合大堆要求
            //如果不符合大堆要求（child位置的元素比parent位置的元素大）交换child和parent位置的元素
            if(array[child] > array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else{
                //当前child和parent的关系符合大堆要求，调整完毕
                break;
            }
            //下次循环之前，需要先更新parent和child
            parent = child;
            child = 2*parent + 1;

        }
    }

    public static void creatHeap(int[] array,int size) {
        //从后向前遍历，从最后一个非叶子节点出发，依次进行向下调整
        //size-1最后一个节点，再-1/2是找到最后一个节点的父节点
        for(int i = (size - 1 -1)/2; i > 0 ;i--){
            shiftDown(array,size,i);

        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        creatHeap(array,array.length);
        System.out.print(Arrays.toString(array));
    }
}
