package 二叉树的操作;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/22 18:23
 */

public class TreeMake {
    //定义二叉树
    static class Node{
        char val;
        public Node left;// 左孩子的引用，常常代表左孩子为根的整棵左子树
        public Node right;// 右孩子的引用，常常代表右孩子为根的整棵右子树
        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
    //构造二叉树
    static Node build(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        B.left = D;
        B.right = E;
        E.left = G;
        A.right = C;
        C.right = F;
        return A;
    }
    /*static int nodeSize = 0;
    public static void size(Node root){
        if (root == null){
            return;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
    }*/
    //直接通过size的返回值来返回树的节点个数
    public static int size(Node root){
        if (root == null){
            return 0;
        }//空树返回0
        //借助递归 节点个数=根节点+左子树节点+右子树节点个数
        return 1+size(root.left)+size(root.right);
    }
/*
    static int LeafSize = 0;
    public static void leafSize(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            LeafSize++;
            return;
        }
        leafSize(root.left);
        leafSize(root.right);
    }
*/
    public static int leafSize(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        //求当前这个树的叶子节点 = 左子树的叶子节点+右子树的叶子节点
        return leafSize(root.left)+leafSize(root.right);

    }
    public static int klevelSize(Node root,int k){
        if(root == null || k<1){
            return 0;
        }
        if(k == 1){
            //第一层节点数
            return 1;
        }
        //问题拆分：第K层节点数 = 左子树的k-1层节点数+右子树的k-1层节点数
        return klevelSize(root.left,k-1)+klevelSize(root.right,k-1);
    }
    /*//对二叉树进行遍历，依次比较每个节点的值，看和待查找的元素是否相等，相等则找到
    public static Node result = null;
    public static void find(Node root,int toFind){
        if(root == null ){
            return ;
        }
        if(root.val == toFind){
            result = root;
            return;
        }
        find(root.left,toFind);
        find(root.right,toFind);
    }*/

    //返回值表示查找到的节点
    public static Node find(Node root, char toFind){
        if(root == null ){
            return null;
        }
        //先看根节点是不是
        if(root.val == toFind){
            return root;
        }
        //递归找左子树
        Node result = find(root.left,toFind);
        if( result != null){
            //左子树找到，直接返回不用找右子树
            return result;
        }
        //左子树没找到，找右子树
        return find(root.right,toFind);
    }



    public static void main(String[] args) {
        Node root = build();
        System.out.println(size(root));
        System.out.println(leafSize(root));
        System.out.println(klevelSize(root,2));
        System.out.println(find(root,'B'));

    }

}
