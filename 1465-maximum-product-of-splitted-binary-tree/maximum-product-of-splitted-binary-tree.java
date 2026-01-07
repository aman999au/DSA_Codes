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
    long SUM=0;
     long maxP = 0;
    static int MOD = 1000_000_007;
    private long totalSum(TreeNode root){
        if(root==null)return 0;
        return root.val + totalSum(root.left)+totalSum(root.right); 
    }

    private long getSubTreeSum(TreeNode root){
       if(root==null)return 0;
       long left = getSubTreeSum(root.left);
        long right= getSubTreeSum(root.right);

        long subTreeSum = left+right+root.val;
        long prod = subTreeSum * (SUM-subTreeSum);
        maxP = Math.max(maxP,prod);
        return subTreeSum;
    }
    
    public int maxProduct(TreeNode root) {
        if(root==null)return 0;
        
        SUM = totalSum(root);
        getSubTreeSum(root);

        return (int)(maxP % MOD);
    }
}