class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] prodExcept = new int[nums.length];
        int running_product = 1;
        for(int i = 0; i < nums.length; i++){
            prodExcept[i] = running_product;
            running_product = running_product * nums[i];
        }
        running_product = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            prodExcept[i] = prodExcept[i] * running_product;
            running_product = running_product * nums[i];
        }
        return prodExcept;
    }
}