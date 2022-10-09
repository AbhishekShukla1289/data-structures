class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int slow = 0;
        int fast = n-1;
        int max = 0;
        while(slow < fast){
            max = Math.max(max, Math.min(height[slow],height[fast]) * (fast-slow));
            if(height[slow] < height[fast]){
                slow++;
            }
            else{
                fast--;
            }
        }
        return max;
    }
}