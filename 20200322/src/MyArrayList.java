import java.util.Arrays;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/22 23:02
 */

public class MyArrayList {
    private int[] array;
    private int useSize;//顺序表中已经被占用的数据个数
    public static final int SIZE = 3; //定义顺序表默认的容量

    public MyArrayList(){
    this.array = new int[SIZE];
    this.useSize = 0;
}
//判断顺序表是不是满的

    private boolean isFull(){
    if(this.useSize==this.array.length){
        System.out.println("顺序表是满的！");
        return true;
        //throw new RuntimeException("顺序表是满的！");
    }else {
        return false;
    }
}
//判断顺序表是不是空的
    private boolean isEmpty() {
        if(this.useSize==0){
            return true;
    }
        return false;
}
    //判断pos是否合法

    private void adjustPos(int pos){
    if (pos < 0 || pos > this.useSize) {
        throw new ArrayIndexOutOfBoundsException("pos位置是不合法的！");//pos超出范围
    }
}
//打印顺序表

    public void display(){
    System.out.println("顺序表内容为：");
    for(int i =0;i<this.useSize;i++){
    System.out.print(this.array[i]+" ");
}
    System.out.println();
}
//在pos位置添加数据

    private void grow(){
    this.array = Arrays.copyOf(this.array,this.array.length*2);
}
    public void add(int pos,int data){
     if(isFull()){
         grow();
        }
    adjustPos(pos);
         for(int i = this.useSize-1; i >= pos;i--){
             this.array[i+1] = this.array[i];
         }
         array[pos] = data;
         this.useSize++;
}
//判定是否包含某个元素

    public boolean contain(int toFind){
    if (isEmpty()){
        throw new RuntimeException("顺序表是空的！");
    }
    System.out.println("判断结果为：");
        for(int i= 0;i <= this.useSize-1; i++){
            if(this.array[i] == toFind){
                return true;
            }
    }
          return false;
}
//查找元素并返回下标

    public int search(int toFind){
    if (isEmpty()){
        throw new RuntimeException("顺序表是空的！");
    }
    for(int i= 0;i < this.useSize-1; i++){
        if(this.array[i] == toFind){
            return i;
        }
    }
    return -1;
}
//获取pos位置的元素
    public int getPos(int pos){
        if (isEmpty()){
            throw new RuntimeException("顺序表是空的！");
        }
        adjustPos(pos);
        System.out.println("该位置元素为：");
        return this.array[pos];
    }
//删除第一次出现的关键字key
    public void remove(int key){
        //调用search查找是否存在key，不存在不需删除，存在求出下标
        int index = search(key);
        for(int i= index;i <this.useSize-1; i++){
            this.array[i]=this.array[i+1];
            }
            this.useSize--;
        }
    //获取顺序表长度
    public int size(){
        return this.useSize;
    }
    //清空顺序表
    public void clear(){
        this.useSize = 0;
    }
}
 class ArrayList{
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,10);
        myArrayList.add(1,20);
        myArrayList.add(2,30);
        myArrayList.display();
        myArrayList.add(2,40);
        myArrayList.display();

    }
}


