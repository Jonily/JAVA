package 优先队列;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/28 20:24
 */

public class MyPriority {
    private int[] array = new int[100];
    private int size = 0;//[0,size)表示有效元素区间

    public void offer(int x){
    //1、先把x放到数组元素的末尾
        array[size] = x;
        size++;
        //2、把x进行向上调整
        //第一个参数表示数组，第二个为有效元素的个数，第三个参数表示从哪个位置进行向上调整
        shifUp(array,size,size-1);
    }

    private void shifUp(int[] array, int size, int index) {
        int child  = index;
        //根据父节点下标，先找到左子树下标
        int parent = (child-1)/2;
        //如果child=0，说明child已经是根节点，根节点无父节点

        while (child > 0){
            //比较当前child和parent之间的大小关系看看是否符合大堆
            //再去找下右子树对应的节点
            if(array[parent] < array[child]){//child合法并且如果右子树大于根
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else{
                //当前child和parent的关系符合大堆要求，调整完毕
                break;
            }
            //下次循环之前，需要先更新parent和child
            child = parent;
            parent = (child-1) / 2 ;
        }
    }
    public Integer poll(){
    if(size <= 0){
        return null;
    }
    int ret = array[0];
    //如何删除队首元素（根节点）
        //1、把最后一个元素的值填入到0号元素
        array[0] = array[size-1];
        //2、删除最后一个元素
        size--;
        //3、从0下标开始向下调整
        shifDown(array,size,0);
        return ret;

    }
    private void shifDown(int[] array,int size,int index){
        int parent = index;
        //根据父节点下标，先找到左子树下标
        int child = 2 * parent + 1;

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
            child = 2 * parent + 1;

        }
    }

    public Integer peek(){
    if(size == 0){
        return null;
    }
    return array[0];
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriority myPriorityQueue = new MyPriority();
        myPriorityQueue.offer(5);
        myPriorityQueue.offer(6);
        myPriorityQueue.offer(9);
        myPriorityQueue.offer(1);
        myPriorityQueue.offer(3);
        myPriorityQueue.offer(0);
        myPriorityQueue.offer(7);
        while (!myPriorityQueue.isEmpty()){
            Integer cur = myPriorityQueue.poll();
            System.out.print(cur+" ");
        }
    }
}
