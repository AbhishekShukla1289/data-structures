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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root);
    }
    
    private int dfs(TreeNode root){
        // base case: if the node is null, return a large value to ensure it's not chosen as the min
        if(root == null) return Integer.MAX_VALUE;
        
        // if the node is a leaf node, return 1
        if(root.left == null && root.right == null) return 1;
        
        // find the min depth of the left and right subtrees
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        
        // return the minimum of the two depths plus one for the current node
        return 1 + Math.min(leftDepth, rightDepth);
    }
}
