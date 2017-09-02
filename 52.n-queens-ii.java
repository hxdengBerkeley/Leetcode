public class Solution {
    public int totalNQueens(int n){
        List<List<String>> solutions = new ArrayList<>();
        int[][] chessboard = new int[n][n];
        backtracking(solutions,chessboard,0);
        return solutions.size();
    }

    public void backtracking(List<List<String>> solutions, int[][] chessboard, int line){
        if(line==chessboard.length) {
            solutions.add(Array2List(chessboard));
        }else {
            for (int i = 0; i < chessboard.length; i++) {
                if (isValid(chessboard,line,i)){
                    int[][] chessboardi = new int[chessboard.length][chessboard.length];
                    for (int j = 0; j < chessboard.length; j++) {
                        chessboardi[j] = chessboard[j].clone();
                    }
                    chessboardi[line][i]=1;
                    backtracking(solutions,chessboardi,line+1);
                }
            }
        }
    }

    public boolean isValid(int[][] chessboard, int x, int y){
        for (int i = 0; i < chessboard.length; i++) {
            if (chessboard[i][y] == 1) return false;
        }
        for (int i = Math.max(0,x-y); i < Math.min(chessboard.length,chessboard.length+(x-y)); i++) {
            int j = i-(x-y);
            if (chessboard[i][j]==1) return false;
        }
        for (int i = Math.max(0,x+y-chessboard.length+1); i < Math.min(chessboard.length,x+y+1); i++) {
            int j = -i+(x+y);
            if (chessboard[i][j]==1) return false;
        }
        return true;
    }

    public List<String> Array2List(int[][] cheeseboard){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < cheeseboard.length; i++) {
            String line = "";
            for (int j = 0; j < cheeseboard.length; j++) {
                if(cheeseboard[i][j]==0) {
                    line+='.';
                    continue;
                }
                if(cheeseboard[i][j]==1) {
                    line+='Q';
                    continue;
                }
            }
            result.add(line);
        }
        return result;
    }
}
