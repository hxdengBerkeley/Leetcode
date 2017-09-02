public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j==0) dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                else if (j==i) dp[i][j] = dp[i-1][j-1]+triangle.get(i).get(j);
                else dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
            }
        }
        int min = dp[dp.length-1][0];
        for (int x:dp[dp.length-1]) {
            min = Math.min(min,x);
        }
        return min;
    }
}