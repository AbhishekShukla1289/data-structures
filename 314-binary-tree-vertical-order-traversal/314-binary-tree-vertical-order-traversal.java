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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        hm.put(root.val, 0);
        res.add(new ArrayList<>(){{add(root.val);}});
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int currIndex = hm.get(curr.val);
            
            if(curr.left != null){
                if(currIndex - 1 < 0){
                    res.add(0, new ArrayList<>(){{add(curr.left.val);}});
                    hm.put(curr.left.val, 0);
                    //increment all values in hm 
                    for(Map.Entry element: hm.entrySet()){
                        int k = (int) element.getKey();
                        int v = (int) element.getValue();
                        if(k != curr.left.val)
                            hm.put(k, v+1);  
                    }
                    currIndex = hm.get(curr.val);
                } else {
                    List<Integer> li = res.get(currIndex - 1);
                    li.add(curr.left.val);
                    hm.put(curr.left.val, currIndex - 1);
                }
                
                q.add(curr.left);
            }
            
            if(curr.right != null){
                int size = res.size();
                if(currIndex + 1 >= size){
                    res.add(size, new ArrayList<>(){{add(curr.right.val);}});
                    hm.put(curr.right.val, size);
                } else {
                    List<Integer> li = res.get(currIndex + 1);
                    li.add(curr.right.val);
                    hm.put(curr.right.val, currIndex + 1);
                }
                
                q.add(curr.right);
            }
        }
        
        return res;
    }
}