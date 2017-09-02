public class Solution {
	public int climbStairs(int n) {
		if(n<=2) return n;
		int fn1=1,fn2=2,fn3=fn1+fn2;
		for(int i=0; i<n-2; i++){
			fn3 = fn1+fn2;
			fn1 = fn2;
			fn2 = fn3;
		}
		return fn3;
	}
}
