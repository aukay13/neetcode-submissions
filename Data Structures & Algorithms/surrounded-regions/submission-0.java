class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1){
                    dfs(i, j, board);
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='S'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }

    public void dfs(int r, int c, char[][] board){

        if(board[r][c]=='S'){
            return;
        }

        if(board[r][c]=='O'){

            board[r][c] = 'S';
            if(r-1>=0){
                dfs(r-1, c, board);
            }
            if(r+1<board.length){
                dfs(r+1, c, board);
            }
            if(c-1>=0){
                dfs(r, c-1, board);
            }
            if(c+1<board[0].length){
                dfs(r, c+1, board);
            }
            
        }

    }
}