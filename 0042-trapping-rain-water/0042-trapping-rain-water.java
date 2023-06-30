class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 2 ) return 0;
        int n = height.length;
        int l = 0;
        int lw = 0;
        int rw = 0;
        int r = n - 1;
        int result = 0;
        while(l <= r){
            if(lw <= rw){
                if(lw > height[l]){
                    result += lw - height[l];         
                }
                else{
                    lw = height[l];
                }
                l++;
            }
            else{
                if(rw > height[r]){
                    result += rw - height[r];         
                }
                else{
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }  
}