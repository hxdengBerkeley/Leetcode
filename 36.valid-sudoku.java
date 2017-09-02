public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> line = new HashSet<>(9);
        Set<Character> column = new HashSet<>(9);
        Set<Character> block = new HashSet<>(9);
        for (int i = 0; i < 9; i++) {
            column.clear();
            line.clear();
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'&&column.contains(board[i][j])){
                    return false;
                }else{
                    column.add(board[i][j]);
                }
                if(board[j][i]!='.'&&line.contains(board[j][i])){
                    return false;
                }else{
                    line.add(board[j][i]);
                }
            }

        }
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                block.clear();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[3*m+i][3*n+j] != '.' && block.contains(board[3*m+i][3*n+j])) {
                            return false;
                        } else {
                            block.add(board[3*m+i][3*n+j]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
