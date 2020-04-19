package 二叉树;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/19 14:38
 */

public class TestTree{
    static class Node{
        public Node(char val) {
            this.val = val;
        }



        public char val;
        public Node left;
        public Node right;
        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }


    static Node build(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        C.right = F;
        B.left = D;
        B.right = E;
        E.left = G;
        return A;
    }
    public static void preOrder(Node root){

        if(root == null){
            return;
        }

        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void inOrder(Node root){

        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");

        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    public static int treeSize = 0;
    public static void size(Node root){
        if(root == null){
            return;
        }
        treeSize++;//访问节点操作
        size(root.left);
        size(root.right);
    }

    //直接通过size返回值来返回树的节点
    public static int size1(Node root){
        if(root == null){
            //空树里面0个节点
            return 0;
        }
        //通过递归
        //整个树的节点=根节点数+左子树节点个数+右子树节点个数
        return 1+size1(root.left)+size1(root.right);
    }

    public static int LeafSize = 0;
    public static void LeafSize(Node root){
        if(root == null){
            //空树里面0个节点
            return;
        }
        if(root.left == null && root.right == null){
            //如果满足条件,说明root是叶子节点
            LeafSize++;
        }
        LeafSize(root.left);
        LeafSize(root.right);

    }
    public static int leafSize(Node root){
        //利用递归
        if(root == null){
            //空树里面0个节点
            return 0 ;
        }
        if(root.left == null && root.right == null){
            //如果满足条件,说明root是叶子节点
            return 1;
        }
        //求当前这个数叶子节点的个数 = 左子树中叶子节点个数+右子树中叶子节点个数
        return leafSize(root.left)+leafSize(root.right);
    }
    //求第K层节点个数

    public static int leveSize(Node root,int k ){
        if(root == null|| k<1){
            //空树里面0个节点
            return 0 ;
        }
        if(k == 1){
            //第一层节点的个数
            return 1;
        }
        //求当前这个树k层节点的个数 = 左子树中k-1节点个数+右子树中k-1节点个数
        return leveSize(root.left,k-1)+leveSize(root.right,k-1);
    }
    //在二叉树中查找某个值是否存在
    //对二叉树进行遍历，依次比较每个节点的值
    public static Node result = null;
    public static void find (Node root,char toFind){
        if(root == null){
            //空树里面0个节点
            return ;
        }
        if(root.val == toFind){
            result = root;
            return;
        }
        find(root.left, toFind);
        find(root.right, toFind);
    }


    //返回值表示查找到
    //没找到返回null
    public static Node find1(Node root, char toFind){
        if(root == null){
            //空树里面0个节点
            return null;
        }
        //先看根节点是不是要查找的元素
        //再分别先递归左子树再递归右子树
        if(root.val == toFind){
            return root;
        }
        Node result = null;
        result = find1(root.left,toFind);
        if(result != null){
            //左子树中找到
            return result;
        }
        return find1(root.right,toFind);
    }


    public static void main(String[] args) {
        Node root = build();
        preOrder(root);
        System.out.println();
        System.out.println("================");
        inOrder(root);
        System.out.println();
        System.out.println("================");
        postOrder(root);
        System.out.println();
        size(root);
        System.out.println(treeSize);
        System.out.println(size1(root));
        find(root,'H');
        System.out.println(result);

    }
}
