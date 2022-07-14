class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] array = new int[mat.length * mat[0].length];
        //array[0] = mat[0][0];
        int dir = 1;
        int i = 0, j = 0, k = 0;
        while(k < mat.length * mat[0].length)
        {
            System.out.println(i+" "+j);
            array[k] = mat[i][j];
            k++;
            
            if(dir == 1){
                
                if(i == 0 && j == mat[0].length-1){
                    i++;
                    dir = -1;
                }
                else if(i == 0 ){
                    j++;
                    dir = -1;
                }
                else if(j == mat[0].length-1){
                    i++;
                    dir = -1;
                }
                else{ i--; j++;}
            }
            else if(dir == -1){
               // array[k] = mat[i][j];
                //k++;
                if(j==0 && i==mat.length-1){
                    j++;
                    dir = 1;
                }
                else if(j==0){
                    i++;
                    dir = 1;
                }
                else if(i==mat.length-1){
                    j++;
                    dir = 1;
                }
                else{i++;j--;}
                }
        }
        return array;
    }
}