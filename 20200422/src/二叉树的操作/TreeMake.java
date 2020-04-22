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
    static int nodeSize = 0;
    public static void size(Node root){
        if (root == null){
            return;
        }
        nodeSize++;
        size(root.left);
        size(root.right);

    }

    public static void main(String[] args) {
        Node root = build();
        size(root);
        System.out.println(nodeSize);
    }

}
