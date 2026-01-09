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
    class Pair{
        int depth;
        TreeNode node;

        Pair(int depth,TreeNode node){
            this.depth=depth;
            this.node=node;
        }
    }
    Pair solve(TreeNode root){
        if(root==null )return new Pair(0, root);

        Pair leftNode = solve(root.left);
        Pair rightNode = solve(root.right);

        if(leftNode.depth == rightNode.depth)return new Pair(leftNode.depth+1, root);
        else if(leftNode.depth > rightNode.depth)return new Pair(leftNode.depth+1, leftNode.node);
        else return new Pair(rightNode.depth+1, rightNode.node);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
		return solve(root).node;
    }

    //LCA + Depth Approch 
    /*
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

    */
    
}