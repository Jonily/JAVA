package 迭代实现二叉树后序;

import 迭代实现二叉树先序.InOrder;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/26 20:46
 */

public class LastOrder {
    public class Tree {
        int val;
        InOrder.Tree left;
        InOrder.Tree right;

        Tree(int x) {
            val = x;
        }

    }
    public void lastOrder(InOrder.Tree root){
        if(root == null){
            return;
        }

    }
}
