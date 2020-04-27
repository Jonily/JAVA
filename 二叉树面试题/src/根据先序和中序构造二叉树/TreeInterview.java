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
    }

    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        index = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }
        private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if(inorderLeft >= inorderRight){
            return null;
        }
        if(index >= preorder.length){
            return null;
        }
            TreeNode newNode = new TreeNode(preorder[index]);
            int pos = find(inorder,inorderLeft,inorderRight,newNode.val);//在中序遍历中找到节点的下标
            index++;//只++一次
            newNode.left = buildTreeHelper(preorder,inorder,inorderLeft,pos);
            newNode.right = buildTreeHelper(preorder,inorder,pos+1,inorderRight);
            return newNode;
    }
    private int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for(int i = inorderLeft;i < inorderRight; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}


