package 二叉树平衡性检查;

import java.util.*;


 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Balance {
     public int Max(TreeNode root){
         if(root == null){
             return 0;
         }
         if(root.left == null && root.right== null){
             return 1;
         }
         int left = Max(root.left);
         int right = Max(root.right);
         return (left > right ? left: right)+1;

     }
    public boolean isBalance(TreeNode root) {
         if(root == null){
             return true;
         }
         if(root.left == null && root.right==null){
             return true;
         }
         int left = Max(root.left);
         int right = Max(root.right);
         int flag = Math.abs(left - right);
         return flag <= 1 && isBalance(root.left)&& isBalance(root.right);
    }
}