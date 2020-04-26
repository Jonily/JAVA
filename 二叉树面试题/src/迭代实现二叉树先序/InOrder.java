package 迭代实现二叉树先序;

import 根据先序和中序构造二叉树.TreeInterview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/26 20:28
 */

public class InOrder {
    static class Node {
        char val; //数据域
        public Node left;  // 左孩子的引用，常常代表左孩子为根的整棵左子树
        public Node right;  // 右孩子的引用，常常代表右孩子为根的整棵右子树

        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    public void inOrder(Node root){
            if(root == null){
                return;
            }
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                Node top = stack.pop();
                System.out.println(root.val);
                if(top.right != null){
                    stack.push(top.right);
                }
                if(top.left != null){
                    stack.push(top.left);
                }
            }
        }
    }
}
