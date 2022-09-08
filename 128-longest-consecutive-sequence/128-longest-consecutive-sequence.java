class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int max = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i+1] ==  nums[i]){
                continue;
            }
            if((nums[i+1] - nums[i]) == 1){
                count++;
            }
            else{
                max = Math.max(max,count);
                count = 1;
            }
        }
        max = Math.max(max,count);
        return max;
    }
}