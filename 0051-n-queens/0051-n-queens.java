class Solution {
    List<List<String>> res;
    int m;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        m = n;
        board = new int[n][n];
        backtrack(0);
        return res;
    }
    private void backtrack(int r){
        //base
        if(r == m){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < m; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m; j++){
                    if(board[i][j] == 1){
                        sb.append('Q');
                    }
                       else{
                        sb.append('.');
                    }
                }     
                li.add(sb.toString()); 
            }
            res.add(li);
            return;
        }
        //logic
        for(int j = 0; j < m; j++){
            if(isSafe(r, j)){
                board[r][j] = 1;
                backtrack(r+1);
                board[r][j] = 0;  
            }
        }
    }
    private boolean isSafe(int r, int c) {
    // Check for the presence of queens in the same column
    for (int i = 0; i < r; i++) {
        if (board[i][c] == 1)
            return false;
    }

    // Check for the presence of queens in the left diagonal
    int i = r, j = c;
    while (i >= 0 && j >= 0) {
        if (board[i][j] == 1)
            return false;
        i--;
        j--;
    }

    // Check for the presence of queens in the right diagonal
    i = r;
    j = c;
    while (i >= 0 && j < m) {
        if (board[i][j] == 1)
            return false;
        i--;
        j++;
    }

    // Check for the presence of queens in the same row (this check was missing in your code)
    for (int k = 0; k < c; k++) {
        if (board[r][k] == 1)
            return false;
    }

    return true;
}
}