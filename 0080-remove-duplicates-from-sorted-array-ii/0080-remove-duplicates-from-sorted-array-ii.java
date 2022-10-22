class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int slow = 0;
        int fast = 0;
        
        
        
        for(int i = 0; i < nums.length; i++){
            
            if(fast != 0 && nums[fast] != nums[fast-1]){
                count = 1;
            }
            if(count <= 2){
                nums[slow] = nums[fast];
                count++;
                slow++;
            }
            fast++;
        }
        return slow ;
    }
}