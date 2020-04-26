package 根据先序和中序构造二叉树;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/25 11:41
 */
    //先序遍历中的第一个节点一定是根节点
    //通过根节点在中序遍历中查找，确定根节点左右的子树都是哪些元素
public class TreeInterview {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    //preorder这个数组和inorder相同
    //用index记录访问到哪个节点
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        index = 0;
        //借助buildTreeHelper方法进行递归
    }

}
