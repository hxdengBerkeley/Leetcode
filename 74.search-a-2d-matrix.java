public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0||matrix[0].length==0) return false;
		int i,j,k;
		i = 0; j = matrix.length-1; k = (i+j)/2;
		while(i<=j){
			k=(i+j)/2;
			if (matrix[k][0]<=target&&matrix[k][matrix[0].length-1]>=target) break;
			if (matrix[k][0]>target){
				j=k-1;
				continue;
			}
			if (matrix[k][matrix[0].length-1]<target){
				i=k+1;
				continue;
			}
		}
		int row = k;
		if(!(matrix[row][0]<=target&&matrix[row][matrix[0].length-1]>=target)) return false;
		i=0; j=matrix[0].length-1;
		while(i<=j){
			k=(i+j)/2;
			if(matrix[row][k]==target) return true;
			if(matrix[row][k]<target){
				i=k+1;
				continue;
			}else{
				j=k-1;
				continue;
			}
		}
		return false;
	}
}
