package 找最近公共祖先;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/25 9:18
 */

/*给定两个节点，需要先对树进行遍历，针对每个子树都去查找，看看是否能够找到p、q
如果从某个节点出发，能同时找到p和q两个节点，此时该节点是公共祖先。对某个节点
如果p、q出现在三个位置（根节点、左子树、右子树）的两处（不能同时在左子树和右子树中）*/
public class TreeInterview {
    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) {
        val = x; }
 }
 private TreeNode lca = null;//借助成员变量保存最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        findNode(root, p, q);
        return lca;

    }
    //如果在 root中能够找到p或者q返回true否则false
    private boolean findNode(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        //采取后序遍历形式进行查找
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        //访问根节点
        int mid = (root == p || root == q) ? 1 : 0;

        //三者相加值为2时，意味着三者中两个为1
        //如果同时出现在左子树中，right和mid=0 left=1
        //如果同时出现在右子树中，left和mid=0  right=1
        //出现在左右子树中 left = right = 1  mid=0
        //q在左子树p在根节点 left=1、mid=1 right=0；
        //q在右子树p在根节点 left=0、mid=1 right=1；
        if(left + right + mid ==2){
            lca = root;
        }
        return (left + right + mid) > 0;//找到p或者q返回true 没有找到pq返回false
    }

}
