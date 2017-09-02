public class Solution {
/* o(n),o(1)*/
	public int trap(int[] height){
		int a = 1;
		int b = height.length-2;
		int leftmax = 0;
		int rightmax =0;
		int rain = 0;
		while(a<=b){
			leftmax = Math.max(leftmax,height[a-1]);
			rightmax = Math.max(rightmax, height[b+1]);
			if(leftmax<rightmax){
				rain+=Math.max(leftmax-height[a],0);
				a++;
			}else{
				rain+=Math.max(rightmax-height[b],0);
				b--;	
			}
		}
		return rain;

	}


/* o(n), o(o)
	public int trap(int[] height) {
		if(height.length==0) return 0;
		int[] beforeh = new int[height.length];
		int[] afterh = new int[height.length];
		int[] raini = new int[height.length];
		int result = 0;
		beforeh[0]=0;afterh[height.length-1]=0;
		for(int i=1; i<height.length; i++){
			beforeh[i] = Math.max(height[i-1],beforeh[i-1]);
			afterh[height.length-1-i] = Math.max(height[height.length-1-i+1],afterh[height.length-1-i+1]);
		}
		for(int i=0; i<height.length; i++){
			raini[i] = Math.min(beforeh[i],afterh[i])-height[i];
			result+=Math.max(raini[i],0);
		}
		return result;
	}*/
}
