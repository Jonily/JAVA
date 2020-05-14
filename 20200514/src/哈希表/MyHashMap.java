package 哈希表;
//基于链表的开散列
public class MyHashMap {
    static class Node{
        public int key;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int value;
        Node next;
    }


    private Node[] array = new Node[101];
    private int size = 0;
    //负载因子：size/array.length

    private int hashFunc(int key) {
        return key % array.length;

    }

    //插入键值对
    public void put(int key, int value){
        //1、根据key带入到hash函数中，计算得到下标
        int index = hashFunc(key);
        //2、根据下标得到对应结果
        Node head = array[index];
        //3、先判定当前key是否存在，如果存在就修改value，不存在进行插入
        for(Node cur = head; cur != null; cur = cur.next){
            if(cur.key == key){
                cur.value = value;
                return;
            }
        }
        //4、如果不存在进行输入
        //链表头插简单
        Node newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
        size++;
    }

    public Integer get(int key){
        //1、根据key得到hash值
        int index = hashFunc(key);
        //2、在对应的链表上查找指定的key对应的节点
        Node head = array[index];
        for(Node cur = head; cur != null; cur = cur.next ){
            if(cur.key == key){
                return cur.value;
            }
        }
        //3、没有找到
        return null;
    }


}


