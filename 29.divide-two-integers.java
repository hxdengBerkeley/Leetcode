public class Solution {
    public int divide(int dividend, int divisor) {
		if(divisor==0) return Integer.MAX_VALUE;
		double sign=1;
		if(dividend<0) sign =-sign;
		if(divisor<0)	sign= -sign;

		long dividend_l = Math.abs((long)dividend);
		long divisor_l = Math.abs((long)divisor);

		long left,right,multiple;
		long result=0;
		while(Long.compare(dividend_l,divisor_l)>=0){
			left = divisor_l;
			right = left+left;
			multiple=1;
			while(Long.compare(right,dividend_l)<0){
				left+=left;
				multiple +=multiple;
				right = left+left;
			}
			dividend_l-=left;
			result+=multiple;
		}
		return (int)Math.min(sign*result,Integer.MAX_VALUE);
    }
}
