class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    String number = board[i][j]+"";
                    if(!hs.add(number+" row "+i) || 
                        !hs.add(number+" col "+j) || 
                        !hs.add(number+" block "+i/3+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
