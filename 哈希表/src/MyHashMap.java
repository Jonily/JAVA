

public class MyHashMap {
    static class Node{
        public int key;
        public int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] array = new Node[101];
    private int size = 0; //哈希表实际元素个数
    //负载因子：size/array.length

    private int hashFunc(int key){
        return key % array.length;
    }
    //插入
    public void put(int key, int value){
        //1、根据key带入哈希函数，计算下标，用key%数组长度
        int index = hashFunc(key);
        //2、根据下标得到对应的链表
        Node head = array[index];
        //3、先判定当前key是否存在，存在就修改value（不插入新节点）
        for( Node cur = head; cur != null; cur = cur.next){
            if(cur.key == key){
                cur.value = value;
                return;
            }
        }
        //4、如果不存在，则插入
        //进行链表头插
        Node newNode = new Node(key, value);
        newNode.next = head;
        array[index] = head;
        size++;
    }
    public Integer get(int key){
        //1、根据key得到hash值
        int index = hashFunc(key);
        //2、在对应的链表中查找指定key对应的节点
        Node head = array[index];
        for (Node cur = head; cur != null; cur = cur.next){
            if(cur.key == key){
                return cur.value;
            }
        }
        //3、没有找到
        return null;
    }
    //删除
    private Node finPrev(int key){ //找到要删除的前驱
        int index = hashFunc(key);
        Node prev = array[index];
        while (prev.next != null){
            if(prev.next.key == key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    public void delete(int key){
        int index = hashFunc(key);
        Node head = array[index];
        Node prev = finPrev(key);
        if(head.key == key){
             head.next = array[index];
            return;
        }
        if(prev == null){
            System.out.println("没有这个元素！");
            return;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        size--;
    }
}
