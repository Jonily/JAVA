package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/18 11:30
 */

public class Tree{
    static class Node{
        public Node(char val) {
            this.val = val;
        }

        public char val;
        public Node left;
        public Node right;
    }


    static Node build(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        A.left = B;
        A.right = C;
        B.left = D;
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
    public static void main(String[] args) {
        Node root = build();
        preOrder(root);
    }
}