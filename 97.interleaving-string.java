public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        for (int i = 1; i < s1.length()+1; i++) {
            dp[i][0] = dp[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }
        for (int i = 1; i < s2.length()+1; i++) {
            dp[0][i] = dp[0][i-1]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                dp[i][j] = (dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }


    /** too slow
    public boolean isInter(String s1, String s2, String s3, int i, int j, int k){
        if (k==s3.length()&&i==s1.length()&&j==s2.length()){
            return true;
        }
        boolean a = (i<s1.length()&&s1.charAt(i)==s3.charAt(k));
        boolean b = (j<s2.length()&&s2.charAt(j)==s3.charAt(k));
        if (a&&b) {
            return isInter(s1, s2, s3, i + 1, j, k + 1) || isInter(s1, s2, s3, i, j + 1, k + 1);
        }else if (a&&!b) {
            return isInter(s1, s2, s3, i + 1, j, k + 1);
        }else if (!a&&b) {
            return isInter(s1, s2, s3, i, j + 1, k + 1);
        }else{
            return false;
        }
    }*/
}