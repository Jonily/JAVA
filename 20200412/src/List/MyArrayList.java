package List;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/12 9:58
 */
class Student{
    private String name ;
    private String sex;
}

public class MyArrayList<E> {//泛型
    //private E[] array = new E[100]; 不对
    private E[] array = (E[])new Object[100];
    private int size;


    void add(E o){
        array[size] = o;
        size++;
    }
    E get(int index){
        return array[index];
    }

    public static void main(String[] args) {
       /* MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("我");
        myArrayList.add("想");
        myArrayList.add("去");
        myArrayList.add("山");
        myArrayList.add("顶");

        String ret = (String)myArrayList.get(0);
        MyArrayList myArrayList1 = new MyArrayList();
        myArrayList1.add(new Student());
        myArrayList1.add(new Student());
        myArrayList1.add(new Student());
*/
       MyArrayList<String> myArrayList = new MyArrayList<>();
       myArrayList.add("heh");
       String s = myArrayList.get(0);


       MyArrayList<Student> myArrayList1 = new MyArrayList<>();
       myArrayList1.add(new Student());
       Student stu = myArrayList1.get(0);



    }
}
