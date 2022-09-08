class Solution {
    public int numIslands(char[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        int count = 0;
        
        for(int m = 0; m < grid.length; m++){
            for(int n = 0; n < grid[0].length; n++){
                if(grid[m][n] == '1'){
                    q.add(new int[]{m,n});
                    grid[m][n] = '2';
                    
                    while(!q.isEmpty()){
                        
                        int size = q.size();
System.out.println(size);
                        for(int j = 0; j < size; j++){
                            int[] curr = q.poll();

                            for(int i = 0; i < 4; i++){
                                int row = curr[0] + dirs[i][0];
                                int col = curr[1] + dirs[i][1];

                                if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1'){
                                    q.add(new int[]{row, col});
                                    grid[row][col] = '2';
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }
        
        return count;
    }
}