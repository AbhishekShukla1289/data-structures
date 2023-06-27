class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i= 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList());
            map.get(nums[i]).add(i);
        }
        
        List<List<Integer>> valList = new ArrayList<>(map.values());
        
        for(int i = 0; i < valList.size(); i++){
            for(int j = 0; j < valList.get(i).size() - 1; j++){
                if(valList.get(i).get(j+1) - valList.get(i).get(j) <= k)
                    return true;
            }
        }
        
        return false;
    }
}