public class Solution {
	public int mySqrt(int x) {
		if(x==0)	return 0;
		int left=1,right=(int)Math.sqrt(Integer.MAX_VALUE),result=(left+right)/2;
		while(left<=right){
			result=(left+right)/2;
			if (result*result<=x&&(result+1)*(result+1)>x){
				return result;
			}else{
				if (result*result>x){
					right=result-1;
					continue;
				}else {
					left=result+1;
					continue;
				}
			}
		}
		result=(left+right)/2;
		return result;
	}
}
