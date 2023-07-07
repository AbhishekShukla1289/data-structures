class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target) return 0;
        if(nums.length == 1 && nums[0] != target) return -1;
        int n = nums.length;
        int mid = 0;
        int high = n-1;
        int low = 0;
        
        while(low <= high){
            mid = (high + low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
        }
        return -1;
    }
}