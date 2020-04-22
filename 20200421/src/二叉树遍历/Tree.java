package 二叉树遍历;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/21 22:24
 */

public class Tree {
    //定义节点类
    static class Node {
        char val; //数据域
        public Node left;  // 左孩子的引用，常常代表左孩子为根的整棵左子树
        public Node right;  // 右孩子的引用，常常代表右孩子为根的整棵右子树

        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
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
        B.left = D;
        B.right = E;
        E.left = G;
        A.right = C;
        C.right = F;
        return A;
    }
    public static void preOrder(Node root){
        //先访问根节点,先递归访问左子树再递归访问右子树
        //如果是空树，不进行操作
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        //先递归访问左子树,再访问根节点,再递归访问右子树
        //如果是空树，不进行操作
        if(root == null){
            return;
        }
        //访问根的左节点
        inOrder(root.left);
        //访问根节点
        System.out.print(root.val+" ");
        //访问根的右节点
        inOrder(root.right);
    }
    public static void posOrder(Node root){
        //先递归访问左子树,再递归访问右子树,最后访问根节点
        //如果是空树，不进行操作
        if(root == null){
            return;
        }
        //访问根的左节点
        posOrder(root.left);
        //访问根的右节点
        posOrder(root.right);
        //访问根节点
        System.out.print(root.val+" ");
    }
    public static void leveOrder(Node root){
        //如果是空树，不进行操作
        if(root == null){
            return;
        }
        //创建一个队列,初始情况把根节点加入到队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        //2、进入循环，当队列为空时结束循环
        while (!queue.isEmpty()){
            //取出队首元素
            Node cur = queue.poll();
            //访问当前元素
            System.out.print(cur.val+" ");
            //把当前节点左右子树放入队列
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.println("先序遍历：");
        preOrder(root);
        System.out.println();
        System.out.println("中序遍历：");
        inOrder(root);
        System.out.println();
        System.out.println("后序遍历：");
        posOrder(root);
        System.out.println();
        System.out.println("层序遍历：");
        leveOrder(root);
    }
}
