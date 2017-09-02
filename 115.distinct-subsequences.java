public class Solution {
    public int numDistinct(String s, String t) {
        if (s.length()==0) return 0;
        if (t.length()==0) return 1;
        int[][] dp = new int[t.length()][s.length()+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;
        }
        for (int j = 1; j < dp[0].length; j++) {
            if (s.charAt(j-1)==t.charAt(0)) dp[0][j]=dp[0][j-1]+1;
            else dp[0][j]=dp[0][j-1];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(j-1)==t.charAt(i)) dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                else dp[i][j]=dp[i][j-1];
            }
        }
        return dp[t.length()-1][s.length()];
    }-
}