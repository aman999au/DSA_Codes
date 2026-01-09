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
    
   public int maxDepth = -1;
    public Map<Integer,Integer>mp = new HashMap<>();
	
    public void depth(TreeNode root,int d){
		if(root==null)return ;
        maxDepth = Math.max(maxDepth, d);
        mp.put(root.val, d);
        depth(root.left, d+1);
        depth(root.right, d+1);
	}

    public TreeNode LCA(TreeNode root){
        if(root==null || mp.get(root.val)==maxDepth)return root;

        TreeNode leftNode = LCA(root.left);
        TreeNode rightNode = LCA(root.right);

        if(leftNode!=null && rightNode!=null)return root;
        
        return leftNode!=null? leftNode:rightNode;
    }

	 public TreeNode subtreeWithAllDeepest(TreeNode root) {
		depth(root, 0);
        return LCA(root);
    }
    
}