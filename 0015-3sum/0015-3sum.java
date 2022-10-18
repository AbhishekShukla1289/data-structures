class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> li = new ArrayList<>();
        if(nums == null || nums.length == 0) return li;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
                int head = i+1;
                int tail = nums.length -1;
                while(head < tail){
                    if(nums[i] + nums[head] + nums[tail] > 0){
                        tail--;
                        
                    }
                    else if(nums[i] + nums[head] + nums[tail] < 0){
                        head++;
                    }
                    else if(nums[i] + nums[head] + nums[tail] == 0){
                        List<Integer> tmp = Arrays.asList(nums[i], nums[head], nums[tail]);
                        li.add(tmp);
                        head++;
                        tail--;
                        while(head < tail && nums[head] == nums[head - 1]) head++;
                        while(head < tail && nums[tail] == nums[tail + 1]) tail--;
                    }
                }
        }
        return li;
    }
}