class Solution {
    public int maxArea(int[] height) {
       int low = 0;
        int high = height.length - 1;
        int sum = 0;
        int mostWater = 0;
        while(low < high){
            sum = (high - low) * Math.min(height[low], height[high]);
            if(sum > mostWater)
                mostWater = sum;
            if(height[low] < height[high])
                low++;
            else if(height[low] > height[high])
                high--;
            else{
                if((height[low+1] - height[low]) < (height[high]-height[high-1]) )
                    low++;
                else
                    high--;
            }
        }
        return mostWater;
    }
}