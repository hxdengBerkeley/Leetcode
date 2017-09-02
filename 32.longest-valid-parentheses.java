public class Solution {
    public int longestValidParentheses(String s) {
		if (s.length() < 2) return 0;
		int[] longesti = new int[s.length()+1];
		int max = 0;
		for (int i = 0; i < longesti.length; i++) {
			longesti[i] = 0;
		}

		for (int i = 2; i < longesti.length; i++) {
			if(s.charAt(i-1)=='('){
				longesti[i]=0;
			}else {
				if(s.charAt(i-2)=='(') {
					longesti[i]=longesti[i-2]+2;
				}else {
					int index = i-2-longesti[i-1];
					if(index<0||s.charAt(index)==')') {
						longesti[i]=0;
					}else {
						longesti[i]=longesti[i-1]+2+longesti[index];
					}
				}
			}
			max = Math.max(max,longesti[i]);
		}
		return max;
	}
}
