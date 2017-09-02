public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if(matrix.length==0) return result;
		int m = matrix.length;
		int n = matrix[0].length;
		for(int layer=0; layer<(Math.min(m,n)+1)/2;layer++){
			int i = layer, j=layer;
			if(i==m-layer-1){
				while(j<n-layer){
					result.add(matrix[i][j]);
					j++;
				}
				break;
			}else if(j==n-layer-1) {
				while(i<m-layer){
					result.add(matrix[i][j]);
					i++;
				}
				break;
			}else {
				while(j<n-layer-1){
					result.add(matrix[i][j]);
					j++;
				}
				while(i<m-layer-1){
					result.add(matrix[i][j]);
					i++;
				}
				while(j>layer){
					result.add(matrix[i][j]);
					j--;
				}
				while(i>layer){
					result.add(matrix[i][j]);
					i--;
				}
			}
		}
		return result;
	}
}
