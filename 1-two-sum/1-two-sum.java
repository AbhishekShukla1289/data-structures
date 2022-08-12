class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++){
            int j = target - nums[i];
            if(map.containsKey(j) && i!=map.get(j)){
               return new int[] {i, map.get(j)};
            }
        }
        return null;
    }
}