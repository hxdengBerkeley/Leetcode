public class Solution {
    public int numTrees(int n) {
        int[][] set = new int[n+1][n+1];
        return numBST(1,n,set);
    }

    public int numBST(int start, int end, int[][] set){
        if (start>=1&&start<set.length&&end>=1&&end<set.length&&set[start][end]!=0) return set[start][end];
        int result=0;
        if (start>=end){
            result=1;
        }else {
            for (int i = start; i<=end; i++){
                result+=numBST(start,i-1,set)*numBST(i+1,end,set);
            }
            set[start][end]=result;
        }
        return result;
    }
}