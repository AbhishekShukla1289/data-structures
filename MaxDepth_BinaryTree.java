class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root == null)
            return 0;
        else{
            
//             int lnode = maxDepth(root.left);
//             int rnode = maxDepth(root.right);
            
//             if(lnode > rnode)
//                 return lnode + 1;
//             else
//                 return rnode + 1;
            
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
            
        }
        
    }
}