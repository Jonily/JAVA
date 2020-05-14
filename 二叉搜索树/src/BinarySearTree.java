


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
    public Node root = null;

    public boolean find(int key) {
        Node cur = root;
        while (cur != null){
            if(key < cur.key){
                //左子树中查找
                cur = cur.left;
            }else if(key > cur.key){
                //右子树中查找
                cur = cur.right;
            }else {
                return true;
            }
        }
        return false;
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

    public void remove(int key){
        //1、首先找到要删除节点的位置，同时记录下父节点位置
        Node cur = root;
        Node parent = null;
        while (cur != null){
            if(cur.key > key){
                //继续往左找
                parent = cur;
                cur = cur.left;
            }else if(cur.key < key){
                //继续往右找
                parent = cur;
                cur = cur.right;
            }else {
                //找到了要删除的节点
                removeNode(cur,parent);
                return;

            }
    }
        //没有找到节点，删除失败
        return;
}

    private void removeNode(Node cur, Node parent) {
       //左右子树都无归类到1、2中都可
        if(cur.left == null){
            //1、没有左子树
            if(cur == root){
                //1.1如果cur为根节点
                    root = cur.right;
            }else if(cur == parent.left){
                //1。2cur不为根节点而且为parent的左子树
                parent.left = cur.right;
            }else if(cur == parent.right){
               // 1.3cur不为根节点，且为parent的右子树
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            //2、没有右子树
            if(cur == root){
                //2.1如果cur为根节点
                root = cur.left;
            }else if(cur == parent.left){
                //2。2cur不为根节点而且为parent的左子树
                parent.left = cur.left;
            }else if(cur == parent.right){
                // 2.3cur不为根节点，且为parent的右子树
                parent.right = cur.left;
            }

        }else {
            //左右子树都有
            //1、先找到替罪羊节点，同时找到替罪羊的父节点
            Node scapeGoat = cur.right;
            Node scapeGoatParent = cur;
            while (scapeGoat.left != null){
                scapeGoatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            //循环结束之后，scapeGoat就指向了右子树中的最小值（最左侧节点）
            //2、把替罪羊的节点的key和value设置给cur
            cur.key = scapeGoat.key;
            cur.value = scapeGoat.value;
            //3、删除替罪羊节点
            if(scapeGoat == scapeGoatParent.left){
                scapeGoatParent.left = scapeGoat.right;
            }else {
                scapeGoatParent.right = scapeGoat.left;
            }
        }
    }

}
