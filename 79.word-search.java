public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[] result=new boolean[1];
        result[0]=false;
        HashSet<Integer> set = new HashSet<>();
        existi(board, set,word,0,0,0,result);
        return result[0];
    }

    public void existi(char[][] board, HashSet<Integer> set, String word, int x, int y, int index, boolean[] result) {
        if (!result[0]){
            if (index==word.length()){
                result[0] = true;
                return;
            }
            if (index==0){
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[0].length; j++) {
                        if(board[i][j]==word.charAt(0)){
                            HashSet<Integer> seti = new HashSet<>();
                            seti.add(i*board[0].length+j);
                            existi(board,seti,word,i,j,index+1,result);
                        }
                    }
                }
            }
            if (index>0){
                if (x-1>=0 && !set.contains((x-1)*board[0].length+y)&& board[x-1][y]==word.charAt(index)){
                    HashSet<Integer> seti = new HashSet<>(set);
                    seti.add((x-1)*board[0].length+y);
                    existi(board,seti,word,x-1,y,index+1,result);
                }
                if (y+1<board[0].length && !set.contains((x)*board[0].length+(y+1)) && board[x][y+1]==word.charAt(index)){
                    HashSet<Integer> seti = new HashSet<>(set);
                    seti.add((x)*board[0].length+(y+1));
                    existi(board,seti,word,x,y+1,index+1,result);
                }
                if (x+1<board.length && !set.contains((x+1)*board[0].length+(y)) && board[x+1][y]==word.charAt(index)){
                    HashSet<Integer> seti = new HashSet<>(set);
                    seti.add((x+1)*board[0].length+(y));
                    existi(board,seti,word,x+1,y,index+1,result);
                }
                if (y-1>=0 && !set.contains((x)*board[0].length+(y-1)) && board[x][y-1]==word.charAt(index)){
                    HashSet<Integer> seti = new HashSet<>(set);
                    seti.add((x)*board[0].length+(y-1));
                    existi(board,seti,word,x,y-1,index+1,result);
                }
            }
        }
    }
}