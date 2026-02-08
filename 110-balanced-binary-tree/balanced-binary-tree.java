/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   private int height(TreeNode node){
		if(node==null)return 0;
		int lh =height(node.left);
		int lr =height(node.right);

		return Math.max(lh, lr)+1;
	}
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true; 
		int lH = height(root.right);
		int rH = height(root.left);

		if(Math.abs(rH-lH)>1)return false;
		return isBalanced(root.left) && isBalanced(root.right);
       
    }
}