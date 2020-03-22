/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/3/22 15:54
 */

  public class MyArrayList {
    public int[] elem;//null
    public int usedSize;//0

    //设置默认容量
    public static final int DEFAULT_SIZE = 10;

    public MyArrayList(int a,double data) {
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }

    private boolean isFull() {
        if (this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    public void display(int num,double a){
        for(int i = 0;i<this.usedSize;i++){
            System.out.println(this.elem[i]);
        }
    }
    private boolean isNo() {
        if (this.usedSize == 0) {
            return true;
        }
        return false;
    }

    public void add(int pos, int data) {
        int i = usedSize - 1;
        if (isFull()) {
            System.out.println("顺序表是满的！");
            return;
        }
        if (pos < 0 || pos > this.usedSize) {
            throw new ArrayIndexOutOfBoundsException("pos是不合法的！");
        }
        while (i >= pos) {
            this.elem[i + 1] = this.elem[i];
            i--;
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind) {
        if (isNo()) {
            System.out.println("顺序表是空的！");
            return false;

        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;

    }
    public int search(int toFind) {
        int i = 0;
        for (i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
public  int getPos(int pos){
    if (isFull()) {
        System.out.println("顺序表是满的！");
        return 1;
    }
        if(pos<0||pos>this.usedSize){
            return -1;
        }
        return this.elem[pos];
}

public void remove(int key){
        int index =search(key);
        if(index!=-1){
            for (int i = index ;i<this.usedSize- 1;i++){
                this.elem[i] = this.elem[i+1];
            }
        }
    this.usedSize--;
    }
}

