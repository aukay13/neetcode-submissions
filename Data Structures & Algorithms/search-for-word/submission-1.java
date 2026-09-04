class Solution {
    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(func(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean func(char[][] board, String word, int currIndex,int i, int j){
        if(currIndex==word.length()){
            return true;
        }

        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j]=='0'){
            return false;
        }

        if(board[i][j]==word.charAt(currIndex)){
            char original = board[i][j];
            board[i][j]='0';
            boolean ans = func(board, word, currIndex+1, i+1, j) ||
            func(board, word, currIndex+1, i-1, j) ||
            func(board, word, currIndex+1, i, j+1) ||
            func(board, word, currIndex+1, i, j-1);
            board[i][j] = original;
            return ans;
        }
        return false;
    }

}
