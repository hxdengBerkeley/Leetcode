public class Solution {
    public void rotate(int[][] matrix) {
	diagonalRoll(matrix);
    	updown(matrix);
    }

	public void updown(int[][] matrix){
		for(int i=0; i<matrix.length/2; i++){
			for(int j=0; j<matrix.length;j++){
				swap(matrix,i,j,matrix.length-1-i,j);
			}
		}
	}
	public void diagonalRoll(int[][] matrix){
		for(int i=0; i<matrix.length-1;i++){
			for(int j=0; j<matrix.length-1-i; j++){
				swap(matrix, i, j, matrix.length-1-j, matrix.length-1-i);
			}
		}
	}
	public void swap(int[][] matrix, int i, int j, int m, int n){
		int temp = matrix[i][j];
		matrix[i][j]=matrix[m][n];
		matrix[m][n]=temp;
	}

	

	
}
