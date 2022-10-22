class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = n-1;
        
        while(j >=0 && i < m){
            if(matrix[i][j] == target) return true;
            
            if(target < matrix[i][j]){
                j--;
            }else if(target > matrix[i][j]){
                i++;
            }
        }
        
        return false;
    }
}