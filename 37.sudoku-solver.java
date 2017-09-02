public class Solution {
    public void solveSudoku(char[][] board) {
        solved(board);
    }
    public boolean solved(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.'){
                    for (char c = '1'; c <= '9'; c++) {
                        if(valid(board,i,j,c)) {
                            board[i][j]=c;
                            if(solved(board)){
                                return true;
                            }else{
                                board[i][j]='.';
                                continue;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean valid(char[][] board, int m, int n, char c){
        for (int i = 0; i < 9; i++) {
            if (board[i][n] == c) return false;
        }
        for (int j = 0; j < 9; j++) {
            if (board[m][j] == c) return false;
        }
        int p = m/3*3, q = n/3*3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[p+i][q+j]==c) return false;
            }
        }
        return true;
    }
}