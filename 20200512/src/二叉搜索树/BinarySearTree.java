package 二叉搜索树;

public class BinarySearTree {
    static class Node{
        public int key;
        public int value;
        Node left;
        Node right;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
    private Node root = null;
    /**
     * 在搜索树中查找    key，如果找到，返回    key 所在的结点，否则返回    null
     * @param key
     * @return
     */
    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if (key == cur.key) {
                return cur;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
    /**
     * 插入
     * @param key
     * @return true 表示插入成功, false 表示插入失败
     */
    public Node insert1(int key,int value) {
        //1、如果本身是空树，直接让root指向新节点
        if (root == null) {
            root = new Node(key,value);
            return root;
        }
        //2、先找到key所在的位置
        Node cur = root;
        Node prev = null;
        while (cur != null) {
            if(key < cur.key){
                //继续向左查找
                prev = cur;
                cur = cur.right;
            }else if(key > cur.key){
                //继续往右找
                prev = cur;
                cur = cur.right;
            }else {
                //找到了key相同的元素
                //针对key重复的情况
                //1、直接插入失败
                //2、不创建新节点，把当前节点的value改成新的value（采用这种）
                cur.value = value;
                return cur;
            }
        }
        Node newNode = new Node(key,value);
        if(prev.key > newNode.key){
            prev.left = newNode;
        }else {
            prev.right = newNode;
        }
        return newNode;
    }
    public static void prevOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.key);
        prevOrder(root.left);
        prevOrder(root.right);
    }
    public void remove(int key){
        //1、先找到要删除节点的位置，找的同时记录下该节点父节点位置
        Node cur = root;
        Node parent = null;
        while (cur != null ){
            if(key < cur.key){
                parent = cur;

            }
        }
    }
    private void removeNode(Node cur, Node parent){
        //如果左右子树都没有归类到12都可
        if(cur.left == null){
            //1、没有左子树的情况
            if(cur == root){
                //1.1如果cur为根节点
                root = cur.right;

            }else if(cur == parent.left){
                //1.2 cur不为根节点，且为父亲的左子树
                parent.left = cur.right;
            }else if(cur == parent.right){
                //1.3 cur不为根节点，且为父亲的右子树
                parent.right = cur.right;
            }

        }else if(cur.right == null){
            //2.没有右子树的情况
            if(cur == root){
                //2.1 cur为根节点
                root = cur.left;
            }else if(cur == parent.left){
                //2.2 cur不为根节点，且为父亲的左子树
                parent.left = cur.right;
            }else if(cur == parent.right){
                //2.3 cur不为根节点，且为父亲的右子树
                parent.right = cur.right;
            }

        }else {
            //3、左右子树都有
            //a)先找替罪羊节点，同时记录替罪羊节点的父节点
            Node scapeGoat = cur.right;
            Node scapeGoatParent = cur;
            while (scapeGoat.left != null){
                scapeGoatParent = scapeGoat;
                scapeGoat = scapeGoat.left;

            }
            //循环结束后，scapeGoat 就指向了右子树中的最左侧节点
            //b）把替罪羊节点的key和value设置给cur
            cur.key = scapeGoat.key;
            cur.value = scapeGoat.value;
            //c) 删除替罪羊节点
            if(scapeGoat == scapeGoatParent.left){
                scapeGoatParent.left = scapeGoat.right;
            }else if(scapeGoat == scapeGoatParent.right){
                scapeGoatParent.right = scapeGoat.left;
            }

        }
    }
    public boolean insert(int key, int value) {
        if (root == null) {
            root = new Node(key,value);
            return true;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (key == cur.key) {
                return false;
            } else if (key < cur.key) { parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        Node node = new Node(key,value);
        if (key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return true;


       }
}
