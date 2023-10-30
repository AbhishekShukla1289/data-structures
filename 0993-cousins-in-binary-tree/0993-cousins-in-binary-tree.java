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
    TreeNode x_parent; TreeNode y_parent;
    int x_level; int y_level;
    int X; int Y;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        X = x;
        Y = y;
        dfs(root, null, 0);
        if((x_level == y_level) && (x_parent != y_parent))
            return true;
        return false;
    }
    public void dfs(TreeNode root, TreeNode parent, int level){
        //basic
        if(root == null) return;
        //logic
        if(root.val == X){
            x_level = level;
            x_parent = parent;
        }
        else if(root.val == Y){
            y_level = level;
            y_parent = parent;
        }
        dfs(root.left, root, level+1);
        dfs(root.right, root, level+1);
    }
}