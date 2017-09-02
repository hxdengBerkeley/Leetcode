public class Solution {
    public void solve(char[][] board) {
        if (board==null||board.length==0||board[0].length==0) return;
        int l1 = board.length,l2 = board[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < l1; i++) {
            if (board[i][0]=='O') set.add(l2*i);
            if (board[i][l2-1]=='O') set.add(l2*i+l2-1);
        }
        for (int i = 0; i < l2; i++) {
            if (board[0][i]=='O') set.add(i);
            if (board[l1-1][i]=='O') set.add((l1-1)*l2+i);
        }
        Queue<Integer> queue = new ArrayDeque<>(set);
        while (!queue.isEmpty()){
            int hashcode = queue.poll();
            int i = hashcode/l2, j = hashcode%l2;
            if (i-1>=0&&i-1<l1&&j>=0&&j<l2&&board[i-1][j]=='O'&&!set.contains((i-1)*l2+j)){
                set.add((i-1)*l2+j);
                queue.add((i-1)*l2+j);
            }
            if (i+1>=0&&i+1<l1&&j>=0&&j<l2&&board[i+1][j]=='O'&&!set.contains((i+1)*l2+j)){
                set.add((i+1)*l2+j);
                queue.add((i+1)*l2+j);
            }
            if (i>=0&&i<l1&&j-1>=0&&j-1<l2&&board[i][j-1]=='O'&&!set.contains(i*l2+j-1)){
                set.add(i*l2+j-1);
                queue.add(i*l2+j-1);
            }
            if (i>=0&&i<l1&&j+1>=0&&j+1<l2&&board[i][j+1]=='O'&&!set.contains(i*l2+j+1)){
                set.add(i*l2+j+1);
                queue.add(i*l2+j+1);
            }
        }
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (set.contains(i*l2+j)) board[i][j]='O';
                else board[i][j]='X';
            }
        }
    }
}