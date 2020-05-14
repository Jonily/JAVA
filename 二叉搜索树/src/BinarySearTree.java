


public class BinarySearTree {
    class Node{
        public int key;
        public int value;
        Node left;
        Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //记录树的根节点，root==null，当前是个空树
    private Node root = null;

    public Node find(int key) {
        Node cur = root;
        while (cur != null){
            if(key < cur.key){
                //左子树中查找
                cur = cur.left;
            }else if(key > cur.key){
                //右子树中查找
                cur = cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }

    public Node insert(int key, int value){
        //1、如果树本身是空树，直接让root指向新节点
        if(root == null){
            root = new Node(key, value);
            return root;
        }
        //2、先找到key所在的位置
        Node cur = root;
        Node prev = null;
        while (cur != null){
            if(cur.key > key){
                //继续往左找
                prev = cur;
                cur = cur.left;
            }else if(cur.key < key){
                //继续往右找
                prev = cur;
                cur = cur.right;
            }else {
                //找到了和key相同的元素
                //针对key相同
                // 1、直接插入失败
                // 2、不创建新节点，把当前的节点的value改成新的value（和标准库一致）
                cur.value = value;
                return cur;

            }
        }
        //循环结束，cur为null，直到了合适的插入地点
        //新节点判断大小之后插入到prev节点的下面
        Node newNode = new Node(key, value);
        if(newNode.key < prev.key){
            prev.left = newNode;
        }else {
            prev.right = newNode;
        }
        return newNode;
    }


}
