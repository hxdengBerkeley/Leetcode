public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int number=1;
        for(int layer=0; layer<=(n-1)/2; layer++) {
            if (layer==n-layer-1){
                result[layer][layer]=number;
                break;
            }else {
                int i = layer, j =layer;
                while(j<n-layer-1){
                    result[i][j]=number;
                    number++;
                    j++;
                }
                while(i<n-layer-1){
                    result[i][j]=number;
                    number++;
                    i++;
                }
                while(j>layer){
                    result[i][j]=number;
                    number++;
                    j--;
                }
                while(i>layer){
                    result[i][j]=number;
                    number++;
                    i--;
                }
            }
        }
        return result;
    }
}