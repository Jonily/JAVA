package 集合类初识;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/12 8:48
 */

public class TestCollection {
    public static void main(String[] args) {
        //collection是一个接口 以下方法都是抽象方法，执行的时候取决于collecion对应的真实值
        //1、实例化一个collection 对象 collection是一个接口，必须要new一个类作为示例
        Collection<String> collection = new ArrayList<>();
        //尖括号里面是一个泛型，集合类具体保存什么类型由调用者决定
        //2、使用size/isEmpty
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        //3、使用add添加
        collection.add("我");
        collection.add("要");
        collection.add("去");
        collection.add("山顶");
        //4、再次使用size/isEmpty
        System.out.println("==============");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        //5、toArray 把集合转换成数组
        //String也是继承自Object ，array看似是Object其实是String类
        System.out.println("==============");
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(collection);
        
        //6、使用for each遍历collection
        //如果使用while或者for需要使用迭代器
        for (String s:collection) {
            System.out.println(s);

        }
        //7、判断元素是否存在 congtains 内部会拿传入的对象和集合里面的值比较 按值比较
        System.out.println("==============");
        boolean flag = collection.contains("山顶");
        System.out.println(flag);

        //8、使用remove删除
        System.out.println("==============");
        collection.remove("我");
        for (String s:collection) {
            System.out.println(s);

        }


        System.out.println("==============");
        // 9、使用clear清空
        collection.clear();
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());











    }
}
