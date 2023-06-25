class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] runProd = new int[nums.length];
        int[] revRunProd = new int[nums.length];
        int[] res = new int[nums.length];
        
        int n = nums.length;
        
        runProd[0] = nums[0];
        revRunProd[n-1] = nums[n-1];
        
        for(int i = 1; i < nums.length; i++){
            runProd[i] =  runProd[i-1] * nums[i];
        }
        for(int j = n-2; j > 0; j--){
            revRunProd[j] = revRunProd[j+1] * nums[j];
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i == 0)
                res[i] = revRunProd[i+1];
            else if(i == n-1)
                res[n-1] = runProd[n-2];
            else
                res[i] = runProd[i-1] * revRunProd[i+1];
        }
        return res;
    }
}