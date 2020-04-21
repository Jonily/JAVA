package 二叉树遍历;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/21 22:24
 */

public class Tree {
    //定义节点类
    static class Node {
        int val; //数据域
        public Node left;  // 左孩子的引用，常常代表左孩子为根的整棵左子树
        public Node right;  // 右孩子的引用，常常代表右孩子为根的整棵右子树

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }
    static Node build(){
        
    }
}
