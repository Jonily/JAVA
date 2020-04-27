package 根据中序和后序构造二叉树;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/28 0:11
 */

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
    public TreeNode buildTree(int[] inorder, int[] posorder){
        index = 0;
        int[] posorder1 = new int[posorder.length];
        for(int i = 0; i < posorder.length; i++){
            posorder1[i] = posorder[posorder.length-i-1];
        }
        return buildTreeHelper(posorder1,inorder,0,inorder.length);
    }
    private TreeNode buildTreeHelper(int[] posorder1, int[] inorder, int inorderLeft, int inorderRight) {
        if(inorderLeft >= inorderRight){
            return null;
        }
        if(index >= posorder1.length){
            return null;
        }
        TreeNode newNode = new TreeNode(posorder1[index]);
        int pos = find(inorder,inorderLeft,inorderRight,newNode.val);
        index++;//只++一次
        newNode.right = buildTreeHelper(posorder1,inorder,pos+1,inorderRight);
        newNode.left = buildTreeHelper(posorder1,inorder,inorderLeft,pos);
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
