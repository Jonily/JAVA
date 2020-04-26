package 迭代实现二叉树中序;


import java.util.Stack;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/26 20:45
 */

public class MidOrder {
    public class Tree {
        int val;
        Tree left;
        Tree right;


    }
    public void midOrder(Tree root){
        if(root == null){
            return;
        }
        Stack<Tree> stack = new Stack<>();
        Tree cur = root;
        while (cur != null){
            //1、cur一直往左走循环入栈直到cur为空
            stack.push(cur);
            cur = cur.left;
        }


    }
}
