package 二叉树转换成排序的双向链表;



/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/25 9:59
 */

public class TreeInterview {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        //f返回值含义表示链表头结点
        public TreeNode Convert(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.left == null && root.right == null) {
                return root;
            }
            //递归处理左子树
            TreeNode left = Convert(root.left);
            //处理根节点，把根节点追加到左子树链表的末尾
            TreeNode leftTail = left;//left指向链表头定义leftTail指向left
            while (leftTail != null && leftTail.right != null) {
                leftTail = leftTail.right;
            }
            //循环结束后，leftTail就是left这个链表的的最后一个节点
            //把根节点插入到最后一个
            if (leftTail != null) {//如果left没有左子树则leftTail为空
                leftTail.right = root;
                root.left = leftTail;
            }
            //递归处理右子树
            TreeNode right = Convert(root.right);
            if (leftTail != null) {
                //根节点和右子树连接一起
                root.right = right;
                right.left = root;
            }
            //返回链表头结点
            return left != null ? left : root;
        }
    }
}
