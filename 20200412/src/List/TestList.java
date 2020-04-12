package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/12 10:38
 */

public class TestList {
    public static void main(String[] args) {
        //1、实例化一个List
        List<String> list = new ArrayList<>();
        //2、新增元素
        list.add("C 语言");
        list.add("C++");
        list.add("Java");
        list.add("Python");
        list.add("PHP");
        //3、打印
        System.out.println(list);
        //4、使用下标
        //如果list是ArrayList  get/set按下标访问的方式比较高效O（1）
        //如果list是LinkedList，get/set访问就比较低效O（n）
        System.out.println(list.get(2));
        list.set(2,"Go");
        System.out.println(list);

        //5、截取部分内容
        System.out.println(list.subList(2,4));

        //6、重新构造一个List(浅拷贝)
        List<String> arrayList  = new ArrayList<>(list);
        List<String> linkedList = new LinkedList<>(arrayList);
        System.out.println(arrayList);
        System.out.println(linkedList);
        list.set(3,"Dark");
        System.out.println(list);
        System.out.println(arrayList);

        //7、基于现有List引用进行强制转换（向下转型）
        ArrayList<String> arrayList1 = (ArrayList<String>)list;
        LinkedList<String> linkedList1 = (LinkedList<String>)list;//顺序表不能转到链表


    }
}
