class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        
        while(head < tail){
            int sum = (numbers[head] + numbers[tail]);
            if(sum == target)
                return new int[]{head+1, tail+1};
            else if(sum > target)
                tail--;
            else if(sum < target)
                head++;
        }
        
        return new int[]{-1,-1};
    }
}