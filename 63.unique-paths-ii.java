public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] result = new int[m+1][n+1];
        result[0][1]=1;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (obstacleGrid[i-1][j-1]==1){
                    result[i][j]=0;
                }else {
                    result[i][j]=result[i-1][j]+result[i][j-1];
                }
            }
        }
        return result[m][n];
    }
}
