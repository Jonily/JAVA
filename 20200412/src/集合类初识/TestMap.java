package 集合类初识;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/12 9:11
 */

public class TestMap {

    public static void main(String[] args) {
        //1、实例化一个map
        Map<String,String> map = new HashMap<>();
        //2、size isEmpty
        System.out.println(map.size());
        System.out.println(map.isEmpty());

        System.out.println("======================");
        //3、put 插入键值对，可以通过key找到value
        map.put("一号位","邓肯");
        map.put("二号位","奥尼尔");
        map.put("三号位","韦德");
        map.put("四号位","詹姆斯");
        map.put("五号位","科比");
        //4、使用get 根据可以找到value
        System.out.println(map.get("二号位"));
        System.out.println(map.get("六号位"));
        //找到key返回对应value，没有返回默认值
        System.out.println(map.getOrDefault("六号位","哈登"));


        System.out.println("====================");
        //5、使用contains判定元素是否存在
        //containKey比较高效O（1） containValueO（n）
        System.out.println(map.containsKey("一号位"));
        System.out.println(map.containsValue("科比"));



        System.out.println("====================");
        //6、循环遍历map 此处的entry表示一个一个的键值对
        //对于map内部对于元素顺序有自己的规则
        //Entry 表示条目，一个entry对象就是一个键值对，元素组织顺序取决于具体是HashMap还是TreeMap
        //HashMap 内部基于 哈希表实现 根据key的 hashCode来决定先后顺序
        //TreeMap内部是红黑树（一种更复杂的二叉搜索树），根据key的大小来决定先后顺序

        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
            
        }


        System.out.println("====================");
        //7、clear清空
        map.clear();
        System.out.println(map.size());
        System.out.println(map.isEmpty());







    }
}
